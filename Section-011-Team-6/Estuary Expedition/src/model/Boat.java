package model;


public class Boat extends Character{
	String boatType;
	int damage;
	int speed = 2;
	public int xCoord = 0;
	public int yCoord = 120;
	int direction = 0;
	
	
	public Boat(int x, int y){
		super(x, y);
		this.boatType = "Regular";
		this.damage = 10;
		this.speed = 2;
		this.direction = 0;
	}
	
	
	public Boat(String type, int d, int s, int x, int y) {
		super(x, y);
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


	public int getDirection() {
		return direction;
	}
	
	@Override
	public String toString() {
		return "Boat [boatType=" + boatType + ", damage=" + damage + ", speed=" + speed + ", xCoord=" + xCoord
				+ ", yCoord=" + yCoord + "]";
	}
		
		
	
	
}


