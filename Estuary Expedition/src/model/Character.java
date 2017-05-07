package model;

public class Character {
	public int xCoord;
	public int yCoord;
	public int width;
	public int height;

	
	public Character(int x, int y){
		this.xCoord = x;
		this.yCoord = y;
		this.width = 0;
		this.height = 0;
	}

	public int getxCoord() {
		return xCoord;
	}


	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}


	public int getyCoord() {
		return yCoord;
	}


	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
