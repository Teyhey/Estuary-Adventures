package testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controller.MazeController;
import model.MazeModel;

public class MazeControllerTesting {

	// All first tests pass and the seconds fail.

	// -------------X/Y-VEL TEST--------------------
	@Test
	public void testGetXVel1() {
		MazeController maze_controller = new MazeController(100);
		assertEquals(0, maze_controller.getxVel());
	}
	
	@Test
	public void testGetXVel2() {
		MazeController maze_controller = new MazeController(100);
		assertEquals(1, maze_controller.getxVel());
	}

	@Test
	public void testSetXVel1() {
		MazeController maze_controller = new MazeController(100);
		maze_controller.setxVel(3);
		assertEquals(3, maze_controller.getxVel());
	}

	@Test
	public void testSetXVel2() {
		MazeController maze_controller = new MazeController(100);
		maze_controller.setxVel(3);
		assertEquals(4, maze_controller.getxVel());
	}

	@Test
	public void testGetYVel1() {
		MazeController maze_controller = new MazeController(100);
		assertEquals(0, maze_controller.getyVel());
	}
	
	@Test
	public void testGetYVel2() {
		MazeController maze_controller = new MazeController(100);
		assertEquals(1, maze_controller.getyVel());
	}

	@Test
	public void testSetYVel1() {
		MazeController maze_controller = new MazeController(100);
		maze_controller.setyVel(3);
		assertEquals(3, maze_controller.getyVel());
	}

	@Test
	public void testSetYVel2() {
		MazeController maze_controller = new MazeController(100);
		maze_controller.setyVel(3);
		assertEquals(4, maze_controller.getyVel());
	}
	
	// -------------MAZE TEST--------------------
	@Test
	public void testMaze1() {
		MazeController maze_controller = new MazeController(100);
		MazeModel model_test = new MazeModel(100);
		maze_controller.maze = model_test;
		assertEquals(model_test, maze_controller.maze);
	}
	
	@Test
	public void testMaze2() {
		MazeController maze_controller = new MazeController(100);
		MazeModel model_test = new MazeModel(101);
		assertEquals(model_test, maze_controller.maze);
	}
	
	// -------------PADDING TEST--------------------
	@Test
	public void testGetPadding1() {
		MazeController maze_controller = new MazeController(100);
		assertEquals(100, maze_controller.getPadding());
	}
	
	@Test
	public void testGetPadding2() {
		MazeController maze_controller = new MazeController(100);
		assertEquals(101, maze_controller.getPadding());
	}
	
	@Test
	public void testSetPadding1() {
		MazeController maze_controller = new MazeController(100);
		maze_controller.setPadding(4);
		assertEquals(4, maze_controller.getPadding());
	}
	
	@Test
	public void testSetPadding2() {
		MazeController maze_controller = new MazeController(100);
		maze_controller.setPadding(4);
		assertEquals(100, maze_controller.getPadding());
	}
	
	// -------------TIME TEST--------------------
	@Test
	public void testGetTime1() {
		MazeController maze_controller = new MazeController(100);
		assertEquals(0, maze_controller.getTime());
	}
	
	@Test
	public void testGetTime2() {
		MazeController maze_controller = new MazeController(100);
		assertEquals(1, maze_controller.getTime());
	}
	
	@Test
	public void testSetTime1() {
		MazeController maze_controller = new MazeController(100);
		maze_controller.setTime(4);
		assertEquals(4, maze_controller.getTime());
	}
	
	@Test
	public void testSetTime2() {
		MazeController maze_controller = new MazeController(100);
		maze_controller.setTime(4);
		assertEquals(100, maze_controller.getTime());
	}
	
	// -------------VEL TEST--------------------
	@Test
	public void testGetVel1() {
		MazeController maze_controller = new MazeController(100);
		assertEquals(5, maze_controller.getVel());
	}
	
	@Test
	public void testGetVel2() {
		MazeController maze_controller = new MazeController(100);
		assertEquals(1, maze_controller.getVel());
	}
	
	@Test
	public void testSetVel1() {
		MazeController maze_controller = new MazeController(100);
		maze_controller.setVel(4);
		assertEquals(4, maze_controller.getVel());
	}
	
	@Test
	public void testSetVel2() {
		MazeController maze_controller = new MazeController(100);
		maze_controller.setVel(4);
		assertEquals(100, maze_controller.getVel());
	}
	
	// -------------MAX-HEALTH TEST--------------------
	@Test
	public void testGetMaxHealth1() {
		MazeController maze_controller = new MazeController(100);
		double health = 500.000;
		assertEquals(health, maze_controller.getMaxHealth(), 0.001);
	}
	
	@Test
	public void testGetMaxHealth2() {
		MazeController maze_controller = new MazeController(100);
		double health = 600.000;
		assertEquals(health, maze_controller.getMaxHealth(), 0.001);
	}
	
	@Test
	public void testSetMaxHealth1() {
		MazeController maze_controller = new MazeController(100);
		maze_controller.setMaxHealth(400.000);
		assertEquals(400.000, maze_controller.getMaxHealth(), 0.001);
	}
	
	@Test
	public void testSetHealth2() {
		MazeController maze_controller = new MazeController(100);
		maze_controller.setMaxHealth(400.000);
		assertEquals(300.000, maze_controller.getMaxHealth(), 0.001);
	}
	
	// -------------HIT-ROCK TEST--------------------
	@Test
	public void testGetHitRock1() {
		MazeController maze_controller = new MazeController(100);
		assertEquals(false, maze_controller.isHitRock());
	}
	
	@Test
	public void testGetHitRock2() {
		MazeController maze_controller = new MazeController(100);
		assertEquals(true, maze_controller.isHitRock());
	}
	
	@Test
	public void testSetHitRock1() {
		MazeController maze_controller = new MazeController(100);
		maze_controller.setHitRock(true);
		assertEquals(true, maze_controller.isHitRock());
	}
	
	@Test
	public void testSetHitRock2() {
		MazeController maze_controller = new MazeController(100);
		maze_controller.setHitRock(true);
		assertEquals(false, maze_controller.isHitRock());
	}
	
	// -------------HIT-FISH TEST--------------------
	@Test
	public void testGetHitFish1() {
		MazeController maze_controller = new MazeController(100);
		assertEquals(false, maze_controller.isHitFish());
	}
	
	@Test
	public void testGetHitFish2() {
		MazeController maze_controller = new MazeController(100);
		assertEquals(true, maze_controller.isHitFish());
	}
	
	@Test
	public void testSetHitFish1() {
		MazeController maze_controller = new MazeController(100);
		maze_controller.setHitFish(true);
		assertEquals(true, maze_controller.isHitFish());
	}
	
	@Test
	public void testSetHitFish2() {
		MazeController maze_controller = new MazeController(100);
		maze_controller.setHitFish(true);
		assertEquals(false, maze_controller.isHitFish());
	}
	
	// -------------TIME-LEFT TEST--------------------
	@Test
	public void testGetTimeLeft1() {
		MazeController maze_controller = new MazeController(100);
		assertEquals(120, maze_controller.getTimeLeft());
	}
	
	@Test
	public void testGetTimeLeft2() {
		MazeController maze_controller = new MazeController(100);
		assertEquals(1, maze_controller.getTimeLeft());
	}
	
	@Test
	public void testSetHitTimeLeft1() {
		MazeController maze_controller = new MazeController(100);
		maze_controller.setTimeLeft(3);
		assertEquals(3, maze_controller.getTimeLeft());
	}
	
	@Test
	public void testSetTimeLeft2() {
		MazeController maze_controller = new MazeController(100);
		maze_controller.setTimeLeft(3);
		assertEquals(2, maze_controller.getTimeLeft());
	}
	
	// -------------COLLISION TEST--------------------
	@Test
	public void testGetCollision1() {
		MazeController maze_controller = new MazeController(100);
		assertEquals(10, maze_controller.getCollision());
	}
	
	@Test
	public void testGetCollision2() {
		MazeController maze_controller = new MazeController(100);
		assertEquals(11, maze_controller.getCollision());
	}
	
	@Test
	public void testSetCollision1() {
		MazeController maze_controller = new MazeController(100);
		maze_controller.setCollision(9);
		assertEquals(9, maze_controller.getCollision());
	}
	
	@Test
	public void testSetCollision2() {
		MazeController maze_controller = new MazeController(100);
		maze_controller.setCollision(9);
		assertEquals(8, maze_controller.getCollision());
	}
	
	// -------------TIMER TEST--------------------
	@Test
	public void testGetTimer1() {
		MazeController maze_controller = new MazeController(100);
		assertEquals(System.currentTimeMillis(), maze_controller.getTimer());
	}
	
	@Test
	public void testGetTimer2() {
		MazeController maze_controller = new MazeController(100);
		assertEquals(11, maze_controller.getTimer());
	}
	
	@Test
	public void testSetTimer1() {
		MazeController maze_controller = new MazeController(100);
		maze_controller.setTimer(9);
		assertEquals(9, maze_controller.getTimer());
	}
	
	@Test
	public void testSetTimer2() {
		MazeController maze_controller = new MazeController(100);
		maze_controller.setTimer(9);
		assertEquals(8, maze_controller.getTimer());
	}
	
	
	
	// -------------TIME-TICK TEST--------------------
	@Test
	public void testTimeTick1() {
		MazeController maze_controller = new MazeController(100);
		maze_controller.timeTick();
		long t = maze_controller.getTimer();
		
		assertEquals(t, maze_controller.getTimer());
	}
	
	@Test
	public void testTimeTick2() {
		MazeController maze_controller = new MazeController(100);
		maze_controller.timeTick();
		
		assertEquals(System.currentTimeMillis(), maze_controller.getTimer());
	}
	
	// -------------TICK-OPACITY TEST--------------------
	@Test
	public void testTickOpacity1() {
		MazeController maze_controller = new MazeController(100);
		int op = maze_controller.getOpacityTick();
		maze_controller.tickOpacity();
		
		assertEquals(op, maze_controller.getOpacityTick());
	}
	
	@Test
	public void testTickOpacity2() {
		MazeController maze_controller = new MazeController(100);
		int op = maze_controller.getOpacityTick();
		maze_controller.tickOpacity();
		
		assertEquals(-2, maze_controller.getOpacityTick());
	}
	
	
	// -------------TICK-HEALTH-OPACITY TEST--------------------
	
	// -------------CHECK-PROGRESSION TEST--------------------
	
	// -------------PROGRESS TEST--------------------
	
	// -------------CHECK-BORDERS TEST--------------------
	
	// -------------CHECK-X-COLLISION-RIGHT TEST--------------------
	
	// -------------CHECK-X-COLLISION-LEFT TEST--------------------
	
	// -------------CHECK-Y-COLLISION-UP TEST--------------------
	
	// -------------CHECK-Y-COLLISION-DOWN TEST--------------------
	
	// -------------PATROL-HORIZONTAL TEST--------------------

	// -------------PATROL-VERTICAL TEST--------------------

	// -------------CHECK-HORIZONTAL-HIT TEST--------------------

	// -------------CHECK-VERTICAL-HIT TEST--------------------

	// -------------FISH-COLLIDE TEST--------------------

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
