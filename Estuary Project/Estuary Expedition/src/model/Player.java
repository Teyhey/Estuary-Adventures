package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Player {

	public int xCoord;
	public int yCoord;
	int health;
	int enemyFish;
	int numPowerUps;
	int difficulty;
	boolean isDead;
	ArrayList<Boat> boats;
	ArrayList<Wave> waves;
	ArrayList<Obstacle> obstacles;
	ArrayList<Item> inventory;
	ArrayList<Enemy> enemies;


	public Player(int x, int y) {
		this.setyCoord(x);
		this.setyCoord(y);
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
	
	public void setEnemies(ArrayList<Enemy> e){
		this.enemies = e;
	}

	public ArrayList<Enemy> getEnemies(){
		return enemies;
	}
	
	public ArrayList<Boat> getBoats() {
		return boats;
	}

	public void setBoats(ArrayList<Boat> boats) {
		this.boats = boats;
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

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
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
		return "Player [xCoord=" + xCoord + ", yCoord=" + yCoord + ", health=" + health + ", enemyFish=" + enemyFish
				+ ", numPowerUps=" + numPowerUps + ", difficulty=" + difficulty + ", isDead=" + isDead + ", boats="
				+ boats + ", waves=" + waves + ", obstacles=" + obstacles + ", inventory=" + inventory + ", enemies="
				+ enemies + "]";
	}



}
