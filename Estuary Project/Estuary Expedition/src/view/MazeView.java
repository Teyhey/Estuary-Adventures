package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import controller.MazeController;
import model.Player;

public class MazeView extends MazeController{
	/**
	 * This class handles the view components for the Maze Game.
	 * @param
	 * @author John Tejeda, Tyler Hill, Stephen Lu, Devarshi Patel
	 * @version ALPHA
	 */
	int buttonWidth = 50;
	int buttonHeight = 50;
	int frameWidth = 1280;
	int frameHeight = 800;
	String playerIcon;
	String salinity;
	String timer;
	String badGuy;
	//String rocks;
	//JTextArea holder = new JTextArea ("Work in Progress :)");
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
	 * Sets the fields.
	 * @param None
	 * @return void.
	 */
	public MazeView(){
		super();
		backButton = new JButton ("Exit");
		backButton.setSize(buttonWidth, buttonHeight);
		backButton.setLocation(0, 0);
		
		//holder.setSize(200, 50);
		//holder.setLocation(200, 200);
		
		playerIcon = "Game Files/bluecrab_back.png";
		salinity = "Game Files/SalinityMeter.png";
		timer = "Game Files/timer.png";
		badGuy = "Game Files/fish_bass_right.png";
	}
	
	/**
	 * This method is responsible for drawing the graphics on Panel.
	 * @param g This is the only parameter in this method and is of Graphics type.
	 * @return void.
	 */
	public void draw(Graphics g){
		try {
		BufferedImage icon;
		BufferedImage salt;
		BufferedImage clock;
		BufferedImage enemy;
			BufferedImage background = ImageIO.read(new File("Game Files/MazeIntro.png"));
			g.drawImage(background, 0, 0, null);
			
			icon = ImageIO.read(new File(playerIcon));
			salt = ImageIO.read(new File(salinity));
			clock = ImageIO.read(new File(timer));
			enemy = ImageIO.read(new File(badGuy));
			
			
			g.drawImage(icon, this.maze.player.getxCoord() , this.maze.player.getyCoord(), null);
			g.drawImage(salt, 1175 , 475, null);
			g.drawImage(clock, 975 , 10, null);
			g.drawImage(enemy, this.maze.enemy.getxCoord(), this.maze.enemy.getyCoord(), null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
