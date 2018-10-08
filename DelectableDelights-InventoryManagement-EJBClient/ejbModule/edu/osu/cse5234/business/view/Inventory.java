package edu.osu.cse5234.business.view;

import java.util.ArrayList;

public class Inventory implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -872344271112964171L;
	private ArrayList<Item> list;

	public ArrayList<Item> getList() {
		return list;
	}

	public void setList(ArrayList<Item> list) {
		this.list = list;
	}
	
}
