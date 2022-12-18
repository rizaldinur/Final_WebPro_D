package com.cateringlarissa.review.model;

public class Review {

	protected int id;
	protected String name;
	protected int rating;
	protected String description;
	
	
	public Review() {
		
	}
	
	public Review(int id, String name, int rating, String description) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.description = description;
	}
	
	public Review(String name, int rating, String description) {
		super();
		this.name = name;
		this.rating = rating;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
