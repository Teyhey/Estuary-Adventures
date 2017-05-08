package model;


public class Item {

	String itemType;
	int quantity;
	public int xCoord = 400;
	public int yCoord = 200;
	public int width = 0;
	public int height = 0;
	public int health = 10;

	public Item(String n, int q) {
		this.itemType = n;
		this.quantity = q;
		
		if(n.equals("Gabion")){
			health = 10;
		}
		if(n.equals("Wall")){
			health = 15;
		}
		if(n.equals("Grass")){
			health = 5;
		}
		height = 0;
		width = 0;
		xCoord = 400;
		yCoord = 200;
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