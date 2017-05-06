package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.MazeModel;
import model.Player;
import view.MazeView;

public class MazeController implements KeyListener {

	public int xIncr;
	public int yIncr;
	public MazeModel maze;
	int frameWidth = 1280;
	int frameHeight = 800;
	int padding = 100;
	
	public MazeController() {
		maze = new MazeModel();
		this.xIncr = 40;
		this.yIncr = 40;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			maze.player.setxCoord(maze.player.xCoord += xIncr);
			fishMovement();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			maze.player.setxCoord(maze.player.xCoord -= xIncr);
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			maze.player.setyCoord(maze.player.yCoord -= yIncr);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			maze.player.setyCoord(maze.player.yCoord += yIncr);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			maze.player.setxCoord(maze.player.xCoord += xIncr);
			fishMovement();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			maze.player.setxCoord(maze.player.xCoord -= xIncr);
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			maze.player.setyCoord(maze.player.yCoord -= yIncr);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			maze.player.setyCoord(maze.player.yCoord += yIncr);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	
	public void fishMovement(){
		
		while(maze.enemy.xCoord > 0 && maze.enemy.xCoord < frameWidth){
			if(maze.enemy.xCoord >= (frameWidth - padding)){
				maze.enemy.xCoord -= maze.enemy.getSpeed();
			}
			if(maze.enemy.xCoord <= padding){
				maze.enemy.xCoord += maze.enemy.getSpeed();
			}
		}
		
	}
	
	
	
	
}
