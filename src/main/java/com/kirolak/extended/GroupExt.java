package com.kirolak.extended;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.hibernate.LazyInitializationException;

import com.kirolak.Group;
import com.kirolak.KirolakObject;
import com.kirolak.Match;
import com.kirolak.Round;
import com.kirolak.RoundId;
import com.kirolak.Team;
import com.kirolak.dao.TeamDAO;

public class GroupExt
{
	public static List<Round> calculateSchedule(Group group)
	{
		List<Round> roundList = new ArrayList<Round>();
		List<KirolakObject> teamList = new ArrayList<KirolakObject>();
		try
		{
			Iterator<Team> teamIterator = group.getTeams().iterator();
			while(teamIterator.hasNext())
			{
				teamList.add(teamIterator.next());
			}
		}
		//TODO: Find out why this Exception is happening
		catch(LazyInitializationException lazy)
		{
			teamList = TeamDAO.listByGroup(group);
		}
		int teamCount = teamList.size();
		if (teamCount > 0)
		{
			// Round-Robin Algorithm
			
			Team firstTeam = (Team)teamList.get(0);
			teamList.remove(0);
			// Add a Null team if the number of teams is not an even number
			if((teamCount % 2) > 0)
			{
				teamList.add(null);
				++teamCount;
			}
			
			// The number of rounds
			int beginTeam = (new Random()).nextInt(teamCount);
			short roundNumber = 1;
			while(roundNumber < teamCount)
			{
				Round currentRound = new Round(new RoundId(roundNumber,group));
				
				Match match = new Match();
				
				// Rotate Home - visiting for the first Team
				if(roundNumber % 2 == 0)
				{
					match.setHomeTeam(firstTeam);
					match.setVisitingTeam((Team)teamList.get( (roundNumber+beginTeam)%(teamCount-1) ));
				}
				else
				{
					match.setHomeTeam((Team)teamList.get( (roundNumber+beginTeam)%(teamCount-1) ));
					match.setVisitingTeam(firstTeam);
				}
				currentRound.addMatch(match);
			
				for (int teamNumber = 1; teamNumber < (teamCount)/2; teamNumber++)
				{
					match = new Match();
					
					// Rotate Home - visiting for the each Team
					if(roundNumber % 2 == 0)
					{
						match.setHomeTeam((Team)teamList.get( (roundNumber + beginTeam + teamNumber) % (teamCount-1) ));
						match.setVisitingTeam((Team)teamList.get( (roundNumber + teamCount + beginTeam - teamNumber -1 )%(teamCount-1)));
					}
					else
					{
						match.setHomeTeam((Team)teamList.get( (roundNumber + teamCount + beginTeam - teamNumber -1  )%(teamCount-1) ));
						match.setVisitingTeam((Team)teamList.get( (roundNumber + beginTeam + teamNumber) % (teamCount-1) ));
					}
					currentRound.addMatch(match);
				}
				roundList.add(currentRound);
				++roundNumber;
			}
			
			// When the same teams play more than once in the current stage.
			for(int n=1;n < group.getStage().getMatches(); n++)
			{
				// Rounds per encounter
				for(int i=0 ; i<(teamCount-1) ; i++)
				{
					Round round = new Round(new RoundId(roundNumber,group));
					List<Match> newMatches = new ArrayList<Match>();
					Iterator<Match> iterator = roundList.get(i).getMatches().iterator();
					while(iterator.hasNext())
					{
						Match newMatch = new Match();
						Match currentMatch = iterator.next();
						// Rotate home / visiting for Even encounters.
						if(n % 2 > 0)
						{
													
							newMatch.setHomeTeam(currentMatch.getVisitingTeam());
							newMatch.setVisitingTeam(currentMatch.getHomeTeam());
						}
						else
						{
							newMatch.setHomeTeam(currentMatch.getHomeTeam());
							newMatch.setVisitingTeam(currentMatch.getVisitingTeam());
						}
						newMatches.add(newMatch);
					}
					round.setMatches(newMatches);
					roundList.add(round);
					roundNumber++;
				}
			}
		}
		return roundList;
	}
}
