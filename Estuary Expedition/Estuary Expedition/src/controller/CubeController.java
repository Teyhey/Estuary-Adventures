package controller;

import java.awt.event.KeyListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import model.CubeModel;
import model.GameModel;
import view.BeachView;
import view.CubeView;
import view.MazeView;

public class CubeController extends CubeModel{
	
	public JFrame frame = new JFrame();
	CubeModel cModel;
	CubeView cView;
	MouseAdapter cubeController;
	
	public CubeController()
	{
		cModel = new CubeModel();
		cubeController = new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				if ((x >= cModel.getRollDiceXLoc() && x <= (cModel.getRollDiceXLoc()) + cModel.getRollDiceEdge())
						&& (y >= cModel.getRollDiceYLoc() && (y <= cModel.getRollDiceYLoc() + cModel.getRollDiceEdge())))
				{
					cView.rollDice();
					cubeState = "rolling";
					frame.addMouseListener(cubeController);
					
				}
					//mazeView = new MazeView();
					//gameState = "Maze";
					//frame.addKeyListener(cModel.);
				
	}
		};
		
		frame.addMouseListener(this.cubeController);
		
	
	
	
	}
	
	
	public MouseAdapter getController() {
		return cubeController;
	}
}

