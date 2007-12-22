package com.kirolak.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.model.SelectItem;

import com.kirolak.KirolakObject;
import com.kirolak.dao.KirolakDAO;

public abstract class KirolakSession
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected KirolakObject parent;
	protected List<KirolakObject> items;
	protected KirolakObject item;
	protected UIData itemData;

	public abstract List<KirolakObject> getItems();
	
	public KirolakObject getItem()
	{
		return item;
	}

	public void setItem(KirolakObject item)
	{
		this.item = item;
	}
	
	public KirolakObject getParent()
	{
		return parent;
	}

	public void setParent(KirolakObject parent)
	{
		this.parent = parent;
	}

	public UIData getItemData()
	{
		return itemData;
	}

	public void setItemData(UIData itemData)
	{
		this.itemData = itemData;
	}

	public String editItem()
	{
		this.item = (KirolakObject) itemData.getRowData();
		return "edit";
	}

	public String saveItem()
	{
		KirolakDAO.save(this.item);
		this.items = null;
		return "list";
	}

	public String deleteItem()
	{
		this.item = (KirolakObject) itemData.getRowData();
		KirolakDAO.delete(this.item);
		this.items = null;

		return "list";
	}
	
	public List<SelectItem> getSelectItems()
	{
		if (this.items == null)
		{
			getItems();
		}
		List <SelectItem> selectItems = new ArrayList<SelectItem>();
		Iterator<KirolakObject> iterator = this.items.iterator();
		while(iterator.hasNext())
		{
			KirolakObject obj = iterator.next();
			selectItems.add(new SelectItem(obj,obj.getName()));			
		}
		return selectItems;
	}

}
