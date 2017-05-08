package model;

public class Wave{
	String waveType;
	int damage;
	int speed;
	public int xCoord = 0;
	public int yCoord = 250;
	public int width = 150;
	public int height = 108;
	int direction = 0;
	
	public Wave(int x, int y){
		waveType = "Small";
		damage = 5;
		this.xCoord = x;
		this.yCoord = y;
		direction = 0;
		speed = 1;
	}
	
	
	public Wave(String type, int d, int s, int x, int y) {
		this.waveType = type;
		this.damage = d;
		this.speed = s;
		this.xCoord = x;
		this.yCoord = y;
		direction = 0;
		speed = 1;
	}
	
	public String getwaveType() {
		return waveType;
	}

	public void setWaveType(String waveType) {
		this.waveType = waveType;
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
		return "Wave [waveType=" + waveType + ", damage=" + damage + ", speed=" + speed + ", xCoord=" + xCoord
				+ ", yCoord=" + yCoord + "]";
	}


	public int getDirection() {
		return direction;
	}
		
		
	
	
}



