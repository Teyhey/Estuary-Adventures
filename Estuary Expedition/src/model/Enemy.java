package model;


public class Enemy {
	String enemyType;
	int damage;
	int speed;
	public int xCoord;
	public int yCoord;
	
	public Enemy(String s, int d, int sp, int x, int y) {
		this.enemyType = s;
		this.damage = d;
		this.speed = sp;
		this.xCoord = x;
		this.yCoord = y;
	}

	public String getEnemyType() {
		return enemyType;
	}

	public void setEnemyType(String enemyType) {
		this.enemyType = enemyType;
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
		return "Enemy [enemyType=" + enemyType + ", damage=" + damage + ", speed=" + speed + ", xCoord=" + xCoord
				+ ", yCoord=" + yCoord + "]";
	}

	
	
	
}