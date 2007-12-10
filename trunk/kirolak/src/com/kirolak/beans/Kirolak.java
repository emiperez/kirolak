package com.kirolak.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.kirolak.ScoreMode;
import com.kirolak.Sport;

public class Kirolak implements Observer, Serializable
{

	private static final long serialVersionUID = 1L;
	private List<Sport> sports;
	private List<ScoreMode> scoreModes;
	private List<SelectItem> scoreModesSelectItems;

	public List<ScoreMode> getScoreModes()
	{		
		if (this.scoreModes == null)
		{
			this.scoreModes = ScoreMode.getAll();
			this.scoreModesSelectItems = new ArrayList<SelectItem>();
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
			Iterator<ScoreMode> scoreModesIterator = scoreModes.iterator();
			while(scoreModesIterator.hasNext())
			{
				ScoreMode scoreMode = scoreModesIterator.next();
				this.scoreModesSelectItems.add(new SelectItem(scoreMode.getId(),scoreMode.getName()));			
			}
		}
		return this.scoreModesSelectItems;
	}

	public List<Sport> getSports()
	{
		if (this.sports == null)
		{
			this.sports = Sport.getAll();
		}
		return this.sports;
	}
	
	public Iterator<Locale> getSupportedLocales()
	{
		return FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
	}

	public void update(Observable o, Object arg)
	{
		this.sports = null;
	}

}
