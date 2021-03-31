package powerups;

import javax.swing.ImageIcon;
/**
 * This class describes a DestructiveLaserGun powerUp box in BrickingBadGame which can be dropped from WrapperBrick
 * and can be caught by paddle for future usage.
 * @author Gandhi
 *
 */
public class DLG extends PowerUp {
	private ImageIcon i = new ImageIcon("src/images/dlg.jpg");
	
	/**
	 * This constructor creates the DestructiveLaserGun powerUp box and initializes the coordinates
	 * where the powerUp is going to start dropping.
	 * @param pXCoor is the X coordinate of the powerUp box
	 * @param pYCoor is the Y coordinate of the powerUp box
	 */
	public DLG(int pXCoor, int pYCoor) {
		super(pXCoor, pYCoor);
		// TODO Auto-generated constructor stub
	}
	/**
	 * This method starts the initialized powerUp box to drop to the ground level vertically by
	 * modifying the Y coordinate of the powerUp box
	 */
	@Override
	public void drop() {
		// TODO Auto-generated method stub
		super.setpYCoor(super.getpYCoor()+2);
	}
	/**
	 * This method returns the corresponding image icon of the DestructiveLaserGun powerUp
	 * box
	 * @return the imageIcon of the DestructiveLaserGun powerUp
	 */

	public ImageIcon getI() {
		return i;
	}
	/**
	 * This method sets the corresponding image icon of the DestructiveLaserGun powerUp
	 * box
	 * @param i is the imageIcon of the DestructiveLaserGun powerUp which is going to be set
	 */
	public void setI(ImageIcon i) {
		this.i = i;
	}
	/**
	 * This method returns the String of this object
	 */
	@Override
	public String toString() {
		return "DLG [getpXCoor()=" + getpXCoor() + ", getpYCoor()=" + getpYCoor() + "]";
	}
	/**
	 * This method checks if this is a valid powerUp
	 * @return false if DLG is not valid, true if DLG is valid
	 */
	public boolean repOk() {
		if(super.getpXCoor()<0 || super.getpYCoor()>900 || super.getpXCoor()>1280 || super.getpYCoor()<0) {
			return false;
		}
		return true;
	}
	
}
