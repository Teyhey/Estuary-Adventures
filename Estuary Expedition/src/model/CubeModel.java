package model;

import java.awt.Dimension;
import java.awt.Toolkit;

public class CubeModel {
	
	protected int frameWidth;
	protected int frameHeight;
	protected int rollDiceXLoc;
	protected int rollDiceYLoc;
	
	public CubeModel()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.frameWidth = (int) screenSize.getWidth();
		this.frameHeight = (int) screenSize.getHeight();
		this.rollDiceXLoc = (frameWidth / 2 - buttonSide / 2) - buttonSide * 2;
		this.rollDiceYLoc = (frameHeight / 2 - buttonSide / 2);
		
	}

	
	
	
	
	
	
}
