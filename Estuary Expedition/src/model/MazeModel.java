package model;
import model.Player;
import model.Obstacle;
import model.Item;
import model.Enemy;
import java.util.Random;

public class MazeModel{

	int frameWidth = 1280;
	int frameHeight = 800;
	int distance;
	int currDistance;
	int start;
	int opacity;
	int opacityTick;
	public Player player = new Player(0, 0, 500);
	public Item item;
	public Enemy[] enemy;
	public Obstacle[] obstacles;

	public MazeModel(int health) {
		Random rand = new Random();
		int n = rand.nextInt(4) + 1;
		this.start = n;
		this.opacity = 250;
		this.opacityTick = -1;
		placePlayer(n, health);
		createEnemies();
		createObstacles();
		item = new Item("Boost", 1);
		this.currDistance = 0;
		this.distance = 15;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getCurrDistance() {
		return currDistance;
	}

	public void setCurrDistance(int currDistance) {
		this.currDistance = currDistance;
	} 

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getOpacity() {
		return opacity;
	}

	public void setOpacity(int opacity) {
		this.opacity = opacity;
	}
	
	public int getOpacityTick() {
		return opacityTick;
	}

	public void setOpacityTick(int opacityTick) {
		this.opacityTick = opacityTick;
	}

	private void placePlayer(int x, int health){
		if (x == 1){
			player = new Player(0, frameHeight/2, health);
		}
		if (x == 2){
			player = new Player(frameWidth/2, 0, health);
		}
		if (x == 3){
			player = new Player (frameWidth - player.width + 100, frameHeight/2, health);
		}
		if (x == 4){
			player = new Player(frameWidth/2, frameHeight - player.height - 100, health);
		}
	}

	public void createEnemies(){
		Random rand = new Random();
		int x = start%2;
		this.enemy = new Enemy[2];
		int speeds[] = {-1, 1};

		if (x == 0){
			for (int i = 0; i < 2; i++){
				int n = rand.nextInt(frameHeight - 400);
				int s = rand.nextInt(1);
				enemy[i] = new Enemy(x, "Fish", 5, speeds[s], n, (300 *i) + 100);
			}
		}
		else { 
			for (int i = 0; i < 2; i++){
				int n = rand.nextInt(frameWidth - 400);
				int s = rand.nextInt(1);
				enemy[i] = new Enemy(x, "Fish", 5, speeds[s], (500 *i) + 300, n);
			}
		}
	}


	public void createObstacles(){
		Random rand = new Random();
		this.obstacles = new Obstacle[3];
		for (int i = 0; i < 3; i++){
			int x = rand.nextInt(frameWidth/2) + frameWidth/4;
			int y = rand.nextInt(frameHeight - 150);
			obstacles[i] = new Obstacle(x, y);
		}
	}
}
