package alien;

import javax.swing.ImageIcon;
/**
 * This class describes a ProtectingAlien object in BrickingBadGame which can appear
 * after a WrapperBrick is destroyed and disappears if the Ball object hits from its top level.
 * @author Gandhi
 *
 */

public class ProtectingAlien extends Alien {
	
	private ImageIcon i = new ImageIcon("src/images/protectingAlien.jpg");
	private int length=50;
	private int width =50;
	/**
	 * This method returns the length of the ProtectingAlien
	 * @return the length of the ProtectingAlien
	 */
	public int getLength() {
		return length;
	}
	/**
	 * This method sets the length of the ProtectingAlien
	 * @param length is the length which is going to become the ProtectingAlien's length
	 */
	public void setLength(int length) {
		this.length = length;
	}
	/**
	 * This method returns the width of the ProtectingAlien
	 * @return the width of the ProtectingAlien
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * This method sets the width of the ProtectingAlien
	 * @param width is the width which is going to become the ProtectingAlien's width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * This constructor creates the ProtectingAlien object and initializes the coordinates where the ProtectingAlien
	 * is going to start a loop movement(leftmost-rightmost, rightmost-leftmost) among the BrickingBadGame window borders.
	 * @param alienXCoor is the X coordinate of the ProtectingAlien
	 * @param alienYCoor is the Y coordinate of the ProtectingAlien
	 */
	public ProtectingAlien(int alienXCoor, int alienYCoor) {
		super(alienXCoor, alienYCoor);
		// TODO Auto-generated constructor stub
	}
	/**
	 * This method starts the loop movement(leftmost-rightmost, rightmost-leftmost) of the ProtectingAlien and
	 * continues till the ProtectingAlien is hit by its top level.
	 */
	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		if(super.getDirection() == 1) {
			super.setAlienXCoor(getAlienXCoor()+2);
		}
		if(super.getDirection() == -1) {
			super.setAlienXCoor(getAlienXCoor()-2);
		}
	}
	/**
	 * This method returns the corresponding image icon of the ProtectingAlien object
	 * @return the imageIcon of the DestructiveLaserGun powerUp
	 */
	public ImageIcon getI() {
		return i;
	}
	/**
	 * This method sets the corresponding image icon of the ProtectingAlien object
	 * @param i is the imageIcon of the ProtectingAlien object which is going to be set
	 */
	public void setI(ImageIcon i) {
		this.i = i;
	}
	/**
	 * This method returns the String of this object
	 */
	@Override
	public String toString() {
		return "ProtectingAlien [getAlienXCoor()=" + getAlienXCoor() + ", getAlienYCoor()=" + getAlienYCoor()
				+ ", getType()=" + getType() + "]";
	}
	/**
	 * This method checks if this is a valid alien
	 * @return false if ProtectingAlien is not valid, true if ProtectingAlien is valid
	 */
	public boolean repOk() {
		if(super.getAlienXCoor()<0 || super.getAlienYCoor()>900 || super.getAlienXCoor()>1280 || super.getAlienYCoor()<0) {
			return false;
		}
		if(this.getLength()!=50 || this.getWidth() != 50) {
			return false;
		}
		return true;
	}


}
