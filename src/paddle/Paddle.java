package paddle;

import java.io.Serializable;

/**
 * This class describes the Paddle object of the BrickingBadGame which can be controlled by the Player of the BrickingBadGame 
 * and which bounces the Ball objects to continue the game.
 * @author Gandhi
 *
 */
public class Paddle implements Serializable {

	private String type = "Paddle";
	private static final int width = 20;
	private int length = 90;
	private int paddleXCoordinate;
	private int paddleYCoordinate;
	private int rotateAngle;
	private boolean armed;
	
	/**
	 * This method returns the state(boolean) of the paddle which is armed or not
	 * @return the paddle's armed boolean
	 */
	public boolean isArmed() {
		return armed;
	}
	/**
	 * This method sets the state(boolean) of the paddle which is armed or not
	 * @param armed is the boolean which describes the state of paddle
	 */
	public void setArmed(boolean armed) {
		this.armed = armed;
	}
	/**
	 * This method returns the rotate angle of the paddle
	 * @return the paddle's rotateAngle
	 */
	public int getRotateAngle() {
		return rotateAngle;
	}
	/**
	 * This method sets the rotate angle of the paddle
	 * @param rotateAngle is the paddle's rotateAngle which the paddle's rotateAngle is going to become
	 */
	public void setRotateAngle(int rotateAngle) {
		this.rotateAngle = rotateAngle;
	}
	/**
	 * This method returns the length of the paddle
	 * @return the paddle's length
	 */
	public int getLength() {
		return length;
	}
	/**
	 * This method sets the length of the paddle
	 * @param length is the length which the paddle's length is going to become
	 */
	public void setLength(int length) {
		this.length = length;
	}
	
	/**
	 * This method returns the X coordinate of the Paddle
	 * @return the paddle's paddleXCoordinate
	 */

	public int getPaddleXCoordinate() {
		return paddleXCoordinate;
	}
	/**
	 * This method sets the X coordinate of the Paddle
	 * @param paddleXCoordinate is the X coordinate which the paddle's paddleXCoordinate is going to become.
	 */
	public void setPaddleXCoordinate(int paddleXCoordinate) {
		this.paddleXCoordinate = paddleXCoordinate;
	}
	/**
	 * This method returns the Y coordinate of the Paddle
	 * @return the paddle's paddleYCoordinate
	 */

	public int getPaddleYCoordinate() {
		return paddleYCoordinate;
	}
	/**
	 * This method sets the Y coordinate of the Paddle
	 * @param paddleYCoordinate is the Y coordinate which the paddle's paddleYCoordinate is going to become.
	 */
	public void setPaddleYCoordinate(int paddleYCoordinate) {
		this.paddleYCoordinate = paddleYCoordinate;
	}
	/**
	 * This constructor creates the Paddle object and initializes its length, X coordinate, Y coordinate and rotateAngle
	 * 
	 * @param length is the length of the paddle
	 * @param paddleXCoordinate is the X coordinate of the paddle
	 * @param paddleYCoordinate is the Y coordinate of the paddle
	 * @param rotateAngle is the Angle of the paddle
	 */
	public Paddle(int length, int paddleXCoordinate, int paddleYCoordinate,int rotateAngle) {
		super();
		this.length = length;
		this.paddleXCoordinate = paddleXCoordinate;
		this.paddleYCoordinate = paddleYCoordinate;
		this.rotateAngle=rotateAngle;
		
	}

	/**
	 * This method returns the type of the Paddle
	 * @return the type of the paddle
	 */
	public String getType() {
		return type;
	}
	/**
	 * This method sets the type of the Paddle
	 * @param type is the type which the paddle's type is going to become
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * This method returns the width of the Paddle
	 * @return the width of the Paddle
	 */
	public static int getWidthPaddle() {
		return width;
	}
	/**
	 * This method returns the String of this object
	 */
	@Override
	public String toString() {
		return "Paddle [type=" + type + ", length=" + length + ", paddleXCoordinate=" + paddleXCoordinate
				+ ", paddleYCoordinate=" + paddleYCoordinate + ", rotateAngle=" + rotateAngle + ", armed=" + armed
				+ "]";
	}
	/**
	 * This method checks if this is a Paddle
	 * @return false if Paddle is not valid, true if Paddle is valid
	 */
	public boolean repOk() {
		if(this.getType()!="Paddle") {
			return false;
		}
		if(this.getPaddleXCoordinate()<0 || this.getPaddleYCoordinate()>900 || this.getPaddleXCoordinate()>1280 || this.getPaddleYCoordinate()<0) {
			return false;
		}
		if(this.width!=20) {
			return false;
		}
		return true;
	}
	
}
