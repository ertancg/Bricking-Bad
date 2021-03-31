package brick;


import javax.swing.ImageIcon;

public class SimpleBrick extends Brick {
	private String type = "SimpleBrick";
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private ImageIcon i = new ImageIcon("src/images/simpleBrick.jpg");
	
	public ImageIcon getI() {
		return i;
	}

	public void setI(ImageIcon i) {
		this.i = i;
	}

	public int getsBrickX() {
		return super.getBrickXCoor();
	}

	public void setsBrickX(int sBrickX) {
		super.setBrickXCoor(sBrickX);
	}

	public int getsBrickY() {
		return super.getBrickYCoor();
	}

	public void setsBrickY(int sBrickY) {
		super.setBrickYCoor(sBrickY);
	}

	public SimpleBrick(int brickXCoor, int brickYCoor) {
		super(brickXCoor, brickYCoor);
	}






	
}
