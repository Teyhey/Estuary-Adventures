package view;

import java.awt.Color;
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
	public String diceState;
	int buttonWidth = 100;
	int buttonHeight = 50;
	int frameWidth = 1280;
	int frameHeight = 800;
	int randomPic;
	int randomPic2;
	int randomPic3;
	int randomPic4;
	int randomPic5;
	int arraySpot;
	String[] dicePics = { "Game Files/Die1.png", "Game Files/Die2.png", "Game Files/Die3.png",
			"Game Files/Die4.png", "Game Files/Die5.png", "Game Files/Die6.png", "Game Files/Die7.png"
			,"Game Files/Die8.png","Game Files/Die9.png","Game Files/Die10.png"};
	String dice1;
	String dice2;
	String dice3;
	String dice4;
	String dice5;
	int buttonXCoord;
	
	int dieX;
	int dieY;
	
	
	Random rand = new Random();
	JButton submit;
	JTextField userStory;
	public String storyDone = "";

	
	//JTextArea holder = new JTextArea("THIS IS THE CUBE GAME");

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
		diceState = "";
		
		dieX = 0;
		dieY = 0;
		
		submit = new JButton("Submit Story");
		submit.setSize(125, 50);
		submit.setLocation(500, 400);
		
		userStory = new JTextField("Enter your Story here");
		userStory.setSize(200, 50);
		userStory.setLocation(300, 400);
		
		randomPic = rand.nextInt(dicePics.length - 1) + 0;
		randomPic2 = rand.nextInt(dicePics.length - 1) + 0;
		randomPic3 = rand.nextInt(dicePics.length - 1) + 0;
		randomPic4 = rand.nextInt(dicePics.length - 1) + 0;
		randomPic5 = rand.nextInt(dicePics.length - 1) + 0;
		
		rollDice();
		
	} 
	
	public void updateX(int x)
	{
		dieX = x;
		
	}
	
	public void updateY(int y)
	{
		dieY = y;
		
	}

	/**
	 * This method is responsible for randomizing all three cubes
	 * @param none.
	 * @return void.
	 */
	public void rollDice(){

		randomPic = rand.nextInt(dicePics.length - 1) + 0;
		dice1 = dicePics[randomPic];
		
		randomPic2 = rand.nextInt(dicePics.length - 1) + 0;
		while(randomPic == randomPic2){
			randomPic2 = rand.nextInt(dicePics.length - 1) + 0;
			dice2 = dicePics[randomPic2];
		}
		dice2 = dicePics[randomPic2];

		
		randomPic3 = rand.nextInt(dicePics.length - 1) + 0;
		while((randomPic3 == randomPic2) || (randomPic3 == randomPic)){
			randomPic3 = rand.nextInt(dicePics.length - 1) + 0;
			dice3 = dicePics[randomPic3];
		}
		dice3 = dicePics[randomPic3];

		randomPic4 = rand.nextInt(dicePics.length - 1) + 0;
		while((randomPic4 == randomPic3) || (randomPic4 == randomPic2) || (randomPic4 == randomPic)){
			
			randomPic4 = rand.nextInt(dicePics.length - 1) + 0;
			dice4 = dicePics[randomPic4];
		}
		dice4 = dicePics[randomPic4];

		randomPic5 = rand.nextInt(dicePics.length - 1) + 0;
		while((randomPic5 == randomPic4) || (randomPic5 == randomPic3) || (randomPic5 == randomPic2)
				|| (randomPic5 == randomPic)){
			
			randomPic5 = rand.nextInt(dicePics.length - 1) + 0;
			dice5 = dicePics[randomPic5];
		}
		dice5 = dicePics[randomPic5];

		
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

		
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.PLAIN, 30));
			//g.drawString("Rearrange your cubes below:", 50, 475);
			
			updateX(50);
			updateY(100);
			g.drawImage(diceOne, dieX, dieY, null);
			
			updateX(300);
			updateY(100);
			g.drawImage(diceTwo, dieX, dieY, null);
			
			updateX(550);
			updateY(100);
			g.drawImage(diceThree, dieX, dieY, null);
			
			updateX(800);
			updateY(100);
			g.drawImage(diceFour, dieX, dieY, null);
			
			updateX(1050);
			updateY(100);
			g.drawImage(diceFive, dieX, dieY, null);
			
			//place holders to move the dice
			/*
			g.setColor(Color.WHITE);
			g.fillRect(50, 500, 200, 200);
			g.fillRect(300, 500, 200, 200);
			g.fillRect(550, 500, 200, 200);
			g.fillRect(800, 500, 200, 200);
			g.fillRect(1050, 500, 200, 200);
			 */
			
			while(this.diceState.equals("die1"))
			{
				g.drawImage(diceOne, 50, 500, null);

			}
			
		g.drawString(storyDone, 100, 750);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}