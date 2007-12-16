package com.kirolak.jsf.converters;

import com.kirolak.Sport;
import com.kirolak.beans.Kirolak;

import java.util.Iterator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class SportConverter implements Converter
{

	public Object getAsObject(FacesContext fcontext, UIComponent uic, String value)
	{
		Kirolak app = (Kirolak)FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(fcontext.getELContext(), null, "app");
		boolean found = false;
		Iterator<Sport> sports = app.getSports().iterator();
		Sport sport = new Sport();
		while (!found && sports.hasNext())
		{
			sport = sports.next();
			if(sport.getId() == Short.parseShort(value))
			{
				found=true;
			}
		}
		return sport;
	}

	public String getAsString(FacesContext fcontext, UIComponent uic, Object obj)
	{
		Sport sport = (Sport)obj;
		return ""+sport.getId();
	}

}
