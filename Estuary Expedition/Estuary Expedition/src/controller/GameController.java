package controller;

import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.GameModel;
import view.BeachView;
import view.CubeView;
import view.GameView;
import view.MazeView;

public class GameController extends GameModel {

	public JFrame frame = new JFrame();
	MouseAdapter controller;

	public GameController() {
		super();
		this.controller = new MouseAdapter() {
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
					if (gameState == "Cube"){
						cubeControl(x, y);
					}
				}
			}
		};
		frame.addMouseListener(this.controller);
	}

	private void mazeControl(int x, int y){
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
				mazeView = new MazeView(true, 1);
				frame.addKeyListener(mazeView);
			}
			if (x >= this.mazeView.getNoButtonX() && x <= this.mazeView.getNoButtonX() + this.mazeView.getButtonSide()){
				gameState = "Menu";
			}
		}
		if ((this.mazeView.maze.getCurrDistance() == this.mazeView.maze.getDistance()) && 
				y >= this.mazeView.getButtonY() && y <= this.mazeView.getButtonY() + this.mazeView.getButtonSide()){
			if (x >= this.mazeView.getYesButtonX() && x <= this.mazeView.getYesButtonX() + this.mazeView.getButtonSide()){
				mazeView = new MazeView(true, 1);
				frame.addKeyListener(mazeView);
			}
			if (x >= this.mazeView.getNoButtonX() && x <= this.mazeView.getNoButtonX() + this.mazeView.getButtonSide()){
				gameState = "Menu";
			}
		}
	}

	private void cubeControl(int x, int y){
		returnToMenu(x, y);
		if ((x >= 150 && x <= 250) && (y >= 350 && y <= 450))
		{
			cubeView.rollDice();
			for(int i = 0; i < 6; i++)
				cubeView.cubeState = "rolling";
			cubeView.cubeState = "non-rolling";

			//we will see if this works
			//back to square one of getting it to print out the new images
		}
		if (x >= 300 && x <= 600 && y >= 300 && y <= 400){
			String test1= JOptionPane.showInputDialog("Please enter your story:");
		}
	}

	private void menuControl(int x, int y){
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

	private void returnToMenu(int x, int y){
		if (x <= menuView.getExitSize() && y <= menuView.getExitSize()) {
			gameState = "Menu";
		}
	}

	public MouseAdapter getController() {
		return controller;
	}

}
