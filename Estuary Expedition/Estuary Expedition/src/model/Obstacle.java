package model;

public class Obstacle {
	public int xCoord;
	public int yCoord;
	public int damage = 3;
	public int width = 150;
	public int height = 108;
	
	
	public Obstacle(int x, int y) {
		this.xCoord = x;
		this.yCoord = y;
		this.damage = 0;
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


	public int getDamage() {
		return damage;
	}


	public void setDamage(int damage) {
		this.damage = damage;
	}

	
	
	
	
}
