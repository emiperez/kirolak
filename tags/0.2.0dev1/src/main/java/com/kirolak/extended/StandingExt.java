package com.kirolak.extended;

import java.util.Iterator;

import org.hibernate.LazyInitializationException;

import com.kirolak.Round;
import com.kirolak.Standing;
import com.kirolak.StandingId;
import com.kirolak.Team;
import com.kirolak.dao.StandingDAO;
import com.kirolak.dao.TeamDAO;

public class StandingExt
{
	/**
	 * Creates empty rows for each team of a group in the standings table for a given round
	 * @param round
	 */
	public static void create(Round round)
	{
		Iterator teams;
		try
		{
			teams = round.getGroup().getTeams().iterator();
		}
		//TODO: try to figure out why this exception is thrown
		catch(LazyInitializationException le)
		{
			teams = TeamDAO.listByGroup(round.getGroup()).iterator();
		}
		while(teams.hasNext())
		{
			Standing standing = new Standing();
			standing.setId(new StandingId((Team)teams.next(),round));
			StandingDAO.save(standing);
		}
	}
}
