package view;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JTextArea;

import controller.BeachController;
import model.Boat;
import model.Enemy;
import model.Wave;

public class BeachView extends BeachController {

	/**
	 * This class handles the view components for the Beach Game.
	 * 
	 * @param
	 * @author John Tejeda, Tyler Hill, Stephen Lu, Devarshi Patel
	 * @version BETA
	 */

	int buttonWidth = 75;
	int buttonHeight = 50;
	int inventWidth = 110;
	int inventHeight = 100;
	int frameWidth = 1280;
	int frameHeight = 800;

	String playerIcon;
	String boatL;
	String boatR;
	String timer;
	String inventory;
	String wave;
	String gabion;
	String wall;
	String grass;
	String[] boatz = { "Game Files/dirtyvesselRight.png", "Game Files/dirtyvesselLeft.png" };
	String[] wavez = { "Game Files/splashSMALL.png", "Game Files/splashMED.png", "Game Files/splashBIG.png", };

	JButton backButton;
	JButton addGabion;
	JButton addWall;
	JButton addGrass;

	/**
	 * This method is fairly straight forward. It takes nothing in.
	 * 
	 * @param None
	 * @return the back JButton.
	 */
	public JButton getBackButton() {
		return backButton;
	}

	/**
	 * Class constructor Sets the fields for this class.
	 * 
	 * @param None
	 * @return void.
	 */
	public BeachView() {
		super();
		backButton = new JButton("Exit");
		backButton.setSize(buttonWidth, buttonHeight);
		backButton.setLocation(0, 0);

		/*
		 * addGabion = new JButton("Add Gabion" + " " + "x" +
		 * this.beach.numGabions); addGabion.setSize(inventWidth, inventHeight);
		 * addGabion.setLocation(0, 640);
		 * 
		 * addWall = new JButton("Add Wall" + " " + "x" + this.beach.numWalls);
		 * addWall.setSize(inventWidth, inventHeight); addWall.setLocation(0 +
		 * buttonWidth * 2, 640);
		 * 
		 * addGrass = new JButton("Add Grass" + " " + "x" +
		 * this.beach.numGrass); addGrass.setSize(inventWidth, inventHeight);
		 * addGrass.setLocation(0 + buttonWidth * 4, 640);
		 */
		playerIcon = "Game Files/crab.png";
		timer = "Game Files/timer.png";
		inventory = "Game Files/Inventory.png";
		wave = "Game Files/splashSMALL.png";
		boatL = "Game Files/dirtyvesselLeft.png";
		boatR = "Game Files/dirtyvesselRight.png";
		gabion = "Game Files/gabion.png";
		wall = "Game Files/SeaWallIcon.png";
		grass = "Game Files/grass.png";
	}

	/**
	 * This method is responsible for drawing the graphics on Panel.
	 * 
	 * @param g
	 *            This is the only parameter in this method and is of Graphics
	 *            type.
	 * @return void.
	 */
	public void draw(Graphics g) {
		try {
			BufferedImage icon;
			BufferedImage clock;
			BufferedImage slots;
			BufferedImage[] waveImages;
			BufferedImage Gabby;
			BufferedImage Wally;
			BufferedImage Gass;
			BufferedImage[] boatImages;

			boatImages = new BufferedImage[2];
			for (int i = 0; i < boatImages.length; i++) {
				boatImages[i] = ImageIO.read(new File(boatz[i]));
			}

			waveImages = new BufferedImage[3];
			for (int i = 0; i < waveImages.length; i++) {
				waveImages[i] = ImageIO.read(new File(wavez[i]));
			}

			BufferedImage background = ImageIO.read(new File("Game Files/Beach.png"));
			g.drawImage(background, 0, 0, null);

			icon = ImageIO.read(new File(playerIcon));
			clock = ImageIO.read(new File(timer));
			slots = ImageIO.read(new File(inventory));
			// waves = ImageIO.read(new File(wave));
			Gabby = ImageIO.read(new File(gabion));
			Wally = ImageIO.read(new File(wall));
			Gass = ImageIO.read(new File(grass));

			g.drawImage(icon, this.beach.player.getxCoord(), this.beach.player.getyCoord(), null);
			g.drawImage(slots, 0, 654, null);

			for (Wave w : this.beach.waves) { // different speeds will produce
												// different wave sizes
				if (w.getSpeed() == 1 && this.beach.boat.getSpeed() < 0) {
					w.waveType = "Large";
					g.drawImage(waveImages[2], -this.beach.boat.xCoord, w.getyCoord() + 160, null);
				}
				
				if (w.getSpeed() == 1 && this.beach.boat.getSpeed() > 0) {
					w.waveType = "Large";
					g.drawImage(waveImages[2], this.beach.boat.xCoord, w.getyCoord() + 160, null);
				}

				
				if (w.getSpeed() == 2 && this.beach.boat.getSpeed() < 0) {
					w.waveType = "Medium";
					g.drawImage(waveImages[1], -this.beach.boat.xCoord, w.getyCoord() + 160, null);
				}
				
				if (w.getSpeed() == 2 && this.beach.boat.getSpeed() > 0) {
					w.waveType = "Medium";
					g.drawImage(waveImages[1], this.beach.boat.xCoord, w.getyCoord() + 160, null);
				}

				if (w.getSpeed() == 3 && this.beach.boat.getSpeed() < 0) {
					w.waveType = "Small";
					g.drawImage(waveImages[0], -this.beach.boat.xCoord, w.getyCoord() + 160, null);
				}
				
				if (w.getSpeed() == 3 && this.beach.boat.getSpeed() > 0) {
					w.waveType = "Small";
					g.drawImage(waveImages[0], this.beach.boat.xCoord, w.getyCoord() + 160, null);
				}
			}

			for (Boat b : this.beach.boats) {
				if (b.getSpeed() > 0) {
					g.drawImage(boatImages[0], b.getxCoord(), b.getyCoord(), null);
					b.setWidth(boatImages[0].getWidth());
					b.setHeight(boatImages[0].getHeight());
				}
				if (b.getSpeed() < 0) {
					g.drawImage(boatImages[1], b.getxCoord(), b.getyCoord(), null);
					b.setWidth(boatImages[1].getWidth());
					b.setHeight(boatImages[1].getHeight());
				}

			}

			g.drawImage(clock, 975, 10, null);

			backButton.paint(g);
			// addGabion.paint(g);
			// addWall.paint(g);
			// addGrass.paint(g);

			// Adding images of beach fortifications

			if (this.beach.addedGab) {
				g.drawImage(Gabby, this.beach.gabion.xCoord, this.beach.gabion.yCoord, null);
			}

			if (this.beach.addedWal) {
				g.drawImage(Wally, this.beach.wall.xCoord, this.beach.wall.yCoord, null);
			}

			if (this.beach.addedGra) {
				g.drawImage(Gass, this.beach.grass.xCoord, this.beach.grass.yCoord, null);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getButtonWidth() {
		return buttonWidth;
	}

	public void setButtonWidth(int buttonWidth) {
		this.buttonWidth = buttonWidth;
	}

	public int getButtonHeight() {
		return buttonHeight;
	}

	public void setButtonHeight(int buttonHeight) {
		this.buttonHeight = buttonHeight;
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

	public String getPlayerIcon() {
		return playerIcon;
	}

	public void setPlayerIcon(String playerIcon) {
		this.playerIcon = playerIcon;
	}

	public String getTimer() {
		return timer;
	}

	public void setTimer(String timer) {
		this.timer = timer;
	}

	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

	public String getWave() {
		return wave;
	}

	public void setWave(String wave) {
		this.wave = wave;
	}

	public JButton getAddGabion() {
		return addGabion;
	}

	public void setAddGabion(JButton addGabion) {
		this.addGabion = addGabion;
	}

	public JButton getAddWall() {
		return addWall;
	}

	public void setAddWall(JButton addWall) {
		this.addWall = addWall;
	}

	public JButton getAddGrass() {
		return addGrass;
	}

	public void setAddGrass(JButton addGrass) {
		this.addGrass = addGrass;
	}

	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}

}
