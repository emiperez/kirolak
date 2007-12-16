package com.kirolak.util;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

public class FacesUtil
{

	// Getters
	// -----------------------------------------------------------------------------------

	public static String getActionAttribute(ActionEvent event, String name) {
        return (String) event.getComponent().getAttributes().get(name);
    }
	
	public static Object getRequestMapValue(String key)
	{
		return FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(key);
	}
	
	public static String getRequestParameter(String name) {
        return (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
    }

	// Setters
	// -----------------------------------------------------------------------------------

	public static void setRequestMapValue(String key, Object value)
	{
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(key, value);
	}

}