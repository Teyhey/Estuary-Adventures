package view;

import java.awt.Graphics;
import javax.swing.JTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.swing.Timer;
import javax.swing.TransferHandler;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JTextArea;

import controller.CubeController;

public class CubeView extends CubeController {
	/**
	 * This class handles the view components for the Cube Game.
	 * @param
	 * @author John Tejeda, Tyler Hill, Stephen Lu, Devarshi Patel
	 * @version ALPHA
	 */
	
	int buttonWidth = 100;
	int buttonHeight = 50;
	int frameWidth = 1280;
	int frameHeight = 800;
	int randomPic;
	int arraySpot;
	String[] dicePics = { "Game Files/DeadFish.jpg", "Game Files/DogPoop.jpg", "Game Files/Heart.jpg",
			"Game Files/RoofGuy.jpg", "Game Files/Wizzel.jpg", "Game Files/Crab.jpg", "Game Files/Chicken.jpg" };
	String dice1;
	String dice2;
	String dice3;
	Random rand = new Random();
	JButton backButton;
	JButton rollDice;
	JButton submit;
	JTextField userStory;
	
	JTextArea holder = new JTextArea("THIS IS THE CUBE GAME");

	/**
	 * This method is fairly straight forward.
	 * It takes nothing in.
	 * @param none.
	 * @return the back JButton.
	 */
	public JButton getBackButton() {
		return backButton;
	}
	
	/**
	 * This method is fairly straight forward.
	 * It takes nothing in.
	 * @param none.
	 * @return the roll JButton.
	 */
	public JButton getRollDiceButton(){
		return rollDice;
	}
	
	public JButton getSubmitButton(){
		return submit;
	}
	
	public JTextField getStory(){
		return userStory;
	}
	

	/**
	 * Class Constructor
	 * Sets the necessary fields.
	 * @param none.
	 * @return void.
	 */
	public CubeView() {
		super();
		
		backButton = new JButton("Exit");
		backButton.setSize(buttonWidth, buttonHeight);
		backButton.setLocation(0, 0);
		
		rollDice = new JButton("Roll Dice");
		rollDice.setSize(100, 50);
		rollDice.setLocation(100, 400);
		
		submit = new JButton("Submit Story");
		submit.setSize(125, 50);
		submit.setLocation(500, 400);
		
		userStory = new JTextField("Enter your Story here");
		userStory.setSize(200, 50);
		userStory.setLocation(300, 400);
		
		//holder.setSize(200, 200);
		//holder.setLocation(200, 200);

		randomize();

	} 

	/**
	 * This method is responsible for randomizing all three cubes
	 * @param none.
	 * @return void.
	 */
	public void randomize(){

		randomPic = rand.nextInt(dicePics.length - 1) + 0;
		dice1 = dicePics[randomPic];
		
		randomPic = rand.nextInt(dicePics.length - 1) + 0;
		dice2 = dicePics[randomPic];
		
		randomPic = rand.nextInt(dicePics.length - 1) + 0;
		dice3 = dicePics[randomPic];
	}
	
	/**
	 * This method is responsible for drawing the graphics on Panel.
	 * @param g This is the only parameter in this method and is of Graphics type.
	 * @return void.
	 */
	public void draw(Graphics g) {
		try {
			
			
			
			BufferedImage diceUno;
			BufferedImage diceDos;
			BufferedImage diceTres;
			BufferedImage background = ImageIO.read(new File("Game Files/2D_estuary.jpg"));
			g.drawImage(background, 0, 0, null);

			diceUno = ImageIO.read(new File(dice1));
			diceDos = ImageIO.read(new File(dice2));
			diceTres = ImageIO.read(new File(dice3));

			backButton.repaint();
			rollDice.repaint();
			submit.repaint();
			userStory.repaint();
			
			
			
			
			g.drawImage(diceUno, 100, 100, null);
			g.drawImage(diceDos, 500, 100, null);
			g.drawImage(diceTres, 900, 100, null);
		

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}