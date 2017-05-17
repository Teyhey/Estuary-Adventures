package model;
import model.Player;
import model.Obstacle;
import model.Item;
import model.Enemy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;

public class MazeModel{

	protected int frameWidth;
	protected int frameHeight;
	protected boolean tutorial;
	protected int tutorialStep;
	protected int distance;
	protected int currDistance;
	protected int obstacleNum;
	protected int start;
	protected int opacity;
	protected int opacityTick;
	protected Color salinityMeterColor;
	protected int healthOpacity;
	protected int healthOpacityTick;
	protected int fishSp;
	protected int padding;
	public Player player = new Player(0, 0, 500);
	public Item item;
	public Enemy[] enemy;
	public Obstacle[] obstacles;

	public MazeModel(int health) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.frameWidth = (int) screenSize.getWidth();
		this.frameHeight = (int) screenSize.getHeight();
		this.tutorial = false;
		this.tutorialStep = 10;
		Random rand = new Random();
		int n = rand.nextInt(4) + 1;
		this.start = n;
		this.opacity = 250;
		this.opacityTick = -3;
		this.healthOpacity = 250;
		this.healthOpacityTick = -10;
		this.fishSp = 5;
		item = new Item("Boost", 1);
		this.currDistance = 0;
		this.obstacleNum = 5;
		this.distance = 15;
		this.salinityMeterColor = new Color (255, 0, 0);
		this.padding = 65;
		placePlayer(n, health);
		createEnemies();
		createObstacles();
	}

	public MazeModel(boolean tutorial, int tutorialStep){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.frameWidth = (int) screenSize.getWidth();
		this.frameHeight = (int) screenSize.getHeight();
		this.tutorial = tutorial;
		this.tutorialStep = tutorialStep;
		int n;
		if (tutorialStep == 4){
			n = 1;
		} else{
			n = tutorialStep%4;
		}
		this.start = n;
		this.opacity = 250;
		this.opacityTick = -3;
		this.healthOpacity = 250;
		this.healthOpacityTick = -10;
		this.fishSp = 5;
		item = new Item("Boost", 1);
		this.currDistance = 0;
		this.obstacleNum = 5;
		this.distance = 15;
		this.salinityMeterColor = new Color (255, 0, 0);
		this.padding = 65;
		placePlayer(n, 500);
		createTutorialEnemy();
		createTutorialObstacles();
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

	public Color getSalinityMeterColor() {
		return salinityMeterColor;
	}

	public void setSalinityMeterColor(Color salinityMeterColor) {
		this.salinityMeterColor = salinityMeterColor;
	}

	public void setOpacityTick(int opacityTick) {
		this.opacityTick = opacityTick;
	}

	public boolean isTutorial() {
		return tutorial;
	}

	public void setTutorial(boolean tutorial) {
		this.tutorial = tutorial;
	}

	public int getTutorialStep() {
		return tutorialStep;
	}

	public void setTutorialStep(int tutorialStep) {
		this.tutorialStep = tutorialStep;
	}
	

	public int getFrameWidth() {
		return frameWidth;
	}

	public void setFrameWidth(int frameWidth) {
		this.frameWidth = frameWidth;
	}

	public int getFrameHeight() {
		return frameHeight;
	}

	public void setFrameHeight(int frameHeight) {
		this.frameHeight = frameHeight;
	}

	public int getObstacleNum() {
		return obstacleNum;
	}

	public void setObstacleNum(int obstacleNum) {
		this.obstacleNum = obstacleNum;
	}

	public int getHealthOpacity() {
		return healthOpacity;
	}

	public void setHealthOpacity(int healthOpacity) {
		this.healthOpacity = healthOpacity;
	}

	public int getHealthOpacityTick() {
		return healthOpacityTick;
	}

	public void setHealthOpacityTick(int healthOpacityTick) {
		this.healthOpacityTick = healthOpacityTick;
	}

	public int getFishSp() {
		return fishSp;
	}

	public void setFishSp(int fishSp) {
		this.fishSp = fishSp;
	}

	public int getPadding() {
		return padding;
	}

	public void setPadding(int padding) {
		this.padding = padding;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Enemy[] getEnemy() {
		return enemy;
	}

	public void setEnemy(Enemy[] enemy) {
		this.enemy = enemy;
	}

	public Obstacle[] getObstacles() {
		return obstacles;
	}

	public void setObstacles(Obstacle[] obstacles) {
		this.obstacles = obstacles;
	}

	public void placePlayer(int x, int health){
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
		int speeds[] = {-this.fishSp, this.fishSp};

		if (x == 0){
			for (int i = 0; i < enemy.length; i++){
				int n = rand.nextInt(frameHeight);
				int s = rand.nextInt(1);
				enemy[i] = new Enemy(x, "Fish", 5, speeds[s], n, (frameHeight/3) * (i+1) - this.padding);
			}
		}
		else { 
			for (int i = 0; i < enemy.length; i++){
				int n = rand.nextInt(frameWidth - 400);
				int s = rand.nextInt(1);
				enemy[i] = new Enemy(x, "Fish", 5, speeds[s], (frameWidth/3) * (i+1) - this.padding, n);
			}
		}
	}


	public void createObstacles(){
		Random rand = new Random();
		this.obstacles = new Obstacle[this.obstacleNum];
		for (int i = 0; i < obstacleNum; i++){
			int x = rand.nextInt((frameWidth/5) * 3) + (frameWidth/5);
			int y = rand.nextInt((frameHeight/5) * 3) + (frameHeight/5);
			obstacles[i] = new Obstacle(x, y);
		}
	}

	public void createTutorialEnemy(){
		Random rand = new Random();
		int x = start%2;
		this.enemy = new Enemy[4];
		int speeds[] = {-this.fishSp, this.fishSp};
		for (int i = 0; i < enemy.length; i++){
			int n = rand.nextInt(frameWidth - 400);
			int s = rand.nextInt(1);
			enemy[i] = new Enemy(x, "Fish", 5, speeds[s], (frameWidth/5) * (i+1) - this.padding, n);
		}
	}

	public void createTutorialObstacles(){
		Random rand = new Random();
		this.obstacles = new Obstacle[10];
		for (int i = 0; i < obstacles.length; i++){
			int x = rand.nextInt((frameWidth/5) * 3) + (frameWidth/5);
			int y = rand.nextInt((frameHeight/5) * 3) + (frameHeight/5);
			obstacles[i] = new Obstacle(x, y);
		}
	}

}
