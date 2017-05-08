package model;

import java.util.ArrayList;
import java.util.Random;

public class BeachModel {

	int frameWidth = 1280;
	int frameHeight = 800;
	public Player player;

	public Item oyster;
	public Item gabion;
	public Item wall;
	public Item grass;
	public Boat[] boats;
	public Wave[] waves;
	public ArrayList<Item> gabions;
	public ArrayList<Item> walls;
	public ArrayList<Item> grasses;


	public Wave wave;
	public Boat boat;
	public int numGabions;
	public int numWalls;
	public int numGrass;
	public int beachHealth;
	int health = 100;
	public boolean addedGab = false;
	public boolean addedWal = false;
	public boolean addedGra = false;



	public BeachModel() {
		player = new Player(0, 600, 900);
		boat = new Boat(0, 40);
		wave = new Wave(50, 10);
		oyster = new Item("Oyster", 1);
		numGabions = 0;
		numWalls = 0;
		numGrass = 0;
		createBoats();
		createWaves();
	}

	public boolean placeGabion(){
		this.gabion = new Item("Gabion", 1);
		this.gabion.xCoord = this.player.xCoord;
		this.gabion.yCoord = this.player.yCoord;
		this.gabions.add(this.gabion);
		this.numGabions++;
		addedGab = true;
		return addedGab;
	}

	public boolean placeWall(){
		this.wall = new Item("Wall", 1);
		this.wall.xCoord = this.player.xCoord;
		this.wall.yCoord = this.player.yCoord;
		this.walls.add(this.gabion);
		this.numWalls++;
		addedWal = true;
		return addedWal;
	}

	public boolean placeGrass(){
		this.grass = new Item("Gabion", 1);
		this.grass.xCoord = this.player.xCoord;
		this.grass.yCoord = this.player.yCoord;
		this.grasses.add(this.gabion);
		this.numGrass++;
		addedGra = true;
		return addedGra;
	}

	public void createBoats(){
		Random rand = new Random();
		this.boats = new Boat[2];
		int speeds[] = {-2, 2};
		for (int i = 0; i < boats.length; i++){
			int n = rand.nextInt(frameHeight - 400);
			int s = rand.nextInt(1);
			boats[i] = new Boat("Dirty Vessel", 5, speeds[s], n, (300 *i) + 100);
		}
	}

	public void createWaves(){
		Random rand = new Random();
		this.waves = new Wave[rand.nextInt(25) + 5];
		int[] speeds = {1,2,3};
		for (int i = 0; i < waves.length; i++){
			int s = rand.nextInt(3);
			waves[i] = new Wave("Small", 5, speeds[s], this.wave.getxCoord(), this.wave.getyCoord());
		}
		System.out.println(waves.length);
	}
	

}
