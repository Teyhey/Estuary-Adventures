package controller;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.GameModel;
import view.BeachView;
import view.CubeView;
import view.MazeView;

public class GameController extends GameModel {

	protected JFrame frame = new JFrame();
	MouseAdapter controller;

	public GameController() {
		super();
		this.controller = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				if (gameState== "Menu"){
					menuControl(x, y);
				}
				else {
					if (gameState == "Maze"){
						mazeControl(x, y);
					}
					if (gameState == "Beach"){
						beachControl(x, y);
					}
					if (gameState == "Cube"){
						cubeControl(x, y);
					}
				}
			}
		};
		frame.addMouseListener(this.controller);
	}

	public void mazeControl(int x, int y){
		returnToMenu(x, y);
		if (this.mazeView.isTutorial() && this.mazeView.getTutorialStep() == 0 &&
				y >= this.mazeView.getButtonY() && y <= this.mazeView.getButtonY() + this.mazeView.getButtonSide()){
			if (x >= this.mazeView.getYesButtonX() && x <= this.mazeView.getYesButtonX() + this.mazeView.getButtonSide()){
				mazeView = new MazeView(true, 1);
				frame.addKeyListener(mazeView);
			}
			if (x >= this.mazeView.getNoButtonX() && x <= this.mazeView.getNoButtonX() + this.mazeView.getButtonSide()){
				mazeView = new MazeView();
				frame.addKeyListener(mazeView);
			}
		}
		if ((!this.mazeView.isTutorial() && (this.mazeView.getTimeLeft() <= 0 || this.mazeView.maze.player.health <= 0)) && 
				y >= this.mazeView.getButtonY() && y <= this.mazeView.getButtonY() + this.mazeView.getButtonSide()){
			if (x >= this.mazeView.getYesButtonX() && x <= this.mazeView.getYesButtonX() + this.mazeView.getButtonSide()){
				mazeView = new MazeView(true, 0);
				frame.addKeyListener(mazeView);
			}
			if (x >= this.mazeView.getNoButtonX() && x <= this.mazeView.getNoButtonX() + this.mazeView.getButtonSide()){
				gameState = "Menu";
			}
		}
		if ((this.mazeView.maze.getCurrDistance() == this.mazeView.maze.getDistance()) && 
				y >= this.mazeView.getButtonY() && y <= this.mazeView.getButtonY() + this.mazeView.getButtonSide()){
			if (x >= this.mazeView.getYesButtonX() && x <= this.mazeView.getYesButtonX() + this.mazeView.getButtonSide()){
				mazeView = new MazeView(true, 0);
				frame.addKeyListener(mazeView);
			}
			if (x >= this.mazeView.getNoButtonX() && x <= this.mazeView.getNoButtonX() + this.mazeView.getButtonSide()){
				gameState = "Menu";
			}
		}
	}
	
	public void beachControl(int x , int y){
		returnToMenu(x, y);		
	}

	public void cubeControl(int x, int y){
		returnToMenu(x, y);
		if ((x >= 150 && x <= 250) && (y >= 350 && y <= 450))
		{
			cubeView.cubeState = "rolling";

			for(int i = 0; i < 6; i++)
			{
				cubeView.rollDice();
			}
			
			cubeView.cubeState = "non-rolling";
		}
		
		if (x >= 300 && x <= 600 && y >= 300 && y <= 400){
			String test1= JOptionPane.showInputDialog("Please enter your story:");
			cubeView.storyDone = test1;
		}
		
		if((x >= 50 && x <= 250) && (y >= 100 && y <= 300)){
			
			cubeView.diceState = "die1";
		}
		
		if((x >= 300 && x <= 500) && (y >= 100 && y <= 300)){
			
			cubeView.diceState = "die2";
		}

		if((x >= 550 && x <= 750) && (y >= 100 && y <= 300)){
	
			cubeView.diceState = "die3";
		}
		
		if((x >= 800 && x <= 1000) && (y >= 100 && y <= 300)){
			
			cubeView.diceState = "die4";
		}
		
		if((x >= 1050 && x <= 1250) && (y >= 100 && y <= 300)){
			
			cubeView.diceState = "die5";
		}
		
		
		if((x >= 500 && x <= 700) && (y >= 500 && y <= 700)){
			
			if(cubeView.diceState.equals("die1"));
			{
				
			}
		}
		
		
	}

	public void menuControl(int x, int y){
		if ((x >= menuView.getMazeButtonX() && x <= menuView.getMazeButtonX() + menuView.getButtonSide())
				&& (y >= menuView.getMazeButtonY() && y <= menuView.getMazeButtonY() + menuView.getButtonSide())) {
			mazeView = new MazeView(true, 0);
			gameState = "Maze";
		}
		if ((x >= menuView.getBeachButtonX() && x <= menuView.getBeachButtonX() + menuView.getButtonSide())
				&& (y >= menuView.getBeachButtonY()
				&& y <= menuView.getBeachButtonY() + menuView.getButtonSide())) {
			beachView = new BeachView();
			gameState = "Beach";
			frame.addKeyListener(beachView);
		}
		if ((x >= menuView.getCubeButtonX() && x <= menuView.getCubeButtonX() + menuView.getButtonSide())
				&& (y >= menuView.getCubeButtonY() && y <= menuView.getCubeButtonY() + menuView.getButtonSide())) {
			cubeView = new CubeView();
			gameState = "Cube";
		}
		if (x <= menuView.getExitSize() && y <= menuView.getExitSize()){
			System.exit (0);
		}
	}

	public void returnToMenu(int x, int y){
		if (x <= menuView.getExitSize() && y <= menuView.getExitSize()) {
			gameState = "Menu";
		}
	}

	public MouseAdapter getController() {
		return controller;
	}
	
	public JFrame getFrame(){
		return frame;
	}

}
