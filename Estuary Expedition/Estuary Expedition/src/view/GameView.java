package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.GameController;

public class GameView extends JPanel {

	/**
	 * This class handles the view components for everything.
	 * 
	 * @param
	 * @author John Tejeda, Tyler Hill, Stephen Lu, Devarshi Patel
	 * @version RELEASE
	 */
	int frameWidth;
	int frameHeight;

	String rollState = "playing";
	GameController controller;

	int timeOffsetX = 180;
	int timeOffsetY = 75;
	int time = 0;

	static long timeLeft = 120;

	/**
	 * Class Constructor Sets the fields.
	 * 
	 * @param none.
	 * @return void.
	 */
	public GameView() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameWidth = (int) screenSize.getWidth();
		frameHeight = (int) screenSize.getHeight();
		this.controller = new GameController();
	}

	/**
	 * This method is responsible for making the Panels.
	 * 
	 * @param none.
	 * @return void.
	 */

	/**
	 * This method is responsible for making the Main Menu Panel.
	 * 
	 * @param none.
	 * @return void.
	 */
	public void menuPanel() {
		controller.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
		controller.getFrame().setUndecorated(true);
		controller.getFrame().getContentPane().add(this).setBackground(Color.gray);
		controller.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controller.getFrame().setSize(this.frameWidth, this.frameHeight);
		controller.getFrame().setVisible(true);
	}
	
	/**
	 * This method is responsible for painting the component for the JPanel.
	 * 
	 * @param g
	 *            This is of Graphics type.
	 * @return void.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (controller.getGameState() == "Menu"){
			this.controller.getMenuView().draw(g);
		}
		if (controller.getGameState() == "Maze") {
			this.controller.getMazeView().draw(g);
			Color c = new Color(0, 0, 0);
			g.setColor(c);
			if (this.controller.getMazeView().maze.getTutorialStep() >= 4){
				if (this.controller.getMazeView().maze.getCurrDistance() != this.controller.getMazeView().maze.getDistance() 
						&& this.controller.getMazeView().maze.player.health >=0
						&& this.controller.getMazeView().getTimeLeft() >= 0) {
					if (this.controller.getMazeView().getTimeLeft() % 60 < 10) {
						String countDown = this.controller.getMazeView().getTimeLeft() / 60 + ":" + "0" + 
								this.controller.getMazeView().getTimeLeft() % 60;
						g.setFont(new Font("ComicSans", Font.PLAIN, 40));
						g.drawString(countDown, frameWidth - timeOffsetX, timeOffsetY);
					} else {
						String countDown = this.controller.getMazeView().getTimeLeft() / 60 + ":" + 
								this.controller.getMazeView().getTimeLeft() % 60;
						g.setFont(new Font("ComicSans", Font.PLAIN, 40));
						g.drawString(countDown, frameWidth - timeOffsetX, timeOffsetY);
					}
				}
			}
		}

		if (controller.getGameState() == "Beach") {
			this.controller.getBeachView().draw(g);
			if (this.controller.getBeachView().getTimeLeft() % 60 < 10) {
				String countDown = this.controller.getBeachView().getTimeLeft() / 60 + ":" + "0" + 
						this.controller.getBeachView().getTimeLeft() % 60;
				g.setFont(new Font("ComicSans", Font.PLAIN, 40));
				g.drawString(countDown, frameWidth - timeOffsetX, timeOffsetY);
			} else {
				String countDown = this.controller.getBeachView().getTimeLeft() / 60 + ":" + 
						this.controller.getBeachView().getTimeLeft() % 60;
				g.setFont(new Font("ComicSans", Font.PLAIN, 40));
				g.drawString(countDown, frameWidth - timeOffsetX, timeOffsetY);
			}
		}

		if (controller.getGameState() == "Cube") {
			this.controller.getCubeView().draw(g);
		}
	}

	private void run(){
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;

		while (true) {
			long now = System.nanoTime();
			this.repaint();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				this.tick();
				delta--;
			}
		}
	}

	public void tick() {
		if (controller.getGameState() == "Maze") {
			this.controller.getMazeView().tick();
		}

		if (controller.getGameState() == "Beach") {
			this.controller.getBeachView().tick();
		}

		if (controller.getGameState() == "Cube") {
			//this.controller.getCubeView().tick();
		}
	}

	public static void main(String args[]) {
		GameView game = new GameView();
		game.menuPanel();
		game.run();

	}
}
