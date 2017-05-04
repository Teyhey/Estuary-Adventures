package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import model.BeachModel;
import model.MazeModel;

public class BeachController implements KeyListener{

	public int xIncr;
	public int yIncr;
	public BeachModel beach;

	public BeachController() {
		beach = new BeachModel();
		this.xIncr = 35;
		this.yIncr = 35;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			beach.player.setxCoord(beach.player.xCoord += xIncr);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			beach.player.setxCoord(beach.player.xCoord -= xIncr);
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			beach.player.setyCoord(beach.player.yCoord -= yIncr);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			beach.player.setyCoord(beach.player.yCoord += yIncr);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			beach.player.setxCoord(beach.player.xCoord += xIncr);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			beach.player.setxCoord(beach.player.xCoord -= xIncr);
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			beach.player.setyCoord(beach.player.yCoord -= yIncr);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			beach.player.setyCoord(beach.player.yCoord += yIncr);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
