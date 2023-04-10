package ru.so.java.task.store;

import java.util.List;
import java.util.stream.Collectors;

public class Items {

	private List<Item> items;
	
	public Items(List<String> items) {		
		if (items != null && items.size() > 0) {
			this.items = items.stream().map(x -> new Item(x)).collect(Collectors.toList());
		}
	}
	
	public String namesToString() {
		StringBuilder toString = new StringBuilder(items.size());
		for (int i = 0; i < items.size(); i++) {
			toString.append((i + 1) + ". " + items.get(i).getName() + "\r\n");
		}
		return toString.toString();
	}
	
	public int getSize() {
		return items.size();
	}

	public Double getItemPrice(int index) {		
		return items.get(index).getPrice();
	}
	
	public void remove(int index) {
		items.remove(index);
	}
	
	public List<String> getItemsAsString(){
		return items.stream().map(x -> x.toString()).collect(Collectors.toList());
	}
}
