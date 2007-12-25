package com.kirolak.jsf.converters;

import com.kirolak.Team;
import com.kirolak.dao.KirolakDAO;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class TeamConverter implements Converter
{

	public Object getAsObject(FacesContext fcontext, UIComponent uic, String value)
	{
		Team team = (Team) KirolakDAO.get(Team.class, Integer.parseInt(value));
		return team;
	}

	public String getAsString(FacesContext fcontext, UIComponent uic, Object obj)
	{
		return String.valueOf(((Team) obj).getId());
	}

}
