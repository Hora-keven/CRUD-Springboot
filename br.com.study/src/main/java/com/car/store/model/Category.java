package com.car.store.model;

public enum Category {
	HATCH("hatch"), SEDA("seda"), SUV("suv"), PICAPE("picape");
	private final String category;

	public String getCategory() {
		return category;
	}

	Category(String category) {
		this.category = category;
	}
	
	
}
