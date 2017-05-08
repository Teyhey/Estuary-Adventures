package model;


public class Item {

	String itemType;
	int quantity;
	public int xCoord = 400;
	public int yCoord = 200;

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

	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}

	@Override
	public String toString() {
		return "Item [itemType=" + itemType + ", quantity=" + quantity + ", xCoord=" + xCoord + ", yCoord=" + yCoord
				+ "]";
	}

	
	
	
}