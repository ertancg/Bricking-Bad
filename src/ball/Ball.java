package ball;

import java.io.Serializable;

/**
 * This class describes the Ball object of the BrickingBadGame which moves and destroys bricks,aliens and which
 * has several types.
 * @author Gandhi
 *
 */

public class Ball implements Serializable {
	

	private String type = "Ball";
	private int ballXcoor;
	private int ballYcoor;
	private int ballXdir;
	private int ballYdir;
	private int damage;
	private static final int diameter = 17;
	private boolean  isNormal = true;
	private boolean  isChemical = false;
	private boolean  isFire = false;

	/**
	 * This method returns the state(boolean) of the ball which is normal, chemical or fire
	 * @return the ball's isNormal boolean.
	 */
	public boolean isNormal() {
		return isNormal;
	}
	/**
	 * This method sets the isNormal state(boolean) of the ball true and sets the other states 
	 * false
	 */
	public void setNormal() {
		this.isNormal = true;
		this.isChemical=false;
		this.isFire=false;
	}
	/**
	 * This method returns the state(boolean) of the ball which is normal,chemical or fire
	 * @return the  ball's isChemical boolean.
	 */
	public boolean isChemical() {
		return isChemical;
	}
	/**
	 * This method sets the isChemical state(boolean) of the ball true and sets the other states false 
	 */
	public void setChemical() {
		this.isNormal = false;
		this.isChemical=true;
		this.isFire=false;
	}
	/**
	 * This method returns the state(boolean) of the ball which is normal,chemical or fire
	 * @return the ball's isFire boolean
	 */
	public boolean isFire() {
		return isFire;
	}
	/**
	 * This method sets the isFire state(boolean) of the ball true and sets the other states false
	 */
	public void setFire() {
		this.isNormal = false;
		this.isChemical=false;
		this.isFire=true;
	}
	/**
	 * This method returns the X coordinate of the ball
	 * @return the ball's ballXCoor
	 */
	public int getBallXcoor() {
		return ballXcoor;
	}
	/**
	 * This method sets the X coordinate of the ball 
	 * @param ballXcoor is the X coordinate which the ball's ballXCoordinate is going to become
	 */
	public void setBallXcoor(int ballXcoor) {
		this.ballXcoor = ballXcoor;
	}
	/**
	 * This method returns the Y coordinate of the ball
	 * @return the ball's ballYCoor
	 */
	public int getBallYcoor() {
		return ballYcoor;
	}
	/**
	 * This method sets the Y coordinate of the ball
	 * @param ballYcoor is the Y coordinate which the ball's ballYCoordinate is going to become
	 */
	public void setBallYcoor(int ballYcoor) {
		this.ballYcoor = ballYcoor;
	}
	/**
	 * This method  returns the damage of the ball
	 * @return the ball's damage
	 */
	public int getDamage() {
		return damage;
	}
	/**
	 * This method sets the damage of the ball
	 * @param damage is the damage which the ball's damage is going to become
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}

	/**
	 * This constructor creates a ball and initializes its coordinates, directions and damage
	 * @param ballXcoor is the X coordinate of the ball
	 * @param ballYcoor is the Y coordinate of the ball
	 * @param ballXdir is the X direction of the ball
	 * @param ballYdir is the Y direction of the ball
	 * @param damage is the damage of the ball
	 */
	public Ball(int ballXcoor, int ballYcoor, int ballXdir, int ballYdir, int damage) {
		super();
		this.ballXcoor = ballXcoor;
		this.ballYcoor = ballYcoor;
		this.ballXdir = ballXdir;
		this.ballYdir = ballYdir;
		this.damage=damage;
	}
	/**
	 * This method returns the X direction of the ball 
	 * @return the ball's ballXdir
	 */
	public int getBallXdir() {
		return ballXdir;
	}
	/**
	 * This method sets the X direction of the ball
	 * @param ballXdir is the direction which the ballXdir is going to become
	 */
	public void setBallXdir(int ballXdir) {
		this.ballXdir = ballXdir;
	}
	/**
	 * This method returns the Y direction of the ball
	 * @return the ball's ballYdir
	 */
	public int getBallYdir() {
		return ballYdir;
	}
	/**
	 * This method returns the Y direction of the ball
	 * @param ballYdir is the direction which the ballYdir is going to become
	 */
	public void setBallYdir(int ballYdir) {
		this.ballYdir = ballYdir;
	}
	/**
	 * This method returns the diameter of the ball
	 * @return the ball's diameter
	 */
	public static int getDiameter() {
		return diameter;
	}
	/**
	 * This method returns the type of the ball
	 * @return the ball's type
	 */
	public String getType() {
		return type;
	}
	/**
	 * This  method sets the type of the ball
	 * @param type is the type which the ball's type is going to become
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * This method returns the String of this object
	 */
	@Override
	public String toString() {
		return "Ball [type=" + type + ", ballXcoor=" + ballXcoor + ", ballYcoor=" + ballYcoor + ", ballXdir=" + ballXdir
				+ ", ballYdir=" + ballYdir + ", damage=" + damage + "]";
	}
	/**
	 * This method checks if this is a Ball
	 * @return false if Ball is not valid, true if Ball is valid
	 */
	public boolean repOk() {
		if(this.getType()!="Ball") {
			return false;
		}
		if(this.getBallXcoor()<0 || this.getBallYcoor()>900 || this.getBallXcoor()>1280 || this.getBallYcoor()<0) {
			return false;
		}
		return true;
	}
	
}
