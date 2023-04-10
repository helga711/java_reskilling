package ru.so.java.task.store;

public class Item {

	private String name;
	private Double price;
	
	public String getName() {
		return name;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public Item(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	
	public Item(String item) {		
		String[] values = item.split("[|]");
		this.name = values[0];
		this.price = Double.parseDouble(values[1]);
	}
	
	public String toString() {
		return name + "|" + price;
	}
}
