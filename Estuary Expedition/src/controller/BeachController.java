package controller;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.BeachModel;
import model.Boat;
import model.Character;
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
	int time;
	boolean hitWater = false;
	boolean hitBarrier = false;
	boolean pickUp = false;

	int collision = 10;

	public BeachController() {
		beach = new BeachModel();
		this.xVel = 0;
		this.yVel = 0;
		time = 0;
		this.collision = 10;
	}

	public void tick() {
		move();
		waveHit(beach.wave);
		boatMove(beach.boat);
		waveMove(beach.wave);
	}

	private void move() {
		for (Boat b : beach.boats) {
			boatMove(b);
		}

		for (Wave w : beach.waves) {
			waveMove(w);
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

	private void waveMove(Wave w) {
		waveVeritcal(w);
	}

	private void boatHorizontal(Boat e) {
		if (e.xCoord <= -1) {
			e.xCoord = 0;
			e.setSpeed(e.getSpeed() * -1);
			// this.beach.createOcean();

		} else {
			if (e.xCoord >= frameWidth - e.width + 1) {
				e.xCoord = frameWidth - e.width;
				e.setSpeed(e.getSpeed() * -1);
				// this.beach.createOcean();
			} else {
				e.xCoord += e.getSpeed();
			}
		}
	}

	private void waveVeritcal(Wave w) {
		if (w.yCoord <= -1) {
			w.yCoord = 0;
			w.setSpeed(w.getSpeed() * -1);
		} else {
			if (w.yCoord >= 550 - w.height + 1) {
				w.yCoord = frameHeight - w.height;
				w.setSpeed(w.getSpeed() * -1);
			} else {
				w.yCoord += w.getSpeed();
			}
		}
	}


	public void waveHit(Wave w) {
		this.hitBarrier = false;
		for (Item b : beach.barriers) {
			Rectangle barrier = new Rectangle(b.xCoord, b.yCoord, 100, 100);
			Rectangle wave = new Rectangle(w.xCoord, w.yCoord, 100, 100);
			if (wave.intersects(barrier)) {
				this.hitBarrier = true;

				if (b.itemType.equals("Gabion")) {
					beach.numGabions++;
					b.health -= w.getDamage();
				}
				if (b.itemType.equals("Wall")) {
					beach.numWalls++;
					b.health -= w.getDamage();
				}
				if (b.itemType.equals("Grass")) {
					beach.numGrass++;
					b.health -= w.getDamage();
				}
				System.out.println("Barrier HIT!!");
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
				System.out.println("Picked up currency");
			}
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
		} else if (e.getKeyCode() == KeyEvent.VK_1 && beach.numOysters >= 5) {
			beach.createBarrier("Gabion");
			beach.numOysters -= 5;
		} else if (e.getKeyCode() == KeyEvent.VK_2 && beach.numBlocks >= 8) {
			beach.createBarrier("Wall");
			beach.numBlocks -= 8;
		} else if (e.getKeyCode() == KeyEvent.VK_3 && beach.numSeeds >= 12) {
			beach.createBarrier("Grass");
			beach.numSeeds -= 12;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			setxVel(0);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			setxVel(0);
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			setyVel(0);
			;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			setyVel(0);
			;
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

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}