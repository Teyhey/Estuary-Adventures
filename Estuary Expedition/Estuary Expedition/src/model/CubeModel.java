package model;

import java.awt.Dimension;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Toolkit;

import view.CubeView;

public class CubeModel {
	
	public String cubeState;
	protected CubeView cView;
	protected int frameWidth;
	protected int frameHeight;
	protected int rollDiceXLoc;
	protected int rollDiceYLoc;
	protected int rollDiceEdge;
	protected String[] dicePics = { "Game Files/DeadFish.jpg", "Game Files/DogPoop.jpg", "Game Files/Heart.jpg",
			"Game Files/RoofGuy.jpg", "Game Files/Wizzel.jpg", "Game Files/Crab.jpg", "Game Files/Chicken.jpg" };
	protected String dice1;
	protected String dice2;
	protected String dice3;
	protected String dice4;
	protected String dice5;
	public JButton submit;
	public JTextField userStory;
	protected int randomPic;
	Random rand = new Random();

	
	public CubeModel()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.cView = null;
		this.cubeState = "not-rolling";
		this.frameWidth = (int) screenSize.getWidth();
		this.frameHeight = (int) screenSize.getHeight();
		this.rollDiceXLoc = 150;
		this.rollDiceYLoc = 350;
		this.rollDiceEdge = 100;
		
		this.submit = new JButton("Submit Story");
		this.submit.setSize(125, 50);
		this.submit.setLocation(500, 400);
		
		this.userStory = new JTextField("Enter your Story here.");
		this.userStory.setSize(200, 50);
		this.userStory.setLocation(300, 400);
		
	}
	
	public void rollDice()
	{
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
	
	public int getRollDiceXLoc()
	{
		return rollDiceXLoc;
	}
	
	public int getRollDiceYLoc()
	{
		return rollDiceYLoc;
	}
	
	public int getRollDiceEdge()
	{
		return rollDiceEdge;
	}
	
	public JButton getSubmitButton()
	{
		return submit;
	}
	
	public JTextField getStoryField()
	{
		return userStory;
	}

	
	
	
	
	
	
}
