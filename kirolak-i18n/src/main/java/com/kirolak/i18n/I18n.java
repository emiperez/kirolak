package com.kirolak.i18n;

import java.util.ResourceBundle;

public class I18n {

	private static ResourceBundle bundle = null;
	
	public static String getMessage(String key)
	{
		//TODO: get locale from configuration/context
		if (bundle == null)
		{
			bundle = ResourceBundle.getBundle("messages");
		}			
		return bundle.getString(key);
	}
	
}
