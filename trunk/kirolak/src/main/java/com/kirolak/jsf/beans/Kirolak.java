package com.kirolak.jsf.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.kirolak.KirolakObject;
import com.kirolak.ScoreMode;
import com.kirolak.StageType;
import com.kirolak.dao.ScoreModeDAO;
import com.kirolak.dao.StageTypeDAO;

public class Kirolak implements Serializable
{

	private static final long serialVersionUID = 1L;
	private List<KirolakObject> scoreModes;
	private List<SelectItem> scoreModesSelectItems;
	private List<KirolakObject> stageTypes;
	private List<SelectItem> stageTypesSelectItems;
	

	public List<KirolakObject> getScoreModes()
	{
		if (this.scoreModes == null)
		{
			this.scoreModes = ScoreModeDAO.list();
		}
		return this.scoreModes;
	}

	public List<SelectItem> getScoreModesSelectItems()
	{

		if (this.scoreModes == null)
		{
			getScoreModes();
		}
		if (this.scoreModesSelectItems == null)
		{
			this.scoreModesSelectItems = new ArrayList<SelectItem>();
			Iterator<KirolakObject> scoreModesIterator = scoreModes.iterator();
			while (scoreModesIterator.hasNext())
			{
				KirolakObject scoreMode = scoreModesIterator.next();
				this.scoreModesSelectItems.add(new SelectItem(((ScoreMode)scoreMode).getId(), scoreMode.getName()));
			}
		}
		return this.scoreModesSelectItems;
	}
	
	public List<KirolakObject> getStageTypes()
	{
		if (this.stageTypes == null)
		{
			this.stageTypes = StageTypeDAO.list();
		}
		return this.stageTypes;
	}

	public List<SelectItem> getStageTypesSelectItems()
	{

		if (this.stageTypes == null)
		{
			getStageTypes();
		}
		if (this.stageTypesSelectItems == null)
		{
			this.stageTypesSelectItems = new ArrayList<SelectItem>();
			Iterator<KirolakObject> stageTypesIterator = stageTypes.iterator();
			while (stageTypesIterator.hasNext())
			{
				KirolakObject stageType = stageTypesIterator.next();
				this.stageTypesSelectItems.add(new SelectItem(((StageType)stageType).getId(), stageType.getName()));
			}
		}
		return this.stageTypesSelectItems;
	}

	public Iterator<Locale> getSupportedLocales()
	{
		return FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
	}

}
