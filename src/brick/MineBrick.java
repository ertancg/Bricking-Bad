package brick;



public class MineBrick extends Brick{
	private String type = "MineBrick";
	
	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public MineBrick(int brickXCoor, int brickYCoor) {
		super(brickXCoor, brickYCoor);
		// TODO Auto-generated constructor stub
	}

}
