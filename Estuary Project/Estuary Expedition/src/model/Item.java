package model;


public class Item {

	String itemType;
	int quantity;
	Position place;

	public Item(String n, int q) {
		this.itemType = n;
		this.quantity = q;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Position getPlace() {
		return place;
	}

	public void setPlace(Position place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "Item [itemType=" + itemType + ", quantity=" + quantity + ", place=" + place + "]";
	}

}
