package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JTextArea;

import controller.BeachController;

public class BeachView extends BeachController {
	
	/**
	 * This class handles the view components for the Beach Game.
	 * @param
	 * @author John Tejeda, Tyler Hill, Stephen Lu, Devarshi Patel
	 * @version ALPHA
	 */

	int buttonWidth = 50;
	int buttonHeight = 50;
	int frameWidth = 1280;
	int frameHeight = 800;
	String playerIcon;
	String boat;
	String timer;
	String inventory;
	JTextArea holder = new JTextArea("THIS IS THE BARRIER GAME");
	JButton backButton;

	/**
	 * This method is fairly straight forward.
	 * It takes nothing in.
	 * @param None
	 * @return the back JButton.
	 */
	public JButton getBackButton() {
		return backButton;
	}

	
	/**
	 * Class constructor
	 * Sets the fields for this class.
	 * @param None
	 * @return void.
	 */
	public BeachView() {
		super();
		backButton = new JButton("Exit");
		backButton.setSize(buttonWidth, buttonHeight);
		backButton.setLocation(0, 0);
		// holder.setSize(200, 200);
		// holder.setLocation(200, 200);

		playerIcon = "Game Files/crab.png";
		timer = "Game Files/timer.png";
		inventory = "Game Files/Inventory.png";
	}

	/**
	 * This method is responsible for drawing the graphics on Panel.
	 * @param g This is the only parameter in this method and is of Graphics type.
	 * @return void.
	 */
	public void draw(Graphics g) {
		try {
			BufferedImage icon;
			BufferedImage clock;
			BufferedImage slots;
			BufferedImage background = ImageIO.read(new File("Game Files/BeachAssault.png"));
			g.drawImage(background, 0, 0, null);

			icon = ImageIO.read(new File(playerIcon));
			clock = ImageIO.read(new File(timer));
			slots = ImageIO.read(new File(inventory));

			g.drawImage(icon, this.beach.player.getxCoord(), this.beach.player.getyCoord(), null);
			g.drawImage(slots, 0, 654, null);
			g.drawImage(clock, 975, 10, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
