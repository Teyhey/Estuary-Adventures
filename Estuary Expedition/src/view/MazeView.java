package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import controller.MazeController;
import model.Enemy;
import model.Obstacle;
import model.Player;

public class MazeView extends MazeController{
	/**
	 * This class handles the view components for the Maze Game.
	 * @param
	 * @author John Tejeda, Tyler Hill, Stephen Lu, Devarshi Patel
	 * @version BETA
	 */
	int buttonWidth = 75;
	int buttonHeight = 50;
	int saltOffsetX = 140;
	int saltOffsetY = 335;
	int healthOffsetX = 295;
	int healthOffsetY = 110;
	int healthBGOffset = 5;
	int clockOffsetX = 305;
	int clockOffsetY = 10;
	int rectWidth = 25;
	int rectHeight = 25;
	int healthWidth = 125;
	int healthHeight = 25;
	float progress = 0.0f;

	String playerIcon = "Game Files/bluecrab_back.png";
	String salinity = "Game Files/SalinityMeter.png";
	String timer = "Game Files/timer.png";
	String[] enemies = {"Game Files/fish_bass_right.png", "Game Files/fish_bass_left.png", "Game Files/fish_bass_up.png","Game Files/fish_bass_down.png"};;
	String rocks = "Game Files/rock.png";
	String powers = "Game Files/0.png";
	String exitIcon = "Game Files/Exit_Button.png";


	/**
	 * Class constructor
	 * Sets the fields.
	 * @param None
	 * @return void.
	 */
	public MazeView(){
		super(500, 120);
	}

	/**
	 * This method is responsible for drawing the graphics on Panel.
	 * @param g This is the only parameter in this method and is of Graphics type.
	 * @return void.
	 */
	public void draw(Graphics g){
		try {
			BufferedImage icon;
			BufferedImage salt;
			BufferedImage clock;
			BufferedImage[] enemy;
			BufferedImage obstack;
			BufferedImage exit;

			BufferedImage background = ImageIO.read(new File("Game Files/MazeIntro.png"));
			g.drawImage(background, 0, 0, null);


			exit = ImageIO.read(new File(exitIcon));
			icon = ImageIO.read(new File(playerIcon));
			salt = ImageIO.read(new File(salinity));
			clock = ImageIO.read(new File(timer));
			enemy = new BufferedImage[4];
			for (int i = 0; i < 4; i++){
				enemy[i] = ImageIO.read(new File(enemies[i]));
			}
			obstack = ImageIO.read(new File(rocks));

			this.maze.player.setWidth(icon.getWidth());
			this.maze.player.setHeight(icon.getHeight());

			double scale = (double) (maze.getCurrDistance()+1)/maze.getDistance();
			int width = this.maze.player.getWidth();
			int height = this.maze.player.getHeight();

			int scaledWidth =  (int) ((width/2)*scale) + (width/2);
			int scaledHeight = (int) ((height/2)*scale) + (height/2);

			BufferedImage scaledIcon = new BufferedImage(scaledWidth, scaledHeight, icon.getType());

			Graphics2D g2d = scaledIcon.createGraphics();
			g2d.drawImage(icon, 0, 0, scaledWidth, scaledHeight, null);
			g2d.dispose();

			this.maze.player.setWidth(scaledIcon.getWidth());
			this.maze.player.setHeight(scaledIcon.getHeight());
			
			// ==========Game Over Screens==================
			if (this.getTimeLeft() <= 0 || this.maze.player.health <= 0){
				g.setFont(new Font("ComicSans", Font.PLAIN, 100));
				g.drawString("REST IN PEACE", 100, 300);
				g.drawImage(exit, 0, 0, null);
			} else {
				// ========================================================================
				// ========================Player, enemies, objects========================
				// ========================================================================
				if (maze.getCurrDistance() < maze.getDistance()){
					for (Obstacle o: this.maze.obstacles){
						g.drawImage(obstack, o.xCoord, o.yCoord, null);
					}
					//g.drawImage(boost, maze.item.xCoord, maze.item.yCoord, null);
					
					g.drawImage(scaledIcon, this.maze.player.getxCoord() , this.maze.player.getyCoord(), null);
					Color goal = new Color (255,255, 0, opacity);
					g.setColor(goal);
					if (this.maze.getStart() == 1){
						g.fillRect(frameWidth - rectWidth, 0, rectWidth, frameHeight);
					}
					if (this.maze.getStart() == 2){
						g.fillRect(0, frameHeight - (rectHeight*2), frameWidth, rectHeight);
					}
					if (this.maze.getStart() == 3){
						g.fillRect(0, 0, rectWidth/2, frameHeight);
					}
					if (this.maze.getStart() == 4){
						g.fillRect(0, 0, frameWidth, rectHeight/2);
					}
					
					Color black = new Color (0, 0, 0);
					g.setColor(black);
					g.fillRect(frameWidth - healthOffsetX - healthBGOffset,
							frameHeight - healthOffsetY - healthBGOffset, healthWidth + 10,healthHeight + 10);
					Color health = new Color (255, 0, 0, healthOpacity);
					double healthScale = this.maze.player.health/maxHealth;
					int scaledHealth = (int) (healthScale*healthWidth);
					g.setColor(health);
					g.fillRect(frameWidth - healthOffsetX, frameHeight - healthOffsetY, scaledHealth,healthHeight);
					g.drawImage(salt, frameWidth - saltOffsetX , frameHeight - saltOffsetY, null);
					
					for (Enemy e: this.maze.enemy){
						if (e.getDirection() == 0 && e.getSpeed() > 0){
							g.drawImage(enemy[0], e.getxCoord(), e.getyCoord(), null);
							e.setWidth(enemy[0].getWidth());
							e.setHeight(enemy[0].getHeight());
						}
						if (e.getDirection() == 0 && e.getSpeed() < 0){
							g.drawImage(enemy[1], e.getxCoord(), e.getyCoord(), null);
							e.setWidth(enemy[1].getWidth());
							e.setHeight(enemy[1].getHeight());
						}
						if (e.getDirection() == 1 && e.getSpeed() < 0){
							g.drawImage(enemy[2], e.getxCoord(), e.getyCoord(), null);
							e.setWidth(enemy[2].getWidth());
							e.setHeight(enemy[2].getHeight());
						}
						if (e.getDirection() == 1 && e.getSpeed() > 0){
							g.drawImage(enemy[3], e.getxCoord(), e.getyCoord(), null);
							e.setWidth(enemy[3].getWidth());
							e.setHeight(enemy[3].getHeight());
						}

					}
					g.drawImage(clock, frameWidth - clockOffsetX, clockOffsetY, null);
					g.drawImage(exit, 0, 0, null);
				}
				else {
					// =====================Win Screen=========================
					g.setFont(new Font("ComicSans", Font.PLAIN, 100));
					g.drawString("YOU MADE IT TO THE", 100, 300);
					g.drawString("ESTUARY", 375, 500);
					g.drawImage(exit, 0, 0, null);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public AbstractButton getMazeButton() {
		// TODO Auto-generated method stub
		return null;
	}
}
