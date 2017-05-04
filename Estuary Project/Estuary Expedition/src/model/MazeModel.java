package model;
import model.Player;
import model.Obstacle;
import model.Item;
import model.Enemy;


public class MazeModel{
	
	int frameWidth = 1280;
	int frameHeight = 800;
	public Player player;
	Item item;
	Enemy enemy;
	Obstacle obstacle;
	
	public MazeModel() {
		player = new Player(0, frameHeight/2);
	}
}
