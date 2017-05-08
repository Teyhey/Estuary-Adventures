package view;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuView extends JPanel {
	int buttonWidth = 200;
	int buttonHeight = 200;
	int frameWidth = 1280;
	int frameHeight = 800;

	JButton mazeButton;
	JButton beachButton;
	JButton cubeButton;
	ImageIcon maze;
	ImageIcon beach;
	ImageIcon cube;

	public MenuView() {
		try {

			maze = new ImageIcon(ImageIO.read(new File("Game Files/MazeButton.png")));
			beach = new ImageIcon(ImageIO.read(new File("Game Files/Beach Barriers Button.jpg")));
			cube = new ImageIcon(ImageIO.read(new File("Game Files/Die Game Button.jpg")));

			mazeButton = new JButton(maze);
			beachButton = new JButton(beach);
			cubeButton = new JButton(cube);

			JButton[] buttons = { mazeButton, beachButton, cubeButton };
			for (int i = 0; i < 3; i++) {
				buttons[i].setSize(buttonWidth, buttonHeight);
			}
			mazeButton.setLocation((frameWidth / 2 - buttonWidth / 2) - buttonWidth * 2,
					(frameHeight / 2 - buttonHeight / 2));
			beachButton.setLocation((frameWidth / 2 - buttonWidth / 2), (frameHeight / 2 - buttonHeight / 2));
			cubeButton.setLocation((frameWidth / 2 - buttonWidth / 2) + buttonWidth * 2,
					(frameHeight / 2 - buttonHeight / 2));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getButtonWidth() {
		return buttonWidth;
	}

	public void setButtonWidth(int buttonWidth) {
		this.buttonWidth = buttonWidth;
	}

	public int getButtonHeight() {
		return buttonHeight;
	}

	public void setButtonHeight(int buttonHeight) {
		this.buttonHeight = buttonHeight;
	}

	public JButton getMazeButton() {
		return mazeButton;
	}

	public void setMazeButton(JButton mazeButton) {
		this.mazeButton = mazeButton;
	}

	public JButton getBeachButton() {
		return beachButton;
	}

	public void setBeachButton(JButton beachButton) {
		this.beachButton = beachButton;
	}

	public JButton getCubeButton() {
		return cubeButton;
	}

	public void setCubeButton(JButton cubeButton) {
		this.cubeButton = cubeButton;
	}
}
