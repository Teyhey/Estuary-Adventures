package model;

import java.util.ArrayList;
import java.util.Random;

public class BeachModel {

	int frameWidth = 1280;
	int frameHeight = 800;
	public Player player;
	public Wave wave;
	public Boat boat;
	
	public Item gabion;
	public Item wall;
	public Item grass;
	public Item seed;
	public Item block;
	public Item oyster;
	
	public ArrayList<Boat> boats;
	public ArrayList<Wave> waves;
	public ArrayList<Item> barriers;
	public ArrayList<Item> currency;

	public int numGabions;
	public int numWalls;
	public int numGrass;
	public int beachHealth;
	int health = 100;
	int numSeeds;
	int numBlocks;
	int numOysters;
	
	public boolean addedGab = false;
	public boolean addedWal = false;
	public boolean addedGra = false;
	public boolean spawnSeeds = false;
	public boolean spawnBlocks = false;
	public boolean spawnOysters = false;



	public BeachModel() {
		player = new Player(0, 600, 900);
		boat = new Boat(0, 40);
		wave = new Wave(50, 10);
		oyster = new Item("Oyster", 1);
		gabion = new Item("Gabion", 1);
		wall = new Item("Wall", 1);
		grass = new Item("Grass", 1);
		block = new Item("Block", 1);
		seed = new Item("Seed", 1);
		oyster = new Item("Oyster", 1);
		
		numGabions = 0;
		numWalls = 0;
		numGrass = 0;
		numSeeds = 0;
		numOysters = 0;
		numBlocks = 0;
		
		
		waves = new ArrayList<Wave>();
		boats = new ArrayList<Boat>();
		barriers = new ArrayList<Item>();
		currency = new ArrayList<Item>();
		
		createOcean();
	}

	public void placeGabion(){
		this.gabion = new Item("Gabion", 1);
		this.gabion.xCoord = this.player.getxCoord();
		this.gabion.yCoord = this.player.getyCoord();
		addedGab = true;
	}

	public void placeWall(){
		this.wall = new Item("Wall", 1);
		this.wall.xCoord = this.player.xCoord;
		this.wall.yCoord = this.player.yCoord;
		addedWal = true;
	}

	public void placeGrass(){
		this.grass = new Item("Grass", 1);
		this.grass.xCoord = this.player.xCoord;
		this.grass.yCoord = this.player.yCoord - 35;
		addedGra = true;
	}
	
	public void spawnOysters(){
		Random rand = new Random();
		int y = rand.nextInt(1000) + 500;
		int x = rand.nextInt(frameWidth) + 0;
		
		
		this.oyster = new Item("Oyster", 1);
		this.oyster.xCoord = x;
		this.oyster.yCoord = y;
		spawnOysters = true;
	}
	
	public void spawnBlocks(){
		Random rand = new Random();
		int y = rand.nextInt(1000) + 500;
		int x = rand.nextInt(frameWidth) + 0;
		
		
		this.oyster = new Item("Block", 1);
		this.oyster.xCoord = x;
		this.oyster.yCoord = y;
		spawnOysters = true;
	}
	
	public void spawnSeeds(){
		Random rand = new Random();
		int y = rand.nextInt(1000) + 500;
		int x = rand.nextInt(frameWidth) + 0;
		
		
		this.oyster = new Item("Seed", 1);
		this.oyster.xCoord = x;
		this.oyster.yCoord = y;
		spawnOysters = true;
	}
	

	/*
	public void createBoat(){
		Random rand = new Random();
		
		int speedsBoat[] = {-2, 2};
		int sBoat = rand.nextInt(1);
		int yLoc = rand.nextInt(200);
		int yAdd = rand.nextInt(90) + 75;
		int location = rand.nextInt(2);
		
		boats.add(0, new Boat("Dirty Vessel", 5, speedsBoat[sBoat], frameWidth, (yLoc * location) + yAdd));
	}
	
	*/
	
	public void createBarrier(){
		if(addedGab){
			barriers.add(gabion);
			numGabions++;
		}
		
		if(addedWal){
			barriers.add(wall);
			numWalls++;
		}
		
		if(addedGra){
			barriers.add(grass);
			numGrass++;
		}
	}
	
	
	public void createCurrency(){
		if(spawnOysters){
			currency.add(oyster);
		}
		
		if(spawnSeeds){
			currency.add(seed);
		}
		
		if(spawnBlocks){
			currency.add(block);
		}
	}
	
	
	
	
	
	public void createOcean(){
		Random rand = new Random();
		
		//bs.add(new Boat("Boat", 5, -2, 1, (300 *1) + 100));
		int boatNum = rand.nextInt(5) + 1;
		int speedsBoat[] = {-2, 2};
		int speedsWave[] = {1, 2, 3};
		int possible[] = {-1, 1};
		
		for (int i = 0; i < boatNum; i++){
			//int n = rand.nextInt(frameHeight - 400);
			int sBoat = rand.nextInt(1);
			int sWave = rand.nextInt(3);
			int direct = rand.nextInt(2);
			
			int yLoc = rand.nextInt(300) + 30;
			int yAdd = rand.nextInt(90) + 75;
			
			
			
			this.boats.add(i, new Boat("Dirty Vessel", 5, speedsBoat[sBoat] * possible[direct], frameWidth, yLoc + yAdd));
			//this.boat.setxCoord(boats.get(i).getxCoord());
			this.waves.add(new Wave(speedsWave[sWave], this.boat.getxCoord(), this.wave.getyCoord()));

		}
	}


	

}
