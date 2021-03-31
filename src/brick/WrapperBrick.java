package brick;

import javax.swing.ImageIcon;
/**
 * This class describes the WrapperBrick object of the BrickingBadGame which can be destroyed 
 * by the Ball object and which can cause an appearance of Alien or a PowerUp
 * @author Gandhi
 *
 */
public class WrapperBrick extends Brick {
	
	private ImageIcon i1 = new ImageIcon("src/images/wrapperbrick.jpg");
	
	private String type = "WrapperBrick";
	/**
	 * This method returns the type of the Brick
	 * @return the type of the Brick
	 */
	public String getType() {
		return type;
	}
	/**
	 * This method sets the type of the Brick
	 * @param type is the type which the Brick's type is going to become.
	 */
	public void setType(String type) {
		this.type = type;
	}


	/**
	 * This method returns the corresponding image icon of the WrapperBrick object
	 * @return the imageIcon of the WrapperBrick
	 */
	public ImageIcon getI1() {
		return i1;
	}
	/**
	 * This method sets the corresponding image icon of the WrapperBrick object
	 * @param i is the imageIcon of the WrapperBrick object which is going to be set
	 */
	public void setI1(ImageIcon i1) {
		this.i1 = i1;
	}
	/**
	 * This constructor creates the WrapperBrick and initializes its coordinates
	 * @param brickXCoor is the X coordinate of the WrapperBrick
	 * @param brickYCoor is the Y coordinate of the WrapperBrick
	 */
	public WrapperBrick(int brickXCoor, int brickYCoor) {
		super(brickXCoor, brickYCoor);
		// TODO Auto-generated constructor stub
	}
	/**
	 * This method returns the String of this object
	 */
	@Override
	public String toString() {
		return "WrapperBrick [type=" + type + ", getBrickXCoor()=" + getBrickXCoor() + ", getBrickYCoor()="
				+ getBrickYCoor() + "]";
	}
	/**
	 * This method checks if this is a valid brick
	 * @return false if WrapperBrick is not valid, true if wrapper brick is valid
	 */
	public boolean repOk() {
		if(super.getBrickXCoor()<0 || super.getBrickYCoor()>900 || super.getBrickXCoor()>1280 || super.getBrickYCoor()<0) {
			return false;
		}
		if(!this.type.equals("WrapperBrick")) {
			return false;
		}
		if(super.getLength()!=70 || super.getWidthBrick()!=30) {
			return false;
		}
		return true;
	}

}
