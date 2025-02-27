package designpattern.demo.builder;

import java.util.ArrayList;
import java.util.List;

public class Meal {
	private List<Item> items = new ArrayList<Item>();

	public void addItem(Item item) {
		items.add(item);
	}

	public float getCost() {
		float price = 0;
		if (items.size() > 0) {
			for (Item item : items) {
				price += item.price();
			}
			return price;
		}
		return 0;
	}

	public void showItems() {
		if (items.size() > 0) {
			for (Item item : items) {
				System.out.print("Item:" + item.name());
				System.out.print(",Packing:" + item.packing());
				System.out.println(", Price:" + item.price());
			}
		}
	}
}
