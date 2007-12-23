package com.kirolak.jsf.converters;

import com.kirolak.Sport;
import com.kirolak.dao.KirolakDAO;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class SportConverter implements Converter
{

	public Object getAsObject(FacesContext fcontext, UIComponent uic, String value)
	{
		Sport sport = (Sport) KirolakDAO.get(Sport.class, Short.parseShort(value));
		return sport;
	}

	public String getAsString(FacesContext fcontext, UIComponent uic, Object obj)
	{
		return String.valueOf(((Sport) obj).getId());
	}

}
