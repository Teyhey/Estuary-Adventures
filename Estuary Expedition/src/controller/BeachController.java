package controller;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.BeachModel;
import model.Boat;
import model.Character;
import model.Item;
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
		boatMove(beach.boat);
		waveMove(beach.wave);
		beach.createCurrency(beach.spawnCurrency());
	}

	private void move() {
		for (Boat b : beach.boats) {
			boatMove(b);
		}

		for (Wave w : beach.waves) {
			waveMove(w);
		}

		waveMove(beach.wave);
		checkBorders(beach.player);
		checkXCollisionRight(beach.player, beach.wave);
		checkXCollisionLeft(beach.player, beach.wave);
		checkYCollisionUp(beach.player, beach.wave);
		checkYCollisionDown(beach.player, beach.wave);
		checkVerticalHit(beach.wave, beach.gabion);
		// checkVerticalHit(beach.wave, beach.wall);
		// checkVerticalHit(beach.wave, beach.grass);
	}

	private void checkBorders(Character c) {
		if (c.xCoord <= -1) {
			c.xCoord = 0;
		} else {
			if (c.xCoord >= frameWidth - c.width + 1) {
				c.xCoord = frameWidth - c.width;
			} else {
				c.xCoord += xVel;
			}
		}
		if (c.yCoord <= -1) {
			c.yCoord = 0;
		} else {
			if (c.yCoord <= 540 - c.height + 1) {
				c.yCoord = 540 - c.height + 1;
			} else {
				c.yCoord += yVel;
			}
		}
	}

	private void checkXCollisionRight(Character c, Wave wave) {
		if (c.xCoord + c.width >= wave.xCoord + collision && c.xCoord + c.width <= wave.xCoord + wave.width / 4) {
			if (c.yCoord >= wave.yCoord + collision && c.yCoord <= wave.yCoord + wave.height - (collision * 2)) {
				c.xCoord -= 10;
			}
			if (c.yCoord + c.height >= wave.yCoord && c.yCoord + c.height <= wave.yCoord + wave.height - collision) {
				c.xCoord -= 10;
			}
			if (c.yCoord + c.height / 2 >= wave.yCoord
					&& c.yCoord + c.height / 2 <= wave.yCoord + wave.height - collision) {
				c.xCoord -= 5;
			}
		}
	}

	private void checkXCollisionLeft(Character c, Wave wave) {
		if (c.xCoord <= wave.xCoord + wave.width - collision && c.xCoord >= wave.xCoord + wave.width / 4) {
			if (c.yCoord >= wave.yCoord - collision && c.yCoord <= wave.yCoord + wave.height - (collision * 2)) {
				c.xCoord += 10;
			}
			if (c.yCoord + c.height >= wave.yCoord && c.yCoord + c.height <= wave.yCoord + wave.height - collision) {
				c.xCoord += 10;
			}
			if (c.yCoord + c.height / 2 >= wave.yCoord
					&& c.yCoord + c.height / 2 <= wave.yCoord + wave.height - collision) {
				c.xCoord += 5;
			}
		}
	}

	private void checkYCollisionUp(Character c, Wave wave) {
		if (c.yCoord <= wave.yCoord + wave.height - collision && c.yCoord >= wave.yCoord + wave.height / 4) {
			if (c.xCoord >= wave.xCoord - collision && c.xCoord <= wave.xCoord + wave.width - (collision * 2)) {
				c.yCoord += 10;
			}
			if (c.xCoord + c.width >= wave.xCoord + wave.width
					&& c.xCoord + c.width <= wave.xCoord + wave.width - (collision * 2)) {
				c.yCoord += 10;
			}
			if (c.xCoord + c.width / 2 >= wave.xCoord
					&& c.xCoord + c.width / 2 <= wave.xCoord + wave.width - collision) {
				c.yCoord += 5;
			}
		}
	}

	private void checkYCollisionDown(Character c, Wave wave) {
		if (c.yCoord + c.height >= wave.yCoord + collision && c.yCoord + c.height <= wave.yCoord + wave.height / 4) {
			if (c.xCoord >= wave.xCoord + collision && c.xCoord <= wave.xCoord + wave.width - collision) {
				c.yCoord -= 10;
			}
			if (c.xCoord + c.width <= wave.xCoord + wave.width - collision
					&& c.xCoord + c.width >= wave.xCoord + collision) {
				c.yCoord -= 10;
			}
			if (c.xCoord + c.width / 2 <= wave.xCoord + wave.width - collision
					&& c.xCoord + c.width >= wave.xCoord + collision) {
				c.yCoord -= 5;
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

	private void checkVerticalHit(Wave w, Item i) {
		if (waveHitGabion()) {
			if (i.xCoord + i.width / 2 >= w.xCoord + w.width / 2) {
				i.xCoord = w.xCoord + i.width + (collision * 2);
			} else {
				i.xCoord = w.xCoord - i.width - (collision * 2);
			}
			i.health -= w.getDamage();
		}
		if (waveHitWall(w)) {
			if (i.xCoord + i.width / 2 >= w.xCoord + w.width / 2) {
				i.xCoord = w.xCoord + i.width + (collision * 2);
			} else {
				i.xCoord = w.xCoord - i.width - (collision * 2);
			}
			i.health -= w.getDamage();
		}
		if (waveHitGrass(w)) {
			if (i.xCoord + i.width / 2 >= w.xCoord + w.width / 2) {
				i.xCoord = w.xCoord + i.width + (collision * 2);
			} else {
				i.xCoord = w.xCoord - i.width - (collision * 2);
			}
			i.health -= w.getDamage();
		}
	}

	public boolean waveHitGabion() {
		hitBarrier = false;
		Rectangle barrierz = new Rectangle(beach.gabion.xCoord, beach.gabion.yCoord, 100, 100);
		Rectangle wavez = new Rectangle(beach.wave.xCoord, beach.wave.yCoord, 100, 100);
		if (wavez.intersects(barrierz)) {
			hitBarrier = true;
			System.out.println(true);
		}

		return hitBarrier;
	}

	public boolean waveHitWall(Wave w) {
		hitBarrier = false;
		Rectangle barrierz = new Rectangle(beach.wall.xCoord, beach.wall.yCoord, beach.wall.xCoord, beach.wall.yCoord);
		Rectangle wavez = new Rectangle(w.xCoord, w.yCoord, w.width - collision, w.height - collision);
		if (barrierz.intersects(wavez)) {
			hitBarrier = true;
		}
		return hitBarrier;
	}

	public boolean waveHitGrass(Wave w) {
		hitBarrier = false;
		Rectangle barrierz = new Rectangle(beach.grass.xCoord, beach.grass.yCoord, beach.grass.xCoord,
				beach.grass.yCoord);
		Rectangle wavez = new Rectangle(w.xCoord, w.yCoord, w.width - collision, w.height - collision);
		if (barrierz.intersects(wavez)) {
			hitBarrier = true;
		}
		return hitBarrier;
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
		} else if (e.getKeyCode() == KeyEvent.VK_1) {
			beach.createBarrier("Gabion");
		} else if (e.getKeyCode() == KeyEvent.VK_2) {
			beach.createBarrier("Wall");
		} else if (e.getKeyCode() == KeyEvent.VK_3) {
			beach.createBarrier("Grass");
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