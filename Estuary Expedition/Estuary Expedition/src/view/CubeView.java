package view;

import java.awt.Font;
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
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import controller.CubeController;
import model.CubeModel;

public class CubeView extends CubeController {
	/**
	 * This class handles the view components for the Cube Game.
	 * @param
	 * @author John Tejeda, Tyler Hill, Stephen Lu, Devarshi Patel
	 * @version RELEASE
	 */
	
	public String cubeState;
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
	String dice4;
	String dice5;
	Random rand = new Random();
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
		
		cubeState = "non-rolling";
		
		submit = new JButton("Submit Story");
		submit.setSize(125, 50);
		submit.setLocation(500, 400);
		
		userStory = new JTextField("Enter your Story here");
		userStory.setSize(200, 50);
		userStory.setLocation(300, 400);
		dice1 = dicePics[randomPic];
		dice2 = dicePics[randomPic];
		dice3 = dicePics[randomPic];
		dice4 = dicePics[randomPic];
		dice5 = dicePics[randomPic];
	} 

	/**
	 * This method is responsible for randomizing all three cubes
	 * @param none.
	 * @return void.
	 */
	public void rollDice(){

		randomPic = rand.nextInt(dicePics.length - 1) + 0;
		dice1 = dicePics[randomPic];
		
		randomPic = rand.nextInt(dicePics.length - 1) + 0;
		dice2 = dicePics[randomPic];
		
		randomPic = rand.nextInt(dicePics.length - 1) + 0;
		dice3 = dicePics[randomPic];
		
		randomPic = rand.nextInt(dicePics.length - 1) + 0;
		dice4 = dicePics[randomPic];
		
		randomPic = rand.nextInt(dicePics.length - 1) + 0;
		dice5 = dicePics[randomPic];
		
	}
	
	/**
	 * This method is responsible for drawing the graphics on Panel.
	 * @param g This is the only parameter in this method and is of Graphics type.
	 * @return void.
	 */
	public void draw(Graphics g) {
		try {
			
			BufferedImage diceOne;
			BufferedImage diceTwo;
			BufferedImage diceThree;
			BufferedImage diceFour;
			BufferedImage diceFive;
			BufferedImage exit;
			BufferedImage rollDice;
			
			BufferedImage background = ImageIO.read(new File("Game Files/2D_estuary.jpg"));
			g.drawImage(background, 0, 0, null);
			
			exit = ImageIO.read(new File("Game Files/Exit_Button.png"));
			g.drawImage(exit, 0, 0, null);
			
			rollDice = ImageIO.read(new File("Game Files/RollDice.jpg"));
			g.drawImage(rollDice, 100, 325, null);
			
			g.setFont(new Font("ComicSans", Font.PLAIN, 30));
			g.drawString("(Click HERE to Enter your Story)", 300, 375);
			
			diceOne = ImageIO.read(new File(dice1));
			diceTwo = ImageIO.read(new File(dice2));
			diceThree = ImageIO.read(new File(dice3));
			diceFour = ImageIO.read(new File(dice4));
			diceFive = ImageIO.read(new File(dice5));

			g.drawImage(diceOne, 50, 100, null);
			g.drawImage(diceTwo, 300, 100, null);
			g.drawImage(diceThree, 550, 100, null);
			g.drawImage(diceFour, 800, 100, null);
			g.drawImage(diceFive, 1050, 100, null);
		
			if(this.cubeState.equals("rolling"))
			{
				rollDice();
				
				
				/*
				Random rand = new Random();
				int index = rand.nextInt(7);
				diceOne = ImageIO.read(new File(dicePics[index]));
				diceTwo = ImageIO.read(new File(dicePics[index]));
				diceThree = ImageIO.read(new File(dicePics[index]));
				diceFour = ImageIO.read(new File(dicePics[index]));
				diceFive = ImageIO.read(new File(dicePics[index]));
				*/
				g.drawImage(diceOne, 50, 100, null);
				g.drawImage(diceTwo, 300, 100, null);
				g.drawImage(diceThree, 550, 100, null);
				g.drawImage(diceFour, 800, 100, null);
				g.drawImage(diceFive, 1050, 100, null);
			}
			/*frame.add(userStory);
			userStory.repaint();*/
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}