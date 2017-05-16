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
	public Item[] currencyArr;
	public Wave[] waveArr;

	public int numGabions;
	public int numWalls;
	public int numGrass;
	public int beachHealth;
	int health = 100;
	public int numSeeds;
	public int numBlocks;
	public int numOysters;
	int spawnCap;

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
		spawnCap = 40;

		waves = new ArrayList<Wave>();
		boats = new ArrayList<Boat>();
		barriers = new ArrayList<Item>();
		currency = new ArrayList<Item>();
		currencyArr = new Item[10];
		waveArr = new Wave[8];
		createWakes();
		createBoats();
		createCurrency();

	}

	/*
	 * public void createBoat(){ Random rand = new Random();
	 * 
	 * int speedsBoat[] = {-2, 2}; int sBoat = rand.nextInt(1); int yLoc =
	 * rand.nextInt(200); int yAdd = rand.nextInt(90) + 75; int location =
	 * rand.nextInt(2);
	 * 
	 * boats.add(0, new Boat("Dirty Vessel", 5, speedsBoat[sBoat], frameWidth,
	 * (yLoc * location) + yAdd)); }
	 * 
	 */

	public void createBarrier(String type) {
		if (type.equals("Gabion")) {
			this.gabion = new Item("Gabion", 1);
			this.gabion.xCoord = this.player.getxCoord();
			this.gabion.yCoord = this.player.getyCoord();
			barriers.add(gabion);
			numGabions++;
		}

		if (type.equals("Wall")) {
			this.wall = new Item("Wall", 1);
			this.wall.xCoord = this.player.xCoord;
			this.wall.yCoord = this.player.yCoord;
			barriers.add(wall);
			numWalls++;
		}

		if (type.equals("Grass")) {
			this.grass = new Item("Grass", 1);
			this.grass.xCoord = this.player.xCoord;
			this.grass.yCoord = this.player.yCoord - 35;
			barriers.add(grass);
			numGrass++;
		}
	}

	public void createCurrency() {
		Random rand = new Random();
		String[] types = { "Oyster", "Block", "Seed" };

		for (int v = 0; v < currencyArr.length; v++) {
			int index = rand.nextInt(3);
			String pick = types[index];
			int y = rand.nextInt(frameHeight/4) + frameHeight/4 * 3 - spawnCap;
			int x = rand.nextInt(frameWidth - spawnCap);

			if (pick.equals("Oyster")) {
				this.oyster = new Item(pick, 1);
				this.oyster.xCoord = x;
				this.oyster.yCoord = y;
				//numOysters++;

				currency.add(oyster);
			} else

			if (pick.equals("Seed")) {
				this.seed = new Item(pick, 1);
				this.seed.xCoord = x;
				this.seed.yCoord = y;
				//numSeeds++;

				currency.add(seed);
			} else

			if (pick.equals("Block")) {
				this.block = new Item(pick, 1);
				this.block.xCoord = x;
				this.block.yCoord = y;
				//numBlocks++;

				currency.add(block);
			}
			currencyArr[v] = currency.get(v);
		}

	}

	
	public void createBoats() {
		Random rand = new Random();

		// bs.add(new Boat("Boat", 5, -2, 1, (300 *1) + 100));
		int boatNum = rand.nextInt(5) + 1;
		int speedsBoat[] = { -2, 2 };
		int possible[] = { -1, 1 };

		for (int i = 0; i < boatNum; i++) {
			//int n = rand.nextInt(frameHeight - 400);
			int sBoat = rand.nextInt(1);
			int direct = rand.nextInt(2);

			int yLoc = rand.nextInt(300) + 30;
			int yAdd = rand.nextInt(90) + 75;

			this.boats.add(i, new Boat("Dirty Vessel", 5, speedsBoat[sBoat] * possible[direct], frameWidth, yLoc + yAdd));
			// this.boat.setxCoord(boats.get(i).getxCoord());

		}
	}
	
	public void createWakes(){
		int speedsWave[] = { 1, 2, 3 };
		Random rand = new Random();
		
		for (int i = 0; i < waveArr.length; i++) {
			int sWave = rand.nextInt(3);

			this.waves.add(new Wave(speedsWave[sWave], this.boat.getxCoord(), this.boat.getyCoord()));
			waveArr[i] = waves.get(i);
		}
	}
	
	
	
	
	
	
}