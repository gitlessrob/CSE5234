package edu.osu.cse5234.controller;

import java.util.List;

import edu.osu.cse5234.business.view.Item;

public class Order {

	//TODO change these to just straight up be a string, per instructions?
	private List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> list) {
		this.items = list;
	}
	
	//private List itemList;
	
	
}
