package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Player extends Character{
	
	public int health;
	int enemyFish;
	int numPowerUps;
	int difficulty;
	boolean isDead;
	

	public Player(int x, int y, int health) {
		super (x, y);
		this.health = health;
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


	public void movePlayer() {

	}

	public void takeDamage(int x) {

	}

	public void addItem(Item i) {

	}

	public void removeItem(Item i) {

	}

	public void spawnPlayer(Player p) {

	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	

	public int getEnemyFish() {
		return enemyFish;
	}

	public void setEnemyFish(int enemyFish) {
		this.enemyFish = enemyFish;
	}

	public int getNumPowerUps() {
		return numPowerUps;
	}

	public void setNumPowerUps(int numPowerUps) {
		this.numPowerUps = numPowerUps;
	}

	

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public void init() {
		// implemented in all subclasses
	}

	public void reset() {

	}

	@Override
	public String toString() {
		return "Player [health=" + health + ", enemyFish=" + enemyFish + ", numPowerUps=" + numPowerUps
				+ ", difficulty=" + difficulty + ", isDead=" + isDead + "]";
	}

	



}
