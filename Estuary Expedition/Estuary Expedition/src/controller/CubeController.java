package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import model.CubeModel;
import view.CubeView;

public class CubeController extends CubeModel{
	
	public JFrame frame = new JFrame();
	CubeModel cModel;
	CubeView cView;
	MouseAdapter cubeController;
	
	public CubeController()
	{
		//this.cView = new CubeView();
		cModel = new CubeModel();
		cubeController = new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				if ((x >= cModel.getRollDiceXLoc() && x <= (cModel.getRollDiceXLoc()) + cModel.getRollDiceEdge())
						&& (y >= cModel.getRollDiceYLoc() && (y <= cModel.getRollDiceYLoc() + cModel.getRollDiceEdge())))
				{
					for(int i = 0; i < 10; i++){
						//cView.rollDice();
						cubeState = "rolling";
						frame.addMouseListener(cubeController);
						cubeState = "non-rolling";
					}
						
				}
				
	}
		};
		
		frame.addMouseListener(this.cubeController);
	
	
	}
	
	//public void tick() {
	//	cView.rollDice();
	//}
	
	public MouseAdapter getController() {
		return cubeController;
	}
}

