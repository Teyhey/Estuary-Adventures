package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import model.GameModel;
import view.BeachView;
import view.CubeView;
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
				if ((x >= menuView.getMazeButtonX() && x <= menuView.getMazeButtonX() + menuView.getButtonSide())
						&& (y >= menuView.getMazeButtonY() && y <= menuView.getMazeButtonY() + menuView.getButtonSide()
								&& gameState == "Menu")) {
					mazeView = new MazeView();
					gameState = "Maze";
					frame.addKeyListener(mazeView);
				}
				if ((x >= menuView.getBeachButtonX() && x <= menuView.getBeachButtonX() + menuView.getButtonSide())
						&& (y >= menuView.getBeachButtonY()
								&& y <= menuView.getBeachButtonY() + menuView.getButtonSide() && gameState == "Menu")) {
					beachView = new BeachView();
					frame.addKeyListener(beachView);
					gameState = "Beach";
				}
				if ((x >= menuView.getCubeButtonX() && x <= menuView.getCubeButtonX() + menuView.getButtonSide())
						&& (y >= menuView.getCubeButtonY() && y <= menuView.getCubeButtonY() + menuView.getButtonSide()
								&& gameState == "Menu")) {
					cubeView = new CubeView();
					gameState = "Cube";
				}
				if (x <= menuView.getExitSize() && y <= menuView.getExitSize() 
						&& gameState == "Menu"){
		            System.exit (0);
				}
				if (x <= menuView.getExitSize() && y <= menuView.getExitSize()) {
					gameState = "Menu";
				}
			}
		};
		frame.addMouseListener(this.controller);
	}

	public MouseAdapter getController() {
		return controller;
	}

}
