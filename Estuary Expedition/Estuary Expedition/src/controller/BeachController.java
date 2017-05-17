package controller;

import java.awt.Rectangle;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.BeachModel;
import model.Boat;
import model.Item;
import model.Player;
import model.Wave;

public class BeachController implements KeyListener {

	public int xVel;
	public int yVel;
	public BeachModel beach;
	int frameWidth = 1280;
	int frameHeight = 800;
	int padding = 100;
	int gabionLimit = 8;
	int wallLimit = 4;
	int grassLimit = 15;
	int lastWaveLoc;
	boolean hitWater = false;
	boolean hitBarrier = false;
	boolean pickUp = false;
	String message = "";
	String mode;
	long timer = System.currentTimeMillis();
	int timeLeft;

	int collision = 10;

	public BeachController() {
		beach = new BeachModel();
		this.xVel = 0;
		this.yVel = 0;
		this.collision = 10;
		mode = "Normal";
		lastWaveLoc = 0;
		timeLeft = 60;
	}

	private void timeTick() {
		if (System.currentTimeMillis() - this.timer > 1000) {
			this.timer += 1000;
			this.timeLeft--;
		}
	}
	
	public void tick() {
		move();
		waveHit(beach.wave);
		boatMove(beach.boat);
		// waveMove(beach.wave);
		wakeSpawn(beach.boat);
		// this.beach.createWakes();
		timeTick();
	}

	private void move() {
		for (Boat b : beach.boatArr) {
			boatMove(b);
		}

		for (Wave w : beach.waveArr) {
			waveVertical(w);
			this.beach.createWakes();

		}

		checkBorders(beach.player);
		beach.createCurrency();
		pickUpCurrency(beach.player);

	}

	private void checkBorders(Player p) {
		if (p.xCoord <= -1) {
			p.xCoord = 0;
		} else {
			if (p.xCoord >= frameWidth - p.width + 1) {
				p.xCoord = frameWidth - p.width;
			} else {
				p.xCoord += xVel;
			}
		}
		if (p.yCoord <= ((frameHeight / 3) * 2) - 1) {
			p.yCoord = (frameHeight / 3) * 2;
		} else {
			if (p.yCoord >= (frameHeight - p.height) + 1) {
				p.yCoord = frameHeight - p.height;
			} else {
				p.yCoord += yVel;
			}
		}
	}

	private void boatMove(Boat e) {
		boatHorizontal(e);
	}

	private void boatHorizontal(Boat e) {
		if (e.xCoord <= -1) {
			e.xCoord = 0;
			e.setSpeed(e.getSpeed() * -1);
			// this.beach.createBoats();

		} else {
			if (e.xCoord >= frameWidth - e.width + 1) {
				e.xCoord = frameWidth - e.width;
				e.setSpeed(e.getSpeed() * -1);
				// this.beach.createBoats();
			} else {
				e.xCoord += e.getSpeed();
			}
		}
	}

	private void waveVertical(Wave w) {

		w.yCoord += w.getSpeed();
		if (w.yCoord == 720) {
			w.xCoord = beach.boat.xCoord;
			w.yCoord = beach.boat.yCoord;
		}
	}

	public void waveHit(Wave w) {
		this.hitBarrier = false;
			
			for (Item b : beach.barriers) {
				Rectangle barrier = new Rectangle(b.xCoord, b.yCoord, 100, 100);
				Rectangle wave = new Rectangle(b.xCoord, b.yCoord, 100, 100);

				if(b.itemType.equals("Gabion")){
					b.health = 10;
				}
				if(b.itemType.equals("Wall")){
					b.health = 15;
				}
				if(b.itemType.equals("Grass")){
					b.health = 10;
				}
				
				if (wave.intersects(barrier) && b.itemType.equals("Gabion")) {
					this.hitBarrier = true;
					b.health -= w.getDamage();
					System.out.println("Gabion HIT!!");
					if (b.health <= 0) {
						beach.numGabions--;
						b.xCoord = 2000;
						b.yCoord = 2000;
					}
				}

				if (wave.intersects(barrier) && b.itemType.equals("Wall")) {
					this.hitBarrier = true;
					b.health -= w.getDamage();
					System.out.println("Wall HIT!!");
					if (b.health <= 0) {
						beach.numWalls--;
						b.xCoord = 2000;
						b.yCoord = 2000;
					}
				}

				if (wave.intersects(barrier) && b.itemType.equals("Grass")) {
					this.hitBarrier = true;
					b.health -= w.getDamage();
					System.out.println("Grass HIT!!");
					if (b.health <= 0) {
						beach.numGrass--;
						b.xCoord = 2000;
						b.yCoord = 2000;
					}

				}
			}
		}
	

	public void pickUpCurrency(Player c) {
		this.pickUp = false;
		for (Item i : beach.currencyArr) {
			Rectangle pickUps = new Rectangle(i.xCoord, i.yCoord, 100, 100);
			Rectangle player = new Rectangle(c.xCoord, c.yCoord, 100, 100);
			if (player.intersects(pickUps)) {
				this.pickUp = true;
				beach.currency.remove(i);
				if (i.itemType.equals("Oyster")) {
					beach.numOysters++;
				}
				if (i.itemType.equals("Block")) {
					beach.numBlocks++;
				}
				if (i.itemType.equals("Seed")) {
					beach.numSeeds++;
				}
				// System.out.println("Picked up currency");
			}
		}
	}

	void wakeSpawn(Boat b) {
		for (Wave w : beach.waves) {
			waveVertical(w);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			setxVel(5);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			setxVel(-5);
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			setyVel(-5);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			setyVel(5);
		} else if (e.getKeyCode() == KeyEvent.VK_1 && beach.numOysters >= 5 && beach.numGabions <= gabionLimit) {
			beach.createBarrier("Gabion");
			beach.numOysters -= 5;
			beach.numGabions++;
			message = "Gabion bought";
		} else if (e.getKeyCode() == KeyEvent.VK_2 && beach.numBlocks >= 8 && beach.numWalls <= wallLimit) {
			beach.createBarrier("Wall");
			beach.numBlocks -= 8;
			beach.numWalls++;
			message = "Sea Wall bought";
		} else if (e.getKeyCode() == KeyEvent.VK_3 && beach.numSeeds >= 12 && beach.numGrass <= grassLimit) {
			beach.createBarrier("Grass");
			beach.numSeeds -= 12;
			beach.numGrass++;
			message = "Grass bought";
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			setxVel(0);
			// message = "";
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			setxVel(0);
			// message = "";
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			setyVel(0);
			message = "";
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			setyVel(0);
			message = "";
		} else if (e.getKeyCode() == KeyEvent.VK_1) {
			// message = "";
		} else if (e.getKeyCode() == KeyEvent.VK_2) {
			// message = "";
		} else if (e.getKeyCode() == KeyEvent.VK_3) {
			// message = "";
		}
	}

	public int getxVel() {
		return xVel;
	}

	public void setxVel(int xVel) {
		this.xVel = xVel;
	}

	public int getyVel() {
		return yVel;
	}

	public void setyVel(int yVel) {
		this.yVel = yVel;
	}

	public BeachModel getBeach() {
		return beach;
	}

	public void setBeach(BeachModel beach) {
		this.beach = beach;
	}

	public int getFrameWidth() {
		return frameWidth;
	}

	public void setFrameWidth(int frameWidth) {
		this.frameWidth = frameWidth;
	}

	public int getFrameHeight() {
		return frameHeight;
	}

	public void setFrameHeight(int frameHeight) {
		this.frameHeight = frameHeight;
	}

	public int getPadding() {
		return padding;
	}

	public void setPadding(int padding) {
		this.padding = padding;
	}

	public int getTimeLeft() {
		return timeLeft;
	}

	public boolean isHitWater() {
		return hitWater;
	}

	public void setHitWater(boolean hitWater) {
		this.hitWater = hitWater;
	}

	public boolean isHitBarrier() {
		return hitBarrier;
	}

	public void setHitBarrier(boolean hitBarrier) {
		this.hitBarrier = hitBarrier;
	}

	public int getCollision() {
		return collision;
	}

	public void setCollision(int collision) {
		this.collision = collision;
	}

	public boolean isPickUp() {
		return pickUp;
	}

	public void setPickUp(boolean pickUp) {
		this.pickUp = pickUp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}