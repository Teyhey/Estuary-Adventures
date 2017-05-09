package model;


public class Boat{
	String boatType;
	int damage;
	public int speed = 2;
	//int direction = 0;
	public int xCoord = 0;
	public int yCoord = 250;
	public int width = 0;
	public int height = 0;
	
	
	public Boat(int x, int y){
		this.xCoord = x;
		this.yCoord = y;
		this.boatType = "Regular";
		this.damage = 10;
		this.speed = 2;
		//this.direction = 0;
	}
	
	
	public Boat(String type, int d, int s, int x, int y) {
		this.xCoord = x;
		this.yCoord = y;
		this.boatType = type;
		this.damage = d;
		this.speed = s;
	}

	public String getBoatType() {
		return boatType;
	}

	public void setBoatType(String boatType) {
		this.boatType = boatType;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
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

	
	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	@Override
	public String toString() {
		return "Boat [boatType=" + boatType + ", damage=" + damage + ", speed=" + speed + ", xCoord=" + xCoord
				+ ", yCoord=" + yCoord + "]";
	}
		
		
	
	
}


