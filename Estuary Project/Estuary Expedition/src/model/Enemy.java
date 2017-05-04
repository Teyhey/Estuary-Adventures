package model;


public class Enemy {
	String enemyType;
	int damage;
	int speed;
	Position place;
	
	public Enemy(String s, int d, int sp, Position p) {
		this.enemyType = s;
		this.damage = d;
		this.speed = sp;
		this.place = p;
	}

	public String getEnemyType() {
		return enemyType;
	}

	public void setEnemyType(String enemy) {
		this.enemyType = enemy;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int d) {
		this.damage = d;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int s) {
		this.speed = s;
	}

	public Position getPlace() {
		return place;
	}

	public void setPlace(Position p) {
		this.place = p;
	}

	@Override
	public String toString() {
		return "Enemy [enemyType=" + enemyType + ", damage=" + damage + ", speed=" + speed + ", place=" + place + "]";
	}

	
}
