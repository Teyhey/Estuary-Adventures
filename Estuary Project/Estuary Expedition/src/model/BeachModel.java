package model;

public class BeachModel {

	int frameWidth = 1280;
	int frameHeight = 800;
	public Player player;
	Item item;
	Wave wave;
	Boat boat;
	
	
	public BeachModel() {
		player = new Player(1140, 650);
	}

}
