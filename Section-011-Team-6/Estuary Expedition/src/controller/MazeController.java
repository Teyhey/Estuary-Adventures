package controller;

import java.awt.Polygon;
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


	int collision;

	public MazeController(int health) {
		maze = new MazeModel(health);
		this.xVel = 0;
		this.yVel = 0;
		time = 0;
		this.collision = 10;
	}

	public void tick() {
		move();
		tickOpacity();
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
		maze.setOpacity(maze.getOpacity() + maze.getOpacityTick());
		if (maze.getOpacity() <= 10){
			maze.setOpacityTick(maze.getOpacityTick() * -1);
		}
		if (maze.getOpacity() >= 250){
			maze.setOpacityTick(maze.getOpacityTick() * -1);
		}
	}
	
	private void checkProgression(Player p){
		if (this.maze.getStart() == 1 && p.xCoord >= frameWidth - p.width + 1){
			int counter = this.maze.getCurrDistance();
			this.maze = new MazeModel(p.getHealth());
			this.maze.setCurrDistance(counter + 1);
		}
		if (this.maze.getStart() == 2 && p.yCoord >= frameHeight - p.height + 1){
			int counter = this.maze.getCurrDistance();
			this.maze = new MazeModel(p.getHealth());
			this.maze.setCurrDistance(counter + 1);
		}
		if (this.maze.getStart() == 3 && p.xCoord <= -1){
			int counter = this.maze.getCurrDistance();
			this.maze = new MazeModel(p.getHealth());
			this.maze.setCurrDistance(counter + 1);
		}
		if (this.maze.getStart() == 4 && p.yCoord <= -1){
			int counter = this.maze.getCurrDistance();
			this.maze = new MazeModel(p.getHealth());
			this.maze.setCurrDistance(counter + 1);
		}
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
