package com.kirolak;

public class SelectedTeam extends Team
{
	private boolean selected = false;

	public boolean isSelected()
	{
		return selected;
	}

	public void setSelected(boolean selected)
	{
		this.selected = selected;
	}
}
