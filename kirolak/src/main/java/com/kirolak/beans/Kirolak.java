package com.kirolak.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.kirolak.KirolakObject;
import com.kirolak.ScoreMode;
import com.kirolak.dao.ScoreModeDAO;

public class Kirolak implements Serializable
{

	private static final long serialVersionUID = 1L;
	private List<KirolakObject> scoreModes;
	private List<SelectItem> scoreModesSelectItems;

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

	public Iterator<Locale> getSupportedLocales()
	{
		return FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
	}

}
