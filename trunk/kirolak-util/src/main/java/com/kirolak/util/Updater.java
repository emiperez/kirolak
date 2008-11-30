package com.kirolak.util;

import com.kirolak.KirolakObject;
import com.kirolak.dao.KirolakDAO;

public class Updater {

	public static void save(KirolakObject obj)
	{
		KirolakDAO.save(obj);
		notify(obj);
	}
	
	public static void delete(KirolakObject obj)
	{
		KirolakDAO.delete(obj);
		notify(obj);
	}
	
	public static void notify(KirolakObject obj)
	{
		//TODO: Notify changes
		System.out.println("Notified: " + obj);
	}
	
}
