package com.kirolak.beans;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

import javax.faces.context.FacesContext;


import com.kirolak.Sport;

public class Kirolak implements Observer, Serializable
{

	private static final long serialVersionUID = 1L;
	private List<Sport> sports;

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
