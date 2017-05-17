package model;

import view.BeachView;

import view.CubeView;
import view.MazeView;
import view.MenuView;

public class GameModel {
	
	protected String gameState;
	protected MazeView mazeView;
	protected BeachView beachView;
	protected CubeView cubeView;
	protected MenuView menuView;

	public GameModel(){
		this.menuView = new MenuView();
		this.gameState = "Menu";
	}

	public String getGameState() {
		return gameState;
	}

	public MazeView getMazeView() {
		return mazeView;
	}

	public BeachView getBeachView() {
		return beachView;
	}

	public CubeView getCubeView() {
		return cubeView;
	}

	public MenuView getMenuView() {
		return menuView;
	}
	
	
}
