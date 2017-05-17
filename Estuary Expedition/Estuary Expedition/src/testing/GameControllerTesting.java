package testing;

import static org.junit.Assert.*;

import java.awt.event.MouseAdapter;

import javax.swing.JFrame;

import org.junit.Test;

import controller.GameController;

public class GameControllerTesting {
	// All odd tests pass and even tests fail.
	
	// --------------GameState Test---------------
	
	@Test
	public void testGetGameState1(){
		GameController gc = new GameController();
		assertEquals("Menu", gc.getGameState());
	}
	
	@Test
	public void testGetGameState2(){
		GameController gc = new GameController();
		assertEquals("Maze", gc.getGameState());
	}
	
	// --------------Frame Test-------------------
	
	@Test
	public void testGetFrame1(){
		GameController gc = new GameController();
		JFrame f = new JFrame();
		assertEquals(f.getBackground(), gc.getFrame().getBackground());
	}
	
	@Test
	public void testGetFrame2(){
		GameController gc = new GameController();
		assertEquals(new JFrame(), gc.getFrame());
	}
	
	// --------------Controller Test--------------
	
	@Test
	public void testGetController1(){
		GameController gc = new GameController();
		assertNotNull(gc.getController());
	}
	
	@Test
	public void testGetController2(){
		GameController gc = new GameController();
		MouseAdapter m = new MouseAdapter() {};
		assertEquals(m, gc.getController());
	}
	
	// --------------ReturnToMenu Test------------
	
	@Test
	public void testReturnToMenu1(){
		GameController gc = new GameController();
		gc.returnToMenu(10,  10);
		assertEquals("Menu", gc.getGameState());
	}
	
	@Test
	public void testReturnToMenu2(){
		GameController gc = new GameController();
		gc.returnToMenu(100,  100);
		assertEquals("Maze", gc.getGameState());
	}

	// --------------MenuControl Test-------------
	
	@Test
	public void testMenuControl1(){
		GameController gc = new GameController();
		gc.menuControl(gc.getMenuView().getMazeButtonX(), gc.getMenuView().getMazeButtonY());
		assertEquals("Maze", gc.getGameState());
	}
	
	@Test
	public void testMenuControl2(){
		GameController gc = new GameController();
		gc.menuControl(gc.getMenuView().getBeachButtonX(), gc.getMenuView().getBeachButtonY());
		assertEquals("Maze", gc.getGameState());
	}
	
	// --------------MazeControl Test-------------

	@Test
	public void mazeControl1(){
		GameController gc = new GameController();
		gc.menuControl(gc.getMenuView().getMazeButtonX(), gc.getMenuView().getMazeButtonY());
		gc.mazeControl(gc.getMazeView().getYesButtonX(), gc.getMazeView().getButtonY());
		assertEquals("Maze", gc.getGameState());
	}
	
	@Test
	public void mazeControl2(){
		GameController gc = new GameController();
		gc.menuControl(gc.getMenuView().getMazeButtonX(), gc.getMenuView().getMazeButtonY());
		gc.mazeControl(0, 0);
		assertEquals("Maze", gc.getGameState());
	}
	
	@Test
	public void mazeControl3(){
		GameController gc = new GameController();
		gc.menuControl(gc.getMenuView().getMazeButtonX(), gc.getMenuView().getMazeButtonY());
		gc.mazeControl(gc.getMazeView().getNoButtonX(), gc.getMazeView().getButtonY());
		assertEquals(false , gc.getMazeView().isTutorial());
	}
	
	@Test
	public void mazeControl4(){
		GameController gc = new GameController();
		gc.menuControl(gc.getMenuView().getMazeButtonX(), gc.getMenuView().getMazeButtonY());
		gc.mazeControl(gc.getMazeView().getNoButtonX(), gc.getMazeView().getButtonY());
		gc.getMazeView().setTimeLeft(0);
		gc.mazeControl(gc.getMazeView().getYesButtonX(), gc.getMazeView().getButtonY());
		assertEquals(false, gc.getMazeView().isTutorial());
	}
	
	@Test
	public void mazeControl5(){
		GameController gc = new GameController();
		gc.menuControl(gc.getMenuView().getMazeButtonX(), gc.getMenuView().getMazeButtonY());
		gc.mazeControl(gc.getMazeView().getNoButtonX(), gc.getMazeView().getButtonY());
		gc.getMazeView().setTimeLeft(0);
		gc.mazeControl(gc.getMazeView().getNoButtonX(), gc.getMazeView().getButtonY());
		assertEquals("Menu", gc.getGameState());
		}
	
	@Test
	public void mazeControl6(){
		GameController gc = new GameController();
		gc.menuControl(gc.getMenuView().getMazeButtonX(), gc.getMenuView().getMazeButtonY());
		gc.mazeControl(gc.getMazeView().getNoButtonX(), gc.getMazeView().getButtonY());
		gc.getMazeView().setCurrDistance(gc.getMazeView().getDistance());
		gc.mazeControl(gc.getMazeView().getYesButtonX(), gc.getMazeView().getButtonY());
		assertEquals(true, gc.getMazeView().isTutorial());
	}
	
	/*@Test
	public void mazeControl7(){
		GameController gc = new GameController();
		gc.menuControl(gc.getMenuView().getMazeButtonX(), gc.getMenuView().getMazeButtonY());
		gc.mazeControl(0, 0);
		assertEquals("Maze", gc.getGameState());
	}*/
	// --------------BeachControl Test------------
	
	@Test
	public void beachControl1(){
		GameController gc = new GameController();
		gc.menuControl(gc.getMenuView().getBeachButtonX(), gc.getMenuView().getBeachButtonY());
		gc.beachControl(1000, 1000);
		assertEquals("Beach", gc.getGameState());
	}
	
	@Test
	public void beachControl2(){
		GameController gc = new GameController();
		gc.menuControl(gc.getMenuView().getBeachButtonX(), gc.getMenuView().getBeachButtonY());
		gc.beachControl(0, 0);
		assertEquals("Beach", gc.getGameState());
	}
	
	// --------------MenuControl Test-------------
	// --------------MenuControl Test-------------
	// --------------MenuControl Test-------------
	// --------------MenuControl Test-------------
	// --------------MenuControl Test-------------
	// --------------MenuControl Test-------------
	
	// --------------MenuControl Test-------------
}
