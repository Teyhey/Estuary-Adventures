package model;

import java.awt.Dimension;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Toolkit;

import view.CubeView;

public class CubeModel {
	
	public String cubeState;
	protected int frameWidth;
	protected int frameHeight;
	protected int rollDiceXLoc;
	protected int rollDiceYLoc;
	protected int rollDiceEdge;

	public JButton submit;
	public JTextField userStory;
	protected int randomPic;
	Random rand = new Random();

	
	public CubeModel()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
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
