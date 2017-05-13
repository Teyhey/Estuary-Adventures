package controller;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;
import javax.swing.JPanel;

import model.Enemy;
import model.MazeModel;
import model.Obstacle;
import model.Player;

public class MazeController extends MazeModel implements KeyListener{

	public int xVel;
	public int yVel;
	public MazeModel maze;
	int padding = 100;
	int time;
	int vel;
	protected double maxHealth = 500.000; 
	boolean hitRock = false;
	boolean hitFish = false;
	int timeLeft;
	int collision;
	long timer = System.currentTimeMillis();

	public MazeController(int health, int time) {
		super(true, 500);
		maze = new MazeModel(true, health);
		this.xVel = 0;
		this.yVel = 0;
		this.collision = 10;
		this.timeLeft = time;
		this.vel = 5;
		long t = System.currentTimeMillis();
		this.timer = t;
	}

	public void tick() {
		move();
		tickOpacity();
		tickHealthOpacity();
		timeTick();
	}

	private void timeTick(){
		if (System.currentTimeMillis() - this.timer > 1000) {
			this.timer += 1000;
			this.timeLeft--;
		}
	}

	public int getxVel() {
		return xVel;
	}

	public void setxVel(int xVel) {
		this.xVel = xVel;
	}

	public int getyVel() {
		return yVel;
	}

	public void setyVel(int yVel) {
		this.yVel = yVel;
	}

	public int getTimeLeft() {
		return timeLeft;
	}

	public void setTimeLeft(int timeLeft) {
		this.timeLeft = timeLeft;
	}

	public long getTimer() {
		return timer;
	}

	public void setTimer(long timer) {
		this.timer = timer;
	}

	public int getVel() {
		return vel;
	}

	public void setVel(int vel) {
		this.vel = vel;
	}



	private void move(){
		checkProgression(maze.player);
		for (Enemy e: maze.enemy){
			patrol (e, maze.player);
		}
		checkBorders(maze.player);
		for (Obstacle o: maze.obstacles){
			checkXCollisionRight(maze.player, o);
			checkXCollisionLeft(maze.player, o);
			checkYCollisionUp(maze.player, o);
			checkYCollisionDown(maze.player, o);
		}
	}

	private void tickOpacity(){
		opacity += opacityTick;
		if (opacity <= 10){
			opacityTick *= -1;
		}
		if (opacity >= 250){
			opacityTick *= -1;
		}
	}

	private void tickHealthOpacity(){
		if (maze.player.health <= maxHealth/4){
			healthOpacity += healthOpacityTick;
			if (healthOpacity <= 10){
				healthOpacityTick *= -1;
			}
			if (healthOpacity >= 250){
				healthOpacityTick *= -1;
			}
		}
	}

	private void checkProgression(Player p){
		if (this.maze.getStart() == 1 && p.xCoord >= frameWidth - p.width + 1){
			progress(p);
		}
		if (this.maze.getStart() == 2 && p.yCoord >= frameHeight - p.height + 1){
			progress(p);
		}
		if (this.maze.getStart() == 3 && p.xCoord <= -1){
			progress(p);
		}
		if (this.maze.getStart() == 4 && p.yCoord <= -1){
			progress(p);
		}
	}
	
	private void progress(Player p){
		int counter = this.maze.getCurrDistance();
		this.maze = new MazeModel(this.maze.isTutorial(), p.getHealth());
		this.maze.setCurrDistance(counter + 1);
	}

	private void checkBorders(Player p) {
		if (p.xCoord <= -1) {
			p.xCoord = 0;
		} else {
			if (p.xCoord >= frameWidth - p.width + 1) {
				p.xCoord = frameWidth - p.width;
			} 
			else {
				p.xCoord += xVel;
			}
		}
		if (p.yCoord <= -1) {
			p.yCoord = 0;
		} else {
			if (p.yCoord >= frameHeight - p.height + 1) {
				p.yCoord = frameHeight - p.height;
			} else {
				p.yCoord += yVel;
			}
		}
	}

	private void checkXCollisionRight(Player p, Obstacle o){
		if (p.xCoord + p.width >= o.xCoord + collision && p.xCoord + p.width <= o.xCoord + o.width/4){
			if (p.yCoord >= o.yCoord + collision && p.yCoord <= o.yCoord + o.height - (collision*2)){
				p.xCoord -= 10;
				p.health -= o.getDamage();
			}
			if (p.yCoord + p.height >= o.yCoord && p.yCoord + p.height <= o.yCoord + o.height - collision){
				p.xCoord -= 10;
				p.health -= o.getDamage();
			}
			if (p.yCoord + p.height/2 >= o.yCoord && p.yCoord + p.height/2 <= o.yCoord + o.height - collision){
				p.xCoord -= 5;
				p.health -= o.getDamage();
			}
		}
	}

	private void checkXCollisionLeft(Player p, Obstacle o){
		if (p.xCoord <= o.xCoord + o.width - collision && p.xCoord >= o.xCoord + o.width/4){
			if (p.yCoord >= o.yCoord - collision && p.yCoord <= o.yCoord + o.height - (collision*2)){
				p.xCoord += 10;
				p.health -= o.getDamage();
			}
			if (p.yCoord + p.height >= o.yCoord && p.yCoord + p.height <= o.yCoord + o.height - collision){
				p.xCoord += 10;
				p.health -= o.getDamage();
			}
			if (p.yCoord + p.height/2 >= o.yCoord && p.yCoord + p.height/2 <= o.yCoord + o.height - collision){
				p.xCoord += 5;
				p.health -= o.getDamage();
			}
		}
	}

	private void checkYCollisionUp(Player p, Obstacle o){
		if (p.yCoord <= o.yCoord + o.height - collision && p.yCoord >= o.yCoord + o.height/4){
			if (p.xCoord >= o.xCoord - collision && p.xCoord <= o.xCoord + o.width - (collision*2)){
				p.yCoord += 10;
				p.health -= o.getDamage();
			}
			if (p.xCoord + p.width >= o.xCoord + o.width && p.xCoord + p.width <= o.xCoord + o.width - (collision*2)){
				p.yCoord += 10;
				p.health -= o.getDamage();
			}
			if (p.xCoord + p.width/2 >= o.xCoord && p.xCoord + p.width/2 <= o.xCoord + o.width - collision){
				p.yCoord += 5;
				p.health -= o.getDamage();
			}
		}
	}

	private void checkYCollisionDown(Player p, Obstacle o){
		if (p.yCoord + p.height >= o.yCoord + collision && p.yCoord + p.height <= o.yCoord + o.height/4){
			if (p.xCoord >= o.xCoord + collision && p.xCoord <= o.xCoord + o.width - collision){
				p.yCoord -= 10;
				p.health -= o.getDamage();
			}
			if (p.xCoord + p.width <= o.xCoord + o.width - collision && p.xCoord + p.width >= o.xCoord + collision){
				p.yCoord -= 10;
				p.health -= o.getDamage();
			}
			if (p.xCoord + p.width/2 <= o.xCoord + o.width - collision && p.xCoord + p.width >= o.xCoord + collision){
				p.yCoord -= 5;
				p.health -= o.getDamage();
			}
		}
	}

	private void patrol(Enemy e, Player p) {
		if (e.getDirection() == 0) {
			patrolHorizontal(e);
			checkHorizontalHit(e, p);
		} else {
			patrolVeritcal(e);
			checkVerticalHit(e, p);
		}
	}

	private void patrolHorizontal(Enemy e) {
		if (e.xCoord <= -1) {
			e.xCoord = 0;
			e.setSpeed(e.getSpeed() * -1);
		} else {
			if (e.xCoord >= frameWidth - e.width + 1) {
				e.xCoord = frameWidth - e.width;
				e.setSpeed(e.getSpeed() * -1);
			} else {
				e.xCoord += e.getSpeed();
			}
		}
	}

	private void patrolVeritcal(Enemy e) {
		if (e.yCoord <= -1) {
			e.yCoord = 0;
			e.setSpeed(e.getSpeed() * -1);
		} else {
			if (e.yCoord >= frameHeight - e.height + 1) {
				e.yCoord = frameHeight - e.height;
				e.setSpeed(e.getSpeed() * -1);
			} else {
				e.yCoord += e.getSpeed();
			}
		}
	}

	private void checkHorizontalHit(Enemy e, Player p){
		if (fishCollide(e)){
			if (p.yCoord + p.height/2 >= e.yCoord + e.height/2){
				p.yCoord = e.yCoord + e.height + (collision*2);
			}
			else {
				p.yCoord = e.yCoord - p.height - (collision*2);
			}
			p.health -= e.getDamage();
		}
	}

	private void checkVerticalHit(Enemy e, Player p){
		if (fishCollide(e)){
			if (p.xCoord + p.width/2 >= e.xCoord + e.width/2){
				p.xCoord = e.xCoord + p.width + (collision*2);
			}
			else {
				p.xCoord = e.xCoord - p.width - (collision*2);
			}
			p.health -= e.getDamage();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			setxVel(this.vel);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			setxVel(-this.vel);
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			setyVel(-this.vel);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			setyVel(this.vel);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			setxVel(0);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			setxVel(0);
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			setyVel(0);
			;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			setyVel(0);
			;
		}
	}

	public boolean fishCollide(Enemy e) {
		hitFish = false;
		Rectangle playerz = new Rectangle(maze.player.xCoord, maze.player.yCoord, maze.player.width - collision,
				maze.player.height - collision);
		Rectangle fish = new Rectangle(e.xCoord, e.yCoord, e.width - collision,
				e.height - collision);

		if (playerz.intersects(fish)) {
			hitFish = true;
		}
		return hitFish;
	}

}
