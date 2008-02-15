package com.kirolak.jsp.beans;

public class kirolakBean {
	Integer id;

	public int getId() {
		return id;
	}
	
	public short getShortId()
	{
		return id.shortValue();
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setId(Short id)
	{
		this.id = id.intValue();
	}
	
	public void setSeoId(String sId) {
		int finalId = Integer.parseInt(sId.substring(sId.lastIndexOf('-')+1));
		this.id = finalId;
	}
	
}
