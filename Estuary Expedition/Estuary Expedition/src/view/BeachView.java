package view;

import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JTextArea;

import controller.BeachController;
import javafx.scene.text.Font;
import model.Boat;
import model.Item;
import model.Wave;

public class BeachView extends BeachController {

	/**
	 * This class handles the view components for the Beach Game.
	 * 
	 * @param
	 * @author John Tejeda, Tyler Hill, Stephen Lu, Devarshi Patel
	 * @version RELEASE
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
	String wave;
	String gabion;
	String wall;
	String grass;
	String oyst;
	String bloc;
	String sed;
	String exitIcon = "Game Files/Exit_Button.png";
	String[] boatz = { "Game Files/dirtyvesselRight.png", "Game Files/dirtyvesselLeft.png" };
	String[] wavez = { "Game Files/splashSMALL.png", "Game Files/splashMED.png", "Game Files/splashBIG.png" };
	String[] pickUps = { "Game Files/oyster.png", "Game Files/block.png", "Game Files/seeds/png" };

	JTextArea inventory;


	/**
	 * Class constructor Sets the fields for this class.
	 * 
	 * @param None
	 * @return void.
	 */
	public BeachView() {
		super();
		playerIcon = "Game Files/crab.png";
		timer = "Game Files/timer.png";
		wave = "Game Files/splashSMALL.png";
		boatL = "Game Files/dirtyvesselLeft.png";
		boatR = "Game Files/dirtyvesselRight.png";
		gabion = "Game Files/gabion.png";
		wall = "Game Files/Wall.png";
		grass = "Game Files/grass.png";
		oyst = "Game Files/oyster.png";
		bloc = "Game Files/block.png";
		sed = "Game Files/seeds.png";
		exitIcon = "Game Files/Exit_Button.png";

		inventory = new JTextArea("Oyster Shells: " + this.beach.numOysters + "/n" + "Blocks: " + this.beach.numBlocks
				+ "/n" + "Seeds: " + this.beach.numSeeds);
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
			BufferedImage[] waveImages;
			BufferedImage Gabby;
			BufferedImage Wally;
			BufferedImage Gass;
			BufferedImage clams;
			BufferedImage plant;
			BufferedImage cement;
			BufferedImage exit;

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
			Gabby = ImageIO.read(new File(gabion));
			Wally = ImageIO.read(new File(wall));
			Gass = ImageIO.read(new File(grass));
			clams = ImageIO.read(new File(oyst));
			cement = ImageIO.read(new File(bloc));
			plant = ImageIO.read(new File(sed));
			exit = ImageIO.read(new File(exitIcon));

			this.beach.player.setWidth(icon.getWidth());
			this.beach.player.setHeight(icon.getHeight());

		
			g.drawString("Oysters: " + beach.numOysters, 75, 15);
			g.drawString("Blocks: " + beach.numBlocks, 75, 35);
			g.drawString("Seeds: " + beach.numSeeds, 75, 55);

			for (Wave w : this.beach.waveArr) { // different speeds will produce
				// different wave sizes
				if (w.getSpeed() == 1 && this.beach.boat.getSpeed() < 0) {
					w.waveType = "Large";
					g.drawImage(waveImages[2], w.xCoord, w.yCoord, null);
				}

				if (w.getSpeed() == 1 && this.beach.boat.getSpeed() > 0) {
					w.waveType = "Large";
					g.drawImage(waveImages[2], w.xCoord, w.yCoord, null);
				}

				if (w.getSpeed() == 2 && this.beach.boat.getSpeed() < 0) {
					w.waveType = "Medium";
					g.drawImage(waveImages[1], w.xCoord, w.yCoord, null);
				}

				if (w.getSpeed() == 2 && this.beach.boat.getSpeed() > 0) {
					w.waveType = "Medium";
					g.drawImage(waveImages[1], w.xCoord, w.yCoord, null);
				}

				if (w.getSpeed() == 3 && this.beach.boat.getSpeed() < 0) {
					w.waveType = "Small";
					g.drawImage(waveImages[0], w.xCoord, w.yCoord, null);
				}

				if (w.getSpeed() == 3 && this.beach.boat.getSpeed() > 0) {
					w.waveType = "Small";
					g.drawImage(waveImages[0], w.xCoord, w.yCoord, null);
				}
			}

			for (Boat b : this.beach.boatArr) {
				if (b.getSpeed() > 0) {
					g.drawImage(boatImages[0], b.getxCoord(), b.getyCoord(), null);
					
				}
				if (b.getSpeed() < 0) {
					g.drawImage(boatImages[1], b.getxCoord(), b.getyCoord(), null);
					
				}

			}

			g.drawImage(clock, 975, 10, null);

			// Adding images of beach fortifications
			for (Item bar : this.beach.barriers) {
				if (bar.itemType.equals("Gabion")) {
					g.drawImage(Gabby, bar.xCoord, bar.yCoord, null);
				}

				if (bar.itemType.equals("Wall")) {
					g.drawImage(Wally, bar.xCoord, bar.yCoord, null);
				}

				if (bar.itemType.equals("Grass")) {
					g.drawImage(Gass, bar.xCoord, bar.yCoord, null);
				}
			}

			// Adding the currency to the game
			for (Item cur : this.beach.currencyArr) {
				if (cur.itemType.equals("Oyster")) {
					g.drawImage(clams, cur.xCoord, cur.yCoord, null);
				}

				if (cur.itemType.equals("Block")) {
					g.drawImage(cement, cur.xCoord, cur.yCoord, null);
				}

				if (cur.itemType.equals("Seed")) {
					g.drawImage(plant, cur.xCoord, cur.yCoord, null);
				}
			}
			g.drawImage(icon, this.beach.player.getxCoord(), this.beach.player.getyCoord(), null);
			g.drawImage(exit, 0, 0, null);
			g.drawString(this.getMessage(), this.beach.player.getxCoord(), this.beach.player.getyCoord());

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

	public String getWave() {
		return wave;
	}

	public void setWave(String wave) {
		this.wave = wave;
	}

}