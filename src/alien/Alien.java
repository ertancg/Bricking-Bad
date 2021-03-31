package alien;

import java.io.Serializable;

public abstract class Alien implements Serializable {
	private String type = "Alien";
	private int alienXCoor;
	private int alienYCoor;
	private int direction;
	
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getAlienXCoor() {
		return alienXCoor;
	}
	
	public void setAlienXCoor(int alienXCoor) {
		this.alienXCoor = alienXCoor;
	}
	
	public int getAlienYCoor() {
		return alienYCoor;
	}
	
	public void setAlienYCoor(int alienYCoor) {
		this.alienYCoor = alienYCoor;
	}
	
	public Alien(int alienXCoor, int alienYCoor) {
		this.alienXCoor = alienXCoor;
		this.alienYCoor = alienYCoor;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public abstract void doAction();
	
}
