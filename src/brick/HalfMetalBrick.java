package brick;

import javax.swing.ImageIcon;

public class HalfMetalBrick extends Brick {
	private String type = "HalfMetalBrick";
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private ImageIcon i = new ImageIcon("src/images/halfmetalbrick.jpg");
	
	public HalfMetalBrick(int brickXCoor, int brickYCoor) {
		super(brickXCoor, brickYCoor);
		// TODO Auto-generated constructor stub
	}

	public ImageIcon getI() {
		return i;
	}

	public void setI(ImageIcon i) {
		this.i = i;
	}
	


}
