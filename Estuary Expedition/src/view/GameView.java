package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.MazeController;
import controller.MenuController;
import view.MenuView;
import view.MazeView;
import view.BeachView;
import view.CubeView;

public class GameView extends JPanel{
	/**
	 * This class handles the view components for everything.
	 * @param
	 * @author John Tejeda, Tyler Hill, Stephen Lu, Devarshi Patel
	 * @version ALPHA
	 */
	int frameWidth = 1280; 
	int frameHeight = 800;
	String gameState;
	Object currGame;

	/**
	 * Class Constructor
	 * Sets the fields.
	 * @param none.
	 * @return void.
	 */
	public GameView() {
		gameState = "Menu";
		currGame = new MenuView();
		
	}

	/**
	 * This method is responsible for making the Panels.
	 * @param none.
	 * @return void.
	 */
	public void makePanel() {
		if (this.gameState.equals("Menu")) {
			this.menuPanel();
		} else if (this.gameState.equals("Maze")) {
			this.mazePanel();
		} else if (this.gameState.equals("Beach")) {
			this.beachPanel();
		} else {
			this.cubePanel();
		}
	}

	/**
	 * This method is responsible for making the Main Menu Panel.
	 * @param none.
	 * @return void.
	 */
	public void menuPanel() {
		try {
			JFrame frame = new JFrame();
			JLabel background = new JLabel(new ImageIcon(ImageIO.read(new File("Game Files/menu.jpg"))));
			

			((MenuView) this.currGame).getMazeButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setGameState("Maze");
					setCurrGame(new MazeView());
					frame.getContentPane().removeAll();
					mazePanel();
				}
			});

			((MenuView) this.currGame).getBeachButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setGameState("Beach");
					setCurrGame(new BeachView());
					frame.getContentPane().removeAll();
					beachPanel();
				}
			});

			((MenuView) this.currGame).getCubeButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setGameState("Cube");
					setCurrGame(new CubeView());
					frame.getContentPane().removeAll();
					cubePanel();

				}
			});

			frame.setContentPane(background);
			frame.add(((MenuView) this.currGame).getMazeButton());
			frame.add(((MenuView) this.currGame).getBeachButton());
			frame.add(((MenuView) this.currGame).getCubeButton());

			frame.getContentPane().add(this).setBackground(Color.gray);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(this.frameWidth, this.frameHeight);
			frame.setVisible(true);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	/**
	 * This method is responsible for making the Maze Panel.
	 * @param none.
	 * @return void.
	 */
	public void mazePanel() {
		JFrame frame = new JFrame();
		
		((MazeView) this.currGame).getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setGameState("Menu");
				setCurrGame(new MenuView());
				frame.getContentPane().removeAll();
				menuPanel();
			}
		});
		
		//frame.add(((MazeView) this.currGame).getBackButton());
		//frame.add(((MazeView) this.currGame).holder);
		frame.getContentPane().add(this).setBackground(Color.gray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(this.frameWidth, this.frameHeight);
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.addKeyListener(((MazeView) this.currGame));
		frame.repaint();
		
	}
	
	/**
	 * This method is responsible for making the Beach Panel.
	 * @param none.
	 * @return void.
	 */
	public void beachPanel() {
		JFrame frame = new JFrame();
			
		((BeachView) this.currGame).getBackButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setGameState("Menu");
					setCurrGame(new MenuView());
					frame.getContentPane().removeAll();
					menuPanel();
				}
			});
			
			//frame.add(((BeachView) this.currGame).getBackButton());
			//frame.add(((BeachView) this.currGame).holder);
			frame.getContentPane().add(this).setBackground(Color.gray);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(this.frameWidth, this.frameHeight);
			frame.setVisible(true);
			frame.setFocusable(true);
			frame.addKeyListener(((BeachView) this.currGame));
			frame.repaint();

	}
	
	/**
	 * This method is responsible for making the Story Cube Panel.
	 * @param none.
	 * @return void.
	 */
	public void cubePanel() {
			JFrame frame = new JFrame();
			((CubeView) this.currGame).getBackButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setGameState("Menu");
					setCurrGame(new MenuView());
					frame.getContentPane().removeAll();
					menuPanel();
					frame.repaint();
				}
			});

			((CubeView) this.currGame).getRoll().addActionListener(new ActionListener() {
				private CubeView currGame;

				public void actionPerformed(ActionEvent e) {
					((CubeView) this.currGame).randomize();
					currGame = ((CubeView) this.currGame);
					frame.repaint();
				}
			});
			
			frame.add(((CubeView) this.currGame).getBackButton());
			frame.add(((CubeView) this.currGame).getRoll());
			frame.add(((CubeView) this.currGame).holder);

			frame.getContentPane().add(this).setBackground(Color.gray);

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(this.frameWidth, this.frameHeight);
			frame.setVisible(true);
			frame.repaint();
			frame.setFocusable(true);
			frame.addKeyListener(((CubeView) this.currGame));
			frame.repaint();
	}
                
	
	/**
	 * This method is responsible for painting the component for the JPanel.
	 * @param g This is of Graphics type.
	 * @return void.
	 */
	@Override                                                             
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if (gameState == "Maze"){
			((MazeView) currGame).draw(g);
		}
		
		if(gameState == "Beach"){
			((BeachView) currGame).draw(g);
		}
		
		if(gameState == "Cube"){
			((CubeView) currGame).draw(g);
		}
	}          
	
	public String getGameState() {   
		return gameState;
	}
                     
	public void setGameState(String gameState) {
		this.gameState = gameState;        
	}

	public Object getCurrGame() {
		return currGame;                                                                     
	}

	public void setCurrGame(Object currGame) {
		this.currGame = currGame;
	}

	
	public static void main(String args[]) {
		GameView game = new GameView();
		
		game.makePanel();
		for(int i = 0; i < 1000; i++){
			game.repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		game.repaint();
	}
}
