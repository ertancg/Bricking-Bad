package alien;

import javax.swing.ImageIcon;

public class CooperativeAlien extends Alien{

	public CooperativeAlien(int alienXCoor, int alienYCoor) {
		super(alienXCoor, alienYCoor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}
	
	private ImageIcon i = new ImageIcon("src/images/cooperativeAlien.jpg");

	public ImageIcon getI() {
		return i;
	}

	public void setI(ImageIcon i) {
		this.i = i;
	}

}
