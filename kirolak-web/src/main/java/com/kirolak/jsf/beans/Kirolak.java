package com.kirolak.jsf.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.kirolak.MatchStatus;
import com.kirolak.ScoreMode;
import com.kirolak.StageType;
import com.kirolak.dao.MatchStatusDAO;
import com.kirolak.dao.ScoreModeDAO;
import com.kirolak.dao.StageTypeDAO;

public class Kirolak implements Serializable
{

	//TODO: LazyLoad
	private static final long serialVersionUID = 1L;
	private List<ScoreMode> scoreModes;
	private List<SelectItem> scoreModesSelectItems;
	private List<StageType> stageTypes;
	private List<SelectItem> stageTypesSelectItems;
	private List<MatchStatus> matchStatus;
	private List<SelectItem> matchStatusSelectItems;
	

	public List<ScoreMode> getScoreModes()
	{
		Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		this.scoreModes = ScoreModeDAO.list(locale);
		return this.scoreModes;
	}

	public List<SelectItem> getScoreModesSelectItems()
	{
		getScoreModes();
		this.scoreModesSelectItems = new ArrayList<SelectItem>();
		Iterator<ScoreMode> scoreModesIterator = this.scoreModes.iterator();
		while (scoreModesIterator.hasNext())
		{
			ScoreMode scoreMode = scoreModesIterator.next();
			this.scoreModesSelectItems.add(new SelectItem(scoreMode.getId(), scoreMode.getName()));
		}
		return this.scoreModesSelectItems;
	}
	
	public List<StageType> getStageTypes()
	{
		Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		this.stageTypes = StageTypeDAO.list(locale);
		return this.stageTypes;
	}

	public List<SelectItem> getStageTypesSelectItems()
	{
		getStageTypes();
		if (this.stageTypesSelectItems == null)
		{
			this.stageTypesSelectItems = new ArrayList<SelectItem>();
			Iterator<StageType> stageTypesIterator = stageTypes.iterator();
			while (stageTypesIterator.hasNext())
			{
				StageType stageType = stageTypesIterator.next();
				this.stageTypesSelectItems.add(new SelectItem(stageType.getId(), stageType.getName()));
			}
		}
		return this.stageTypesSelectItems;
	}
	
	public List<MatchStatus> getMatchStatus()
	{		
		Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		this.matchStatus = MatchStatusDAO.list(locale);
		return this.matchStatus;
	}

	public List<SelectItem> getMatchStatusSelectItems()
	{
		getMatchStatus();
		if (this.matchStatusSelectItems == null)
		{
			this.matchStatusSelectItems = new ArrayList<SelectItem>();
			Iterator<MatchStatus> iterator = matchStatus.iterator();
			while (iterator.hasNext())
			{
				MatchStatus matchStatus = iterator.next();
				this.matchStatusSelectItems.add(new SelectItem(matchStatus.getId(), matchStatus.getName()));
			}
		}
		return this.matchStatusSelectItems;
	}

	public Iterator<Locale> getSupportedLocales()
	{
		return FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
	}

}
