package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.MenuModel;

public class MenuView extends MenuModel {
	
	int bgWidth;
	int bgHeight;
	
	BufferedImage maze;
	BufferedImage beach;
	BufferedImage cube;
	BufferedImage background;

	public MenuView() {
		super();
		try {
			background = ImageIO.read(new File("Game Files/menu.png"));
			this.bgWidth = background.getWidth();
			this.bgHeight = background.getHeight();
			maze = ImageIO.read(new File("Game Files/MazeButton.png"));
			beach = ImageIO.read(new File("Game Files/Beach Barriers Button.jpg"));
			cube = ImageIO.read(new File("Game Files/Die Game Button.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics g){
		double scaleX = (double) frameWidth/bgWidth;
		double scaleY = (double) frameHeight/bgHeight;

		int scaledWidth =  (int) (bgWidth*scaleX);
		int scaledHeight = (int) (bgHeight*scaleY);
		BufferedImage scaledBG = new BufferedImage(scaledWidth, scaledHeight, background.getType());
		
		Graphics2D g2d = scaledBG.createGraphics();
		g2d.drawImage(background, 0, 0, scaledWidth, scaledHeight, null);
		g2d.dispose();
		g.drawImage(scaledBG, 0, 0, null);
		g.drawImage(maze, mazeButtonX, mazeButtonY, null);
		g.drawImage(beach, beachButtonX, beachButtonY, null);
		g.drawImage(cube, cubeButtonX, cubeButtonY, null);
	}
}
