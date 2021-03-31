package alien;

import javax.swing.ImageIcon;

public class RepairingAlien extends Alien {

	private ImageIcon i = new ImageIcon("src/images/repairingAlien.jpg");

	public ImageIcon getI() {
		return i;
	}

	public void setI(ImageIcon i) {
		this.i = i;
	}

	public RepairingAlien(int alienXCoor, int alienYCoor) {
		super(alienXCoor, alienYCoor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

}
