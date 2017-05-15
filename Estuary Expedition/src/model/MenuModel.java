package model;

import java.awt.Dimension;
import java.awt.Toolkit;

public class MenuModel {

	protected int buttonSide = 200;
	protected int mazeButtonX;
	protected int mazeButtonY;
	protected int beachButtonX;
	protected int beachButtonY;
	protected int cubeButtonX;
	protected int cubeButtonY;
	protected int frameWidth;
	protected int frameHeight;
	protected int exitSize = 70;

	public MenuModel() {
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	this.frameWidth = (int) screenSize.getWidth();
	this.frameHeight = (int) screenSize.getHeight();
	this.mazeButtonX = (frameWidth / 2 - buttonSide / 2) - buttonSide * 2;
	this.mazeButtonY = (frameHeight / 2 - buttonSide / 2);
	this.beachButtonX = (frameWidth / 2 - buttonSide / 2);
	this.beachButtonY = (frameHeight / 2 - buttonSide / 2);
	this.cubeButtonX = (frameWidth / 2 - buttonSide / 2) + buttonSide * 2;
	this.cubeButtonY = (frameHeight / 2 - buttonSide / 2);
	}

	public int getButtonSide() {
		return buttonSide;
	}

	public int getMazeButtonX() {
		return mazeButtonX;
	}

	public int getMazeButtonY() {
		return mazeButtonY;
	}

	public int getBeachButtonX() {
		return beachButtonX;
	}

	public int getBeachButtonY() {
		return beachButtonY;
	}

	public int getCubeButtonX() {
		return cubeButtonX;
	}

	public int getCubeButtonY() {
		return cubeButtonY;
	}

	public int getFrameWidth() {
		return frameWidth;
	}

	public int getFrameHeight() {
		return frameHeight;
	}

	public int getExitSize() {
		return exitSize;
	}
	
	
}
