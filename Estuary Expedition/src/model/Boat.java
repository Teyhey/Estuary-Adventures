package model;


public class Boat {
	String boatType;
	int damage;
	int speed;
	public int xCoord;
	public int yCoord;
	
	public Boat(String type, int d, int s, int x, int y) 
	{
		this.boatType = type;
		this.damage = d;
		this.speed = s;
		this.xCoord = x;
		this.yCoord = y;
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

	@Override
	public String toString() {
		return "Boat [boatType=" + boatType + ", damage=" + damage + ", speed=" + speed + ", xCoord=" + xCoord
				+ ", yCoord=" + yCoord + "]";
	}
		
		
	
	
}


