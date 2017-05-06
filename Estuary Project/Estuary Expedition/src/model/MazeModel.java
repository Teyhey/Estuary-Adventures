package model;
import model.Player;
import model.Obstacle;
import model.Item;
import model.Enemy;


public class MazeModel{
	
	int frameWidth = 1280;
	int frameHeight = 800;
	public Player player;
	public Item item;
	public Enemy enemy;
	public Obstacle obstacle;
	
	public MazeModel() {
		player = new Player(0, frameHeight/2);
		enemy = new Enemy("Fish", 5, 60, 0, 60);
	}
}
