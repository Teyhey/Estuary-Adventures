package controller;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

import model.Character;
import model.Enemy;
import model.MazeModel;
import model.Obstacle;
import model.Player;
import view.MazeView;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MazeController implements KeyListener {

	public int xVel;
	public int yVel;
	public MazeModel maze;
	int frameWidth = 1280;
	int frameHeight = 800;
	int padding = 100;
	int time;
	boolean hitRock = false;
	boolean hitFish = false;


	int timet; // two minute timer
	int minutes;
	int seconds;
	long delay;
	static String message;
	protected static String format; // mm:ss

	public MazeController() {
		maze = new MazeModel();
		this.xVel = 0;
		this.yVel = 0;
		time = 0;
	}

	public void tick() {
		move(maze.player);
		paroleHorizontal(maze.enemy);
		rockCollide();
		fishCollide();
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

	private void move (Character c){
		if (c.xCoord <= -1){
			c.xCoord = 0;
		} 
		else { 
			if (c.xCoord >= frameWidth  - c.width + 1){
				c.xCoord = frameWidth - c.width;
			} 
			else {
				if (hitRock == true || hitFish == true){
					c.xCoord = c.xCoord;
					c.yCoord = c.yCoord;
				}
				else {
					c.xCoord += xVel;
				}
			}
		}
		if (c.yCoord <= -1){
			c.yCoord = 0;
		}
		else {
			if (c.yCoord >= frameHeight - c.height + 1){
				c.yCoord = frameHeight - c.height;
			}
			else {
				c.yCoord += yVel;
			}
		}
	}

	private void paroleHorizontal (Enemy e){
		if (e.xCoord <= -1){
			e.xCoord = 0;
			e.setSpeed(e.getSpeed()*-1);
		} 
		else { 
			if (e.xCoord >= frameWidth  - e.width + 1){
				e.xCoord = frameWidth - e.width;
				e.setSpeed(e.getSpeed()*-1);
			} 
			else {
				e.xCoord += e.getSpeed();
			}
		}
	}

	private void paroleVeritcal (Enemy e){
		if (e.yCoord <= -1){
			e.yCoord = 0;
			e.setSpeed(e.getSpeed()*-1);
		}
		else {
			if (e.yCoord >= frameHeight - e.height + 1){
				e.yCoord = frameHeight - e.height;
				e.setSpeed(e.getSpeed()*-1);
			}
			else {
				e.yCoord += e.getSpeed();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			setxVel(5);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			setxVel(-5);
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			setyVel(-5);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			setyVel(5);
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

	public void fishMovement() {

		while (maze.enemy.xCoord > 0 && maze.enemy.xCoord < frameWidth) {
			if (maze.enemy.xCoord >= (frameWidth - padding)) {
				maze.enemy.xCoord -= maze.enemy.getSpeed();
			}
			if (maze.enemy.xCoord <= padding) {
				maze.enemy.xCoord += maze.enemy.getSpeed();
			}
		}

	}



	public void rockCollide(){

		Rectangle playerz = new Rectangle(maze.player.xCoord, maze.player.yCoord, maze.player.width, maze.player.height);
		Rectangle rockz = new Rectangle(maze.obstacle.xCoord, maze.obstacle.yCoord, maze.obstacle.width, maze.obstacle.height);

		if(playerz.intersects(rockz)){
			hitRock = true;
			//maze.player.setHealth(maze.player.health - maze.obstacle.getDamage());
			setxVel(0);
			setyVel(0);
			System.out.println(hitRock);
			System.out.println(maze.player.health);
		}
	}

	public void fishCollide(){

		Rectangle playerz = new Rectangle(maze.player.xCoord, maze.player.yCoord, maze.player.width, maze.player.height);
		Rectangle fish = new Rectangle(maze.enemy.xCoord, maze.enemy.yCoord, maze.enemy.width , maze.enemy.height);

		if(playerz.intersects(fish)){
			hitFish = true;
			setxVel(0);
			//maze.player.setHealth(maze.player.health - maze.enemy.getDamage());
			System.out.println(hitFish);
			System.out.println(maze.player.health);
		}
	}


}
