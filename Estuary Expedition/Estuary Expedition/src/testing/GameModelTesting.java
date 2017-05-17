package testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.GameModel;
import view.BeachView;
import view.CubeView;
import view.MazeView;
import view.MenuView;

public class GameModelTesting {
	
	// All first tests pass and the seconds fail.
	// --------------GameState Test-------------
	
	@Test
	public void testGetGameState1(){
		GameModel gm = new GameModel();
		assertEquals("Menu", gm.getGameState());
	}
	
	@Test
	public void testGetGameState2(){
		GameModel gm = new GameModel();
		assertEquals("Maze", gm.getGameState());
	}
	
	// --------------MazeView Test--------------
	
	@Test
	public void testGetMazeView1(){
		GameModel gm = new GameModel();
		assertEquals(null, gm.getMazeView());
	}

	@Test
	public void testGetMazeView2(){
		GameModel gm = new GameModel();
		assertEquals(new MazeView(), gm.getMazeView());
	}

	// --------------BeachView Test-------------
	
	@Test
	public void testGetBeachView1(){
		GameModel gm = new GameModel();
		assertEquals(null, gm.getBeachView());
	}
	
	@Test
	public void testGetBeachView2(){
		GameModel gm = new GameModel();
		assertEquals(new BeachView(), gm.getBeachView());
	}
	// --------------CubeView Test--------------
	
	@Test
	public void testGetCubeView1(){
		GameModel gm = new GameModel();
		assertEquals(null, gm.getCubeView());
	}
	
	@Test
	public void testGetCubeView2(){
		GameModel gm = new GameModel();
		assertEquals(new CubeView(), gm.getCubeView());
	}
	// --------------MenuView Test--------------
	
	@Test
	public void testGetMenuView1(){
		GameModel gm = new GameModel();
		assertEquals(new MenuView().getButtonSide(), gm.getMenuView().getButtonSide());
	}
	
	@Test
	public void testGetMenuView2(){
		GameModel gm = new GameModel();
		assertEquals(null, gm.getMenuView());
	}
}
