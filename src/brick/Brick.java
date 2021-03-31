package brick;

import java.io.Serializable;

public class Brick implements Serializable {

	private int brickXCoor;
	private int brickYCoor;
	private static final int length = 70;
	private static final int width = 30;
	
	public int getBrickXCoor() {
		return brickXCoor;
	}
	public void setBrickXCoor(int brickXCoor) {
		this.brickXCoor = brickXCoor;
	}
	public int getBrickYCoor() {
		return brickYCoor;
	}
	public void setBrickYCoor(int brickYCoor) {
		this.brickYCoor = brickYCoor;
	}
	public Brick(int brickXCoor, int brickYCoor) {
		this.brickXCoor = brickXCoor;
		this.brickYCoor = brickYCoor;
	}
	public static int getLength() {
		return length;
	}
	public static int getWidthBrick() {
		return width;
	}

	
	
}
