package com.cateringlarissa.menu.model;

public class Menu {
	protected int id;
	protected String name;
	protected String type;
	protected int price;
	protected String description;
	
	public Menu() {
	}
	
	public Menu(String name, String type, int price, String description) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.description = description;
	}

	public Menu(int id, String name, String type, int price, String description) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.description = description;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
