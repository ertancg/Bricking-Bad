package alien;

import javax.swing.ImageIcon;

public class DrunkAlien extends Alien {
	
	private String behaviour;
	private int inconsistentlifeTime;
	
	public int getInconsistentlifeTime() {
		return inconsistentlifeTime;
	}

	public void setInconsistentlifeTime(int incosistentlifeTime) {
		this.inconsistentlifeTime = incosistentlifeTime;
	}

	private ImageIcon i = new ImageIcon("src/images/drunkAlien.jpg");
	
	public String getBehaviour() {
		return behaviour;
	}

	public void setBehaviour(String behaviour) {
		this.behaviour = behaviour;
	}

	public DrunkAlien(int alienXCoor, int alienYCoor) {
		super(alienXCoor, alienYCoor);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void doAction() {
		if(super.getDirection() == 1) {
			super.setAlienXCoor(getAlienXCoor()+2);
		}
		if(super.getDirection() == -1) {
			super.setAlienXCoor(getAlienXCoor()-2);
		}
	}
	
	public ImageIcon getI() {
		return i;
	}

	public void setI(ImageIcon i) {
		this.i = i;
	}

}
