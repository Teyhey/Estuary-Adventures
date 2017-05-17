package testing;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.Random;

import org.junit.Test;

import model.Enemy;
import model.Item;
import model.MazeModel;
import model.Obstacle;
import model.Player;

public class MazeModelTesting{

	// All first tests pass and the seconds fail.
	

	// -------------CURR-DISTANCE TEST--------------------
	@Test
	public void testGetCurrDistance1() {
		MazeModel maze_model = new MazeModel(100);
		assertEquals(0, maze_model.getCurrDistance());
	}

	@Test
	public void testGetCurrDistance2() {
		MazeModel maze_model = new MazeModel(false, 0);
		assertEquals(1, maze_model.getCurrDistance());
	}

	@Test
	public void testSetCurrDistance1() {
		MazeModel maze_model = new MazeModel(100);
		maze_model.setCurrDistance(2);
		assertEquals(2, maze_model.getCurrDistance());
	}

	@Test
	public void testSetCurrDistance2() {
		MazeModel maze_model = new MazeModel(false, 0);
		maze_model.setCurrDistance(2);
		assertEquals(1, maze_model.getCurrDistance());
	}

	// -------------DISTANCE TEST--------------------
	@Test
	public void testGetDistance1() {
		MazeModel maze_model = new MazeModel(100);
		assertEquals(15, maze_model.getDistance());
	}

	@Test
	public void testGetDistance2() {
		MazeModel maze_model = new MazeModel(false, 0);
		assertEquals(1, maze_model.getDistance());
	}

	@Test
	public void testSetDistance1() {
		MazeModel maze_model = new MazeModel(100);
		maze_model.setDistance(2);
		assertEquals(2, maze_model.getDistance());
	}

	@Test
	public void testSetDistance2() {
		MazeModel maze_model = new MazeModel(false, 0);
		maze_model.setDistance(2);
		assertEquals(1, maze_model.getDistance());
	}

	// -------------START TEST--------------------
	@Test
	public void testGetStart1() {
		MazeModel maze_model = new MazeModel(false, 4);
		assertEquals(1, maze_model.getStart());
	}

	@Test
	public void testGetStart2() {
		MazeModel maze_model = new MazeModel(100);
		assertEquals(14, maze_model.getStart());
	}

	@Test
	public void testSetStart1() {
		MazeModel maze_model = new MazeModel(100);
		maze_model.setStart(2);
		assertEquals(2, maze_model.getStart());
	}

	@Test
	public void testSetStart2() {
		MazeModel maze_model = new MazeModel(false, 0);
		maze_model.setStart(3);
		assertEquals(1, maze_model.getStart());
	}

	// -------------OPACITY TEST--------------------
	@Test
	public void testGetOpacity1() {
		MazeModel maze_model = new MazeModel(false, 4);
		assertEquals(250, maze_model.getOpacity());
	}

	@Test
	public void testGetOpacity2() {
		MazeModel maze_model = new MazeModel(100);
		assertEquals(14, maze_model.getOpacity());
	}

	@Test
	public void testSetOpacity1() {
		MazeModel maze_model = new MazeModel(100);
		maze_model.setOpacity(2);
		assertEquals(2, maze_model.getOpacity());
	}

	@Test
	public void testSetOpacity2() {
		MazeModel maze_model = new MazeModel(false, 0);
		maze_model.setOpacity(3);
		assertEquals(1, maze_model.getOpacity());
	}

	// -------------OPACITY-TICK TEST--------------------
	@Test
	public void testGetOpacityTick1() {
		MazeModel maze_model = new MazeModel(false, 4);
		assertEquals(-3, maze_model.getOpacityTick());
	}

	@Test
	public void testGetOpacityTick2() {
		MazeModel maze_model = new MazeModel(100);
		assertEquals(3, maze_model.getOpacityTick());
	}

	@Test
	public void testSetOpacityTick1() {
		MazeModel maze_model = new MazeModel(100);
		maze_model.setOpacityTick(4);
		assertEquals(4, maze_model.getOpacityTick());
	}

	@Test
	public void testSetOpacityTick2() {
		MazeModel maze_model = new MazeModel(false, 0);
		maze_model.setOpacityTick(3);
		assertEquals(1, maze_model.getOpacityTick());
	}

	// -------------SALINITY-METER-COLOR TEST--------------------
	@Test
	public void testGetSalinityMeterColor1() {
		MazeModel maze_model = new MazeModel(false, 4);
		Color test_color = new Color(255, 0, 0);
		assertEquals(test_color, maze_model.getSalinityMeterColor());
	}

	@Test
	public void testGetSalinityMeterColor2() {
		MazeModel maze_model = new MazeModel(100);
		assertEquals(new Color(200, 0, 0), maze_model.getSalinityMeterColor());
	}

	@Test
	public void testSetSalinityMeterColor1() {
		MazeModel maze_model = new MazeModel(100);
		Color test_color = new Color(3);
		maze_model.setSalinityMeterColor(test_color);
		assertEquals(test_color, maze_model.getSalinityMeterColor());
	}

	@Test
	public void testSetSalinityMeterColor2() {
		MazeModel maze_model = new MazeModel(false, 0);
		Color test_color = new Color(3);
		maze_model.setSalinityMeterColor(test_color);
		assertEquals(new Color(2), maze_model.getSalinityMeterColor());
	}

	// -------------TUTORIAL TEST--------------------
	@Test
	public void testGetTutorial1() {
		MazeModel maze_model = new MazeModel(100);
		assertEquals(false, maze_model.isTutorial());
	}

	@Test
	public void testGetTutorial2() {
		MazeModel maze_model = new MazeModel(false, 4);
		assertEquals(true, maze_model.isTutorial());
	}

	@Test
	public void testSetTutorial1() {
		MazeModel maze_model = new MazeModel(100);
		maze_model.setTutorial(true);
		assertEquals(true, maze_model.isTutorial());
	}

	@Test
	public void testSetTutorial2() {
		MazeModel maze_model = new MazeModel(false, 0);
		maze_model.setTutorial(true);
		assertEquals(false, maze_model.isTutorial());
	}

	// -------------TUTORIAL-STEP TEST--------------------
	@Test
	public void testGetTutorialStep1() {
		MazeModel maze_model = new MazeModel(100);
		assertEquals(10, maze_model.getTutorialStep());
	}

	@Test
	public void testGetTutorialStep2() {
		MazeModel maze_model = new MazeModel(false, 4);
		assertEquals(1, maze_model.getTutorialStep());
	}

	@Test
	public void testSetTutorialStep1() {
		MazeModel maze_model = new MazeModel(100);
		maze_model.setTutorialStep(2);
		assertEquals(2, maze_model.getTutorialStep());
	}

	@Test
	public void testSetTutorialStep2() {
		MazeModel maze_model = new MazeModel(false, 0);
		maze_model.setTutorialStep(4);
		assertEquals(2, maze_model.getTutorialStep());
	}

	// -------------FRAME-WIDTH TEST--------------------
	@Test
	public void testGetFrameWidth1() {
		MazeModel maze_model = new MazeModel(100);
		assertEquals(1280, maze_model.getFrameWidth());
	}

	@Test
	public void testGetFrameWidth2() {
		MazeModel maze_model = new MazeModel(false, 4);
		assertEquals(1281, maze_model.getFrameWidth());
	}

	@Test
	public void testSetFrameWidth1() {
		MazeModel maze_model = new MazeModel(100);
		maze_model.setFrameWidth(300);
		assertEquals(300, maze_model.getFrameWidth());
	}

	@Test
	public void testSetFrameWidth2() {
		MazeModel maze_model = new MazeModel(false, 0);
		maze_model.setFrameWidth(300);
		assertEquals(350, maze_model.getFrameWidth());
	}

	// -------------FRAME-HEIGHT TEST--------------------
	@Test
	public void testGetFrameHeight1() {
		MazeModel maze_model = new MazeModel(100);
		assertEquals(800, maze_model.getFrameHeight());
	}

	@Test
	public void testGetFrameHeight2() {
		MazeModel maze_model = new MazeModel(false, 4);
		assertEquals(1281, maze_model.getFrameHeight());
	}

	@Test
	public void testSetFrameHeight1() {
		MazeModel maze_model = new MazeModel(100);
		maze_model.setFrameHeight(300);
		assertEquals(300, maze_model.getFrameHeight());
	}

	@Test
	public void testSetFrameHeight2() {
		MazeModel maze_model = new MazeModel(false, 0);
		maze_model.setFrameHeight(300);
		assertEquals(350, maze_model.getFrameHeight());
	}

	// -------------OBSTACLE-NUM TEST--------------------
	@Test
	public void testGetObstacleNum1() {
		MazeModel maze_model = new MazeModel(100);
		assertEquals(5, maze_model.getObstacleNum());
	}

	@Test
	public void testGetObstacleNum2() {
		MazeModel maze_model = new MazeModel(false, 4);
		assertEquals(6, maze_model.getObstacleNum());
	}

	@Test
	public void testSetObstacleNum1() {
		MazeModel maze_model = new MazeModel(100);
		maze_model.setObstacleNum(10);
		assertEquals(10, maze_model.getObstacleNum());
	}

	@Test
	public void testSetObstacleNum2() {
		MazeModel maze_model = new MazeModel(false, 0);
		maze_model.setObstacleNum(10);
		assertEquals(11, maze_model.getObstacleNum());
	}
	
	// -------------HEALTH-OPACITY TEST--------------------
	@Test
	public void testGetHealthOpacity1() {
		MazeModel maze_model = new MazeModel(100);
		assertEquals(250, maze_model.getHealthOpacity());
	}

	@Test
	public void testGetHealthOpacity2() {
		MazeModel maze_model = new MazeModel(false, 4);
		assertEquals(251, maze_model.getHealthOpacity());
	}

	@Test
	public void testSetHealthOpacity1() {
		MazeModel maze_model = new MazeModel(100);
		maze_model.setHealthOpacity(10);
		assertEquals(10, maze_model.getHealthOpacity());
	}

	@Test
	public void testSetHealthOpacity2() {
		MazeModel maze_model = new MazeModel(false, 0);
		maze_model.setHealthOpacity(10);
		assertEquals(11, maze_model.getHealthOpacity());
	}
	
	// -------------FISH-SP TEST--------------------
	@Test
	public void testGetFishSP1() {
		MazeModel maze_model = new MazeModel(100);
		assertEquals(5, maze_model.getFishSp());
	}

	@Test
	public void testGetFishSP2() {
		MazeModel maze_model = new MazeModel(false, 4);
		assertEquals(3, maze_model.getFishSp());
	}

	@Test
	public void testSetFishSP1() {
		MazeModel maze_model = new MazeModel(100);
		maze_model.setFishSp(10);
		assertEquals(10, maze_model.getFishSp());
	}

	@Test
	public void testSetFishSP2() {
		MazeModel maze_model = new MazeModel(false, 0);
		maze_model.setFishSp(10);
		assertEquals(11, maze_model.getFishSp());
	}
	
	// -------------PADDING TEST--------------------
	@Test
	public void testGetPadding1() {
		MazeModel maze_model = new MazeModel(100);
		assertEquals(65, maze_model.getPadding());
	}

	@Test
	public void testGetPadding2() {
		MazeModel maze_model = new MazeModel(false, 4);
		assertEquals(66, maze_model.getPadding());
	}

	@Test
	public void testSetPadding1() {
		MazeModel maze_model = new MazeModel(100);
		maze_model.setPadding(10);
		assertEquals(10, maze_model.getPadding());
	}

	@Test
	public void testSetPadding2() {
		MazeModel maze_model = new MazeModel(false, 0);
		maze_model.setPadding(10);
		assertEquals(11, maze_model.getPadding());
	}
	
	// -------------PLAYER TEST--------------------
	@Test
	public void testGetPlayer1() {
		MazeModel maze_model = new MazeModel(100);
		Player player_test = new Player(0, 0, 500);
		assertEquals(player_test, maze_model.getPlayer());
	}

	@Test
	public void testGetPlayer2() {
		MazeModel maze_model = new MazeModel(false, 4);
		assertEquals(new Player(1, 1, 500), maze_model.getPlayer());
	}

	@Test
	public void testSetPlayer1() {
		MazeModel maze_model = new MazeModel(100);
		Player player_test = new Player(0, 0, 500);
		maze_model.setPlayer(player_test);
		assertEquals(player_test, maze_model.getPlayer());
	}

	@Test
	public void testSetPlayer2() {
		MazeModel maze_model = new MazeModel(false, 0);
		Player player_test = new Player(0, 0, 500);
		maze_model.setPlayer(player_test);
		assertEquals(new Player(0, 0, 50), maze_model.getPlayer());
	}
	
	// -------------ITEM TEST--------------------
	@Test
	public void testGetItem1() {
		MazeModel maze_model = new MazeModel(100);
		Item item_test = new Item("Boost", 1);
		assertEquals(item_test, maze_model.getItem());
	}

	@Test
	public void testGetItem2() {
		MazeModel maze_model = new MazeModel(false, 4);
		assertEquals(new Item("Boost", 3), maze_model.getItem());
	}

	@Test
	public void testSetItem1() {
		MazeModel maze_model = new MazeModel(100);
		Item item_test = new Item("Boost", 1);
		maze_model.setItem(item_test);
		assertEquals(item_test, maze_model.getItem());
	}

	@Test
	public void testSetItem2() {
		MazeModel maze_model = new MazeModel(false, 0);
		Item item_test = new Item("Boost", 1);
		maze_model.setItem(item_test);
		assertEquals(new Item("Boost", 2), maze_model.getItem());
	}
	
	// -------------ENEMY TEST--------------------
	@Test
	public void testGetEnemy1() {
		MazeModel maze_model = new MazeModel(100);
		Enemy enemy_test1 = new Enemy(0, "Fish", 1, 0, 0, 0);
		Enemy enemy_test2 = new Enemy(0, "Fish", 2, 0, 0, 0);
		Enemy[] enemy_testArr = {enemy_test1, enemy_test2};
		assertEquals(enemy_testArr[0], maze_model.getEnemy()[0]);
	}

	@Test
	public void testGetEnemy2() {
		MazeModel maze_model = new MazeModel(false, 4);
		Enemy enemy_test1 = new Enemy(0, "Fish", 1, 0, 0, 0);
		Enemy enemy_test2 = new Enemy(0, "Fish", 2, 0, 0, 0);
		Enemy[] enemy_testArr = {enemy_test1, enemy_test2};
		assertEquals(enemy_testArr[1], maze_model.getEnemy()[0]);
	}

	@Test
	public void testSetEnemy1() {
		MazeModel maze_model = new MazeModel(100);
		Enemy enemy_test1 = new Enemy(0, "Fish", 1, 0, 0, 0);
		Enemy enemy_test2 = new Enemy(0, "Fish", 2, 0, 0, 0);
		Enemy[] enemy_testArr = {enemy_test1, enemy_test2};
		maze_model.setEnemy(enemy_testArr);
		assertEquals(enemy_testArr[0], maze_model.getEnemy()[0]);
	}

	@Test
	public void testSetEnemy2() {
		MazeModel maze_model = new MazeModel(false, 0);
		Enemy enemy_test1 = new Enemy(0, "Fish", 1, 0, 0, 0);
		Enemy enemy_test2 = new Enemy(0, "Fish", 2, 0, 0, 0);
		Enemy[] enemy_testArr1 = {enemy_test1, enemy_test2};
		Enemy[] enemy_testArr2 = {enemy_test2, enemy_test2};
		maze_model.setEnemy(enemy_testArr1);
		assertEquals(enemy_testArr2[0], maze_model.getEnemy()[0]);
	}
	
	// -------------OBSTACLES TEST--------------------
	@Test
	public void testGetObstacles1() {
		MazeModel maze_model = new MazeModel(100);
		Obstacle obstacle_test1 = new Obstacle(0, 1);
		Obstacle obstacle_test2 = new Obstacle(0, 2);
		Obstacle[] obstacle_testArr = {obstacle_test1, obstacle_test2};
		assertEquals(obstacle_testArr[0], maze_model.getObstacles()[0]);
	}

	@Test
	public void testGetObstacles2() {
		MazeModel maze_model = new MazeModel(false, 4);
		Obstacle obstacle_test1 = new Obstacle(0, 1);
		Obstacle obstacle_test2 = new Obstacle(0, 2);
		Obstacle[] obstacle_testArr = {obstacle_test1, obstacle_test2};
		assertEquals(obstacle_testArr[1], maze_model.getObstacles()[0]);
	}

	@Test
	public void testSetObstacles1() {
		MazeModel maze_model = new MazeModel(100);
		Obstacle obstacle_test1 = new Obstacle(0, 1);
		Obstacle obstacle_test2 = new Obstacle(0, 2);
		Obstacle[] obstacle_testArr = {obstacle_test1, obstacle_test2};
		maze_model.setObstacles(obstacle_testArr);
		assertEquals(obstacle_testArr[0], maze_model.getObstacles()[0]);
	}

	@Test
	public void testSetObstacles2() {
		MazeModel maze_model = new MazeModel(false, 0);
		Obstacle obstacle_test1 = new Obstacle(0, 1);
		Obstacle obstacle_test2 = new Obstacle(0, 2);
		Obstacle[] obstacle_testArr1 = {obstacle_test1, obstacle_test2};
		Obstacle[] obstacle_testArr2 = {obstacle_test2, obstacle_test2};
		maze_model.setObstacles(obstacle_testArr1);
		assertEquals(obstacle_testArr2[0], maze_model.getObstacles()[0]);
	}
	
	// -------------PLACE-PLAYER TEST--------------------
	@Test
	public void testPlacePlayer1() {
		MazeModel maze_model = new MazeModel(100);
		maze_model.placePlayer(1, 10);
		assertEquals(new Player(1, maze_model.getFrameHeight()/2, 10), maze_model.getPlayer());
	}

	@Test
	public void testPlacePlayer2() {
		MazeModel maze_model = new MazeModel(false, 4);
		maze_model.placePlayer(2, 10);
		assertEquals(new Player(2, maze_model.getFrameHeight()/2, 10), maze_model.getPlayer());
	}

	@Test
	public void testPlacePlayer3() {
		MazeModel maze_model = new MazeModel(false, 4);
		maze_model.placePlayer(3, 10);
		assertEquals(new Player(3, maze_model.getFrameHeight()/2, 10), maze_model.getPlayer());
	}
	
	@Test
	public void testPlacePlayer4() {
		MazeModel maze_model = new MazeModel(false, 4);
		maze_model.placePlayer(4, 10);
		assertEquals(new Player(4, maze_model.getFrameHeight()/2, 10), maze_model.getPlayer());
	}
	
	@Test
	public void testPlacePlayer5() {
		MazeModel maze_model = new MazeModel(false, 4);
		maze_model.placePlayer(5, 10);
		assertEquals(new Player(5, maze_model.getFrameHeight()/2, 10), maze_model.getPlayer());
	}
	
	// -------------CREATE-ENEMIES TEST--------------------
	@Test
	public void testCreateEnemies1() {
		MazeModel maze_model = new MazeModel(100);
		Random rand = new Random();
		int x = 0;
		maze_model.enemy = new Enemy[2];
		int speeds[] = {-maze_model.getFishSp(), maze_model.getFishSp()};
		int s = rand.nextInt(1);
		int n = rand.nextInt(maze_model.getFrameHeight());
		maze_model.enemy[0] = new Enemy(x, "Fish", 5, speeds[s], n, 
				(maze_model.getFrameHeight()/3)  - maze_model.getPadding());
		maze_model.enemy[1] = new Enemy(x, "Fish", 5, speeds[s], n, 
				(maze_model.getFrameHeight()/3)  - maze_model.getPadding());
		
		assertEquals(maze_model.enemy[0], maze_model.getEnemy()[0]);
	}
	
	@Test
	public void testCreateEnemies2() {
		MazeModel maze_model = new MazeModel(100);
		Random rand = new Random();
		int x = 0;
		maze_model.enemy = new Enemy[2];
		int speeds[] = {-maze_model.getFishSp(), maze_model.getFishSp()};
		int s = rand.nextInt(1);
		int n = rand.nextInt(maze_model.getFrameHeight());
		maze_model.enemy[0] = new Enemy(x, "Fish", 5, speeds[s], n, 
				(maze_model.getFrameHeight()/3)  - maze_model.getPadding());
		maze_model.enemy[1] = new Enemy(x, "Fish", 5, speeds[s], n, 
				(maze_model.getFrameHeight()/3)  - maze_model.getPadding());
		
		assertEquals(maze_model.enemy[1], maze_model.getEnemy()[0]);
	}
	
	// -------------CREATE-OBSTACLES TEST--------------------
	@Test
	public void testCreateObstacles1() {
		MazeModel maze_model = new MazeModel(100);
		Random rand = new Random();
		maze_model.obstacles = new Obstacle[maze_model.getObstacleNum()];
		for (int i = 0; i < maze_model.getObstacleNum(); i++){
			int x = rand.nextInt((maze_model.getFrameWidth()/5) * 3) + (maze_model.getFrameWidth()/5);
			int y = rand.nextInt((maze_model.getFrameHeight()/5) * 3) + (maze_model.getFrameHeight()/5);
			maze_model.obstacles[i] = new Obstacle(x, y);
		}
		assertEquals(maze_model.obstacles[0], maze_model.getObstacles()[0]);
	}
	
	@Test
	public void testCreateObstacles2() {
		MazeModel maze_model = new MazeModel(100);
		Random rand = new Random();
		maze_model.obstacles = new Obstacle[maze_model.getObstacleNum()];
		for (int i = 0; i < maze_model.getObstacleNum(); i++){
			int x = rand.nextInt((maze_model.getFrameWidth()/5) * 3) + (maze_model.getFrameWidth()/5);
			int y = rand.nextInt((maze_model.getFrameHeight()/5) * 3) + (maze_model.getFrameHeight()/5);
			maze_model.obstacles[i] = new Obstacle(x, y);
		}
		assertEquals(maze_model.obstacles[1], maze_model.getObstacles()[0]);
	}
	
	// -------------CREATE-TUTORIAL-ENEMY TEST--------------------
	@Test
	public void testCreateTutorialEnemy1() {
		MazeModel maze_model = new MazeModel(100);
		Random rand = new Random();
		int x = 0;
		maze_model.enemy = new Enemy[4];
		int speeds[] = {-maze_model.getFishSp(), maze_model.getFishSp()};
		int s = rand.nextInt(1);
		int n = rand.nextInt(maze_model.getFrameHeight());
		for (int i = 0; i < maze_model.enemy.length; i++){
			maze_model.enemy[i] = new Enemy(x, "Fish", 5, speeds[s], 
					(maze_model.getFrameWidth()/5) * (i+1) - maze_model.getPadding(), n);
		}
		assertEquals(maze_model.enemy[0], maze_model.getEnemy()[0]);
	}
	
	@Test
	public void testCreateTutorialEnemy2() {
		MazeModel maze_model = new MazeModel(100);
		Random rand = new Random();
		int x = 0;
		maze_model.enemy = new Enemy[4];
		int speeds[] = {-maze_model.getFishSp(), maze_model.getFishSp()};
		int s = rand.nextInt(1);
		int n = rand.nextInt(maze_model.getFrameHeight());
		for (int i = 0; i < maze_model.enemy.length; i++){
			maze_model.enemy[i] = new Enemy(x, "Fish", 5, speeds[s], 
					(maze_model.getFrameWidth()/5) * (i+1) - maze_model.getPadding(), n);
		}
		assertEquals(maze_model.enemy[1], maze_model.getEnemy()[0]);
	}
	
	
	// -------------CREATE-TUTORIAL-OBSTACLES TEST--------------------
	@Test
	public void testCreateTutorialObstacles1() {
		MazeModel maze_model = new MazeModel(100);
		Random rand = new Random();
		maze_model.obstacles = new Obstacle[10];
		int s = rand.nextInt(1);
		int n = rand.nextInt(maze_model.getFrameHeight());
		for (int i = 0; i < maze_model.obstacles.length; i++){
			int x = rand.nextInt((maze_model.getFrameWidth()/5) * 3) + (maze_model.getFrameWidth()/5);
			int y = rand.nextInt((maze_model.getFrameHeight()/5) * 3) + (maze_model.getFrameHeight()/5);
			maze_model.obstacles[i] = new Obstacle(x, y);
		}
		assertEquals(maze_model.obstacles[0], maze_model.getObstacles()[0]);
	}
	
	
	
}
