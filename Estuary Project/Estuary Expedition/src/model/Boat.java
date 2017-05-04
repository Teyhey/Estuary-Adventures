package model;


public class Boat {
	String boatType;
	int damage;
	int speed;
	Position place;
	
	public Boat(String type, int d, int s, Position p) 
	{
		this.boatType = type;
		this.damage = d;
		this.speed = s;
		this.place = p;
	}
		
		
	public String getBoatType()
	{		
		return this.boatType;
	}
		
	public int getDamage()
	{
		return this.damage;
	}
	
	public int getSpeed()
	{
		return this.speed;
	}
	
	public Position getPosition()
	{
		return this.place;
	}
		
	public void setBoatType(String type)
	{
		this.boatType = type;
	}
	
	public void setDamage(int d)
	{
		this.damage = d;
	}
	
	public void setSpeed(int s)
	{
		this.speed = s;
	}
	
	public void setPosition(int x, int y)
	{
		this.place.setxCoord(x);
		this.place.setyCoord(y);
	}


	@Override
	public String toString() {
		return "Boat [boatType=" + boatType + ", damage=" + damage + ", speed=" + speed + ", place=" + place + "]";
	}
		
}


