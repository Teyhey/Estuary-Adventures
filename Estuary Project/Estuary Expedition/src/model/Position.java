package model;

public class Position {

	int xCoord;
	int yCoord;

	public Position() {// Subject to change!
		this.xCoord = 0; 
		this.yCoord = 0;
	}

	public Position(int x, int y) {
		this.xCoord = x;
		this.yCoord = y;
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

	@Override
	public String toString() {
		return "Position [xCoord=" + xCoord + ", yCoord=" + yCoord + "]";
	}

}
