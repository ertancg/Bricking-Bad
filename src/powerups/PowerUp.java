package powerups;

import java.io.Serializable;

public abstract class PowerUp implements Serializable{
	private int pXCoor;
	private int pYCoor;
	public int getpXCoor() {
		return pXCoor;
	}
	public void setpXCoor(int pXCoor) {
		this.pXCoor = pXCoor;
	}
	public int getpYCoor() {
		return pYCoor;
	}
	public void setpYCoor(int pYCoor) {
		this.pYCoor = pYCoor;
	}
	public PowerUp(int pXCoor, int pYCoor) {
		super();
		this.pXCoor = pXCoor;
		this.pYCoor = pYCoor;
	}
	
	public abstract void drop();
}
