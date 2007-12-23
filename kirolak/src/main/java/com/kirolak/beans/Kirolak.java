package com.kirolak.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.kirolak.ScoreMode;

public class Kirolak implements Serializable
{

	private static final long serialVersionUID = 1L;
	private List<ScoreMode> scoreModes;
	private List<SelectItem> scoreModesSelectItems;

	public List<ScoreMode> getScoreModes()
	{
		if (this.scoreModes == null)
		{
			this.scoreModes = ScoreMode.getAll();
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
			Iterator<ScoreMode> scoreModesIterator = scoreModes.iterator();
			while (scoreModesIterator.hasNext())
			{
				ScoreMode scoreMode = scoreModesIterator.next();
				this.scoreModesSelectItems.add(new SelectItem(scoreMode.getId(), scoreMode.getName()));
			}
		}
		return this.scoreModesSelectItems;
	}

	public Iterator<Locale> getSupportedLocales()
	{
		return FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
	}

}
