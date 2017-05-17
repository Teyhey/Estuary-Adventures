package controller;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

import javax.annotation.Generated;

import org.junit.Test;

@Generated(value = "org.junit-tools-1.0.5")
public class MazeControllerTest {

	private MazeController createTestSubject() {
		return new MazeController(0);
	}

	@MethodRef(name = "tick", signature = "()V")
	@Test
	public void testTick() throws Exception {
		MazeController testSubject;

		// default test
		testSubject = createTestSubject();
		testSubject.tick();
	}

	@MethodRef(name = "timeTick", signature = "()V")
	@Test
	public void testTimeTick() throws Exception {
		MazeController testSubject;

		// default test
		testSubject = createTestSubject();
		Deencapsulation.invoke(testSubject, "timeTick");
	}

	@MethodRef(name = "getxVel", signature = "()I")
	@Test
	public void testGetxVel() throws Exception {
		MazeController testSubject;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getxVel();
	}

	@MethodRef(name = "setxVel", signature = "(I)V")
	@Test
	public void testSetxVel() throws Exception {
		MazeController testSubject;
		int xVel = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setxVel(xVel);
	}

	@MethodRef(name = "getyVel", signature = "()I")
	@Test
	public void testGetyVel() throws Exception {
		MazeController testSubject;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getyVel();
	}

	@MethodRef(name = "setyVel", signature = "(I)V")
	@Test
	public void testSetyVel() throws Exception {
		MazeController testSubject;
		int yVel = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setyVel(yVel);
	}

	@MethodRef(name = "getTimeLeft", signature = "()I")
	@Test
	public void testGetTimeLeft() throws Exception {
		MazeController testSubject;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getTimeLeft();
	}

	@MethodRef(name = "setTimeLeft", signature = "(I)V")
	@Test
	public void testSetTimeLeft() throws Exception {
		MazeController testSubject;
		int timeLeft = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setTimeLeft(timeLeft);
	}

	@MethodRef(name = "getTimer", signature = "()J")
	@Test
	public void testGetTimer() throws Exception {
		MazeController testSubject;
		long result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getTimer();
	}

	@MethodRef(name = "setTimer", signature = "(J)V")
	@Test
	public void testSetTimer() throws Exception {
		MazeController testSubject;
		long timer = null;

		// default test
		testSubject = createTestSubject();
		testSubject.setTimer(timer);
	}

	@MethodRef(name = "getVel", signature = "()I")
	@Test
	public void testGetVel() throws Exception {
		MazeController testSubject;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getVel();
	}

	@MethodRef(name = "setVel", signature = "(I)V")
	@Test
	public void testSetVel() throws Exception {
		MazeController testSubject;
		int vel = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setVel(vel);
	}

	@MethodRef(name = "move", signature = "()V")
	@Test
	public void testMove() throws Exception {
		MazeController testSubject;

		// default test
		testSubject = createTestSubject();
		Deencapsulation.invoke(testSubject, "move");
	}

	@MethodRef(name = "tickOpacity", signature = "()V")
	@Test
	public void testTickOpacity() throws Exception {
		MazeController testSubject;

		// default test
		testSubject = createTestSubject();
		Deencapsulation.invoke(testSubject, "tickOpacity");
	}

	@MethodRef(name = "tickHealthOpacity", signature = "()V")
	@Test
	public void testTickHealthOpacity() throws Exception {
		MazeController testSubject;

		// default test
		testSubject = createTestSubject();
		Deencapsulation.invoke(testSubject, "tickHealthOpacity");
	}

	@MethodRef(name = "checkProgression", signature = "(QPlayer;)V")
	@Test
	public void testCheckProgression() throws Exception {
		MazeController testSubject;
		Player p = null;

		// default test
		testSubject = createTestSubject();
		Deencapsulation.invoke(testSubject, "checkProgression", new Object[] { Player.class });
	}

	@MethodRef(name = "progress", signature = "(QPlayer;)V")
	@Test
	public void testProgress() throws Exception {
		MazeController testSubject;
		Player p = null;

		// default test
		testSubject = createTestSubject();
		Deencapsulation.invoke(testSubject, "progress", new Object[] { Player.class });
	}

	@MethodRef(name = "checkBorders", signature = "(QPlayer;)V")
	@Test
	public void testCheckBorders() throws Exception {
		MazeController testSubject;
		Player p = null;

		// default test
		testSubject = createTestSubject();
		Deencapsulation.invoke(testSubject, "checkBorders", new Object[] { Player.class });
	}

	@MethodRef(name = "collisions", signature = "(QPlayer;QObstacle;)V")
	@Test
	public void testCollisions() throws Exception {
		MazeController testSubject;
		Player p = null;
		Obstacle o = null;

		// default test
		testSubject = createTestSubject();
		Deencapsulation.invoke(testSubject, "collisions", new Object[] { Player.class, Obstacle.class });
	}

	@MethodRef(name = "checkXCollisionRight", signature = "(QPlayer;QObstacle;)V")
	@Test
	public void testCheckXCollisionRight() throws Exception {
		MazeController testSubject;
		Player p = null;
		Obstacle o = null;

		// default test
		testSubject = createTestSubject();
		Deencapsulation.invoke(testSubject, "checkXCollisionRight", new Object[] { Player.class, Obstacle.class });
	}

	@MethodRef(name = "checkXCollisionLeft", signature = "(QPlayer;QObstacle;)V")
	@Test
	public void testCheckXCollisionLeft() throws Exception {
		MazeController testSubject;
		Player p = null;
		Obstacle o = null;

		// default test
		testSubject = createTestSubject();
		Deencapsulation.invoke(testSubject, "checkXCollisionLeft", new Object[] { Player.class, Obstacle.class });
	}

	@MethodRef(name = "checkYCollisionUp", signature = "(QPlayer;QObstacle;)V")
	@Test
	public void testCheckYCollisionUp() throws Exception {
		MazeController testSubject;
		Player p = null;
		Obstacle o = null;

		// default test
		testSubject = createTestSubject();
		Deencapsulation.invoke(testSubject, "checkYCollisionUp", new Object[] { Player.class, Obstacle.class });
	}

	@MethodRef(name = "checkYCollisionDown", signature = "(QPlayer;QObstacle;)V")
	@Test
	public void testCheckYCollisionDown() throws Exception {
		MazeController testSubject;
		Player p = null;
		Obstacle o = null;

		// default test
		testSubject = createTestSubject();
		Deencapsulation.invoke(testSubject, "checkYCollisionDown", new Object[] { Player.class, Obstacle.class });
	}

	@MethodRef(name = "patrol", signature = "(QEnemy;QPlayer;)V")
	@Test
	public void testPatrol() throws Exception {
		MazeController testSubject;
		Enemy e = null;
		Player p = null;

		// default test
		testSubject = createTestSubject();
		Deencapsulation.invoke(testSubject, "patrol", new Object[] { Enemy.class, Player.class });
	}

	@MethodRef(name = "patrolHorizontal", signature = "(QEnemy;)V")
	@Test
	public void testPatrolHorizontal() throws Exception {
		MazeController testSubject;
		Enemy e = null;

		// default test
		testSubject = createTestSubject();
		Deencapsulation.invoke(testSubject, "patrolHorizontal", new Object[] { Enemy.class });
	}

	@MethodRef(name = "patrolVeritcal", signature = "(QEnemy;)V")
	@Test
	public void testPatrolVeritcal() throws Exception {
		MazeController testSubject;
		Enemy e = null;

		// default test
		testSubject = createTestSubject();
		Deencapsulation.invoke(testSubject, "patrolVeritcal", new Object[] { Enemy.class });
	}

	@MethodRef(name = "checkHorizontalHit", signature = "(QEnemy;QPlayer;)V")
	@Test
	public void testCheckHorizontalHit() throws Exception {
		MazeController testSubject;
		Enemy e = null;
		Player p = null;

		// default test
		testSubject = createTestSubject();
		Deencapsulation.invoke(testSubject, "checkHorizontalHit", new Object[] { Enemy.class, Player.class });
	}

	@MethodRef(name = "checkVerticalHit", signature = "(QEnemy;QPlayer;)V")
	@Test
	public void testCheckVerticalHit() throws Exception {
		MazeController testSubject;
		Enemy e = null;
		Player p = null;

		// default test
		testSubject = createTestSubject();
		Deencapsulation.invoke(testSubject, "checkVerticalHit", new Object[] { Enemy.class, Player.class });
	}

	@MethodRef(name = "keyTyped", signature = "(QKeyEvent;)V")
	@Test
	public void testKeyTyped() throws Exception {
		MazeController testSubject;
		KeyEvent e = null;

		// default test
		testSubject = createTestSubject();
		testSubject.keyTyped(e);
	}

	@MethodRef(name = "keyPressed", signature = "(QKeyEvent;)V")
	@Test
	public void testKeyPressed() throws Exception {
		MazeController testSubject;
		KeyEvent e = null;

		// default test
		testSubject = createTestSubject();
		testSubject.keyPressed(e);
	}

	@MethodRef(name = "keyReleased", signature = "(QKeyEvent;)V")
	@Test
	public void testKeyReleased() throws Exception {
		MazeController testSubject;
		KeyEvent e = null;

		// default test
		testSubject = createTestSubject();
		testSubject.keyReleased(e);
	}

	@MethodRef(name = "fishCollide", signature = "(QEnemy;)Z")
	@Test
	public void testFishCollide() throws Exception {
		MazeController testSubject;
		Enemy e = null;
		boolean result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.fishCollide(e);
	}
}