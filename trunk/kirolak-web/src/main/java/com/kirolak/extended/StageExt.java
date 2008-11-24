package com.kirolak.extended;

import java.util.List;
import java.util.Random;

import com.kirolak.Group;
import com.kirolak.KirolakObject;
import com.kirolak.Stage;
import com.kirolak.Team;
import com.kirolak.dao.GroupDAO;
import com.kirolak.dao.TeamDAO;

public class StageExt
{
	public static void calculateGroups(Stage stage, int groupNumber)
	{
		List<KirolakObject> selectableTeams = TeamDAO.listByCompetition(stage.getCompetition());
		int totalTeams = selectableTeams.size();
		int teamsPerGroup = totalTeams/groupNumber;
		int extraTeams = totalTeams%groupNumber;
		for (char n = 0; n < groupNumber; n++)
		{
			Group group = new Group();
			group.setStage(stage);
			group.setName(new Character((char)(n+65)).toString());
			GroupDAO.save(group);
		}
		List<KirolakObject> groups = GroupDAO.listByStage(stage);
		for (int n =0; n < groups.size(); n++)
		{
			Group group = (Group)groups.get(n);
			int teamsInCurrentGroup = teamsPerGroup;
			if(n < extraTeams)
			{
				teamsInCurrentGroup++;
			}
			for(int i=0; i<teamsInCurrentGroup; i++)
			{
				int teamNumber = (new Random()).nextInt(totalTeams);
				Team currentTeam = (Team)selectableTeams.get(teamNumber);
				selectableTeams.remove(teamNumber);
				--totalTeams;
				group.getTeams().add(currentTeam);
			}
		}
	}
}
