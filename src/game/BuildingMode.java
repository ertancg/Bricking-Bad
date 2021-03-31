package game;
import brick.*;
import factories.BrickFactory;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;



public class BuildingMode {

	private boolean sbmode = false;
	private boolean hmbmode = false;
	private boolean wbmode = false;
	private boolean mbmode = false;
	private boolean deletemode  = false;
	private Random rgen = new Random();
	private ArrayList<Brick> bricksDrawed = new ArrayList<Brick>();
	private int simpleBrickAmount;
	private int halfMetalBrickAmount;
	private int wrapperBrickAmount;
	private int mineBrickAmount;
	private boolean finished = false;


	public BuildingMode() {

	}

	public boolean isSbmode() {
		return sbmode;
	}

	public void setSbmode(boolean sbmode) {
		this.sbmode = sbmode;
	}

	public boolean isHmbmode() {
		return hmbmode;
	}

	public void setHmbmode(boolean hmbmode) {
		this.hmbmode = hmbmode;
	}

	public boolean isWbmode() {
		return wbmode;
	}

	public void setWbmode(boolean wbmode) {
		this.wbmode = wbmode;
	}

	public boolean isMbmode() {
		return mbmode;
	}

	public void setMbmode(boolean mbmode) {
		this.mbmode = mbmode;
	}

	public boolean isDeletemode() {
		return deletemode;
	}

	public void setDeletemode(boolean deletemode) {
		this.deletemode = deletemode;
	}

	public int getSimpleBrickAmount() {
		return simpleBrickAmount;
	}

	public void setSimpleBrickAmount(int simpleBrickAmount) {
		this.simpleBrickAmount = simpleBrickAmount;
	}

	public int getHalfMetalBrickAmount() {
		return halfMetalBrickAmount;
	}

	public void setHalfMetalBrickAmount(int halfMetalBrickAmount) {
		this.halfMetalBrickAmount = halfMetalBrickAmount;
	}

	public int getWrapperBrickAmount() {
		return wrapperBrickAmount;
	}

	public void setWrapperBrickAmount(int wrapperBrickAmount) {
		this.wrapperBrickAmount = wrapperBrickAmount;
	}

	public int getMineBrickAmount() {
		return mineBrickAmount;
	}

	public void setMineBrickAmount(int mineBrickAmount) {
		this.mineBrickAmount = mineBrickAmount;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}


	public ArrayList<Brick> getBricksDrawed() {
		return bricksDrawed;
	}

	public void setBricksDrawed(ArrayList<Brick> bricksDrawed) {
		this.bricksDrawed = bricksDrawed;
	}

	public void createSB(int x, int y) {
		SimpleBrick s1 = (SimpleBrick) BrickFactory.getBrick("SimpleBrick");
		s1.setsBrickX(x);
		s1.setsBrickY(y);
		bricksDrawed.add(s1);
	}
	public void createHMB(int x, int y) {
		HalfMetalBrick hmb = (HalfMetalBrick) BrickFactory.getBrick("HalfMetalBrick");
		hmb.setBrickXCoor(x);
		hmb.setBrickYCoor(y);
		bricksDrawed.add(hmb);
	}
	public void createWB(int x, int y) {
		WrapperBrick wb = (WrapperBrick) BrickFactory.getBrick("WrapperBrick");
		wb.setBrickXCoor(x);
		wb.setBrickYCoor(y);
		bricksDrawed.add(wb);
	}
	public void createMB(int x,int y) {
		MineBrick mb = (MineBrick) BrickFactory.getBrick("MineBrick");
		mb.setBrickXCoor(x);
		mb.setBrickYCoor(y);
		bricksDrawed.add(mb);
	}

	public void initializeMap(String sbamount, String hmbamount, String wbamount, String mbamount) {
		if(this.finished) {
			while(!getBricksDrawed().isEmpty()) {
				getBricksDrawed().remove(0);
			}
		}
		setSimpleBrickAmount(Integer.parseInt(sbamount));
		setHalfMetalBrickAmount(Integer.parseInt(hmbamount));
		setWrapperBrickAmount(Integer.parseInt(wbamount));
		setMineBrickAmount(Integer.parseInt(mbamount));
		for(int i = 0;i<simpleBrickAmount;i++) {
			int a1 = rgen.nextInt(1210);
			int b1 = rgen.nextInt(400);
			do {
				int a = rgen.nextInt(1210);
				int b = rgen.nextInt(400);
				a1=a;
				b1=b;
			}while(this.brickColliding(getBricksDrawed(), a1, b1));
			createSB(a1,b1);
		}
		for(int j=0;j<halfMetalBrickAmount;j++) {
			int c1 = rgen.nextInt(1210);
			int d1 = rgen.nextInt(470-300)+300;
			do {
				int c = rgen.nextInt(1210);
				int d = rgen.nextInt(470-300)+300;
				c1=c;
				d1=d;
			}while(this.brickColliding(getBricksDrawed(), c1, d1));
			createHMB(c1,d1);
		}
		for(int j=0;j<wrapperBrickAmount;j++) {
			int e1 = rgen.nextInt(1210);
			int f1 = rgen.nextInt(300);
			do {
				int e = rgen.nextInt(1210);
				int f = rgen.nextInt(300);
				e1=e;
				f1=f;
			}while(this.brickColliding(getBricksDrawed(), e1, f1));
			createWB(e1,f1);
		}
		for(int j=0;j<mineBrickAmount;j++) {
			int g1 = rgen.nextInt(1210);
			int h1 = rgen.nextInt(400);
			do {
				int g = rgen.nextInt(1210);
				int h = rgen.nextInt(400);
				g1=g;
				h1=h;
			}while(this.brickColliding(getBricksDrawed(), g1, h1));
			createMB(g1,h1);
		}
		this.finished=true;
	}

	public void removeBrick(int x, int y, boolean playeable) {
		if(!playeable) {
			for(int i=0;i<getBricksDrawed().size();i++) {
					Rectangle hitbox = new Rectangle(x,y,1,1);
					Rectangle rect = new Rectangle(getBricksDrawed().get(i).getBrickXCoor(),getBricksDrawed().get(i).getBrickYCoor(),70,30);
					Rectangle BrickRect= rect;
					if(BrickRect.intersects(hitbox)) {
						getBricksDrawed().remove(i);
					}	
			}
		}
	}
	public boolean brickColliding(ArrayList<Brick> bricks, int a , int b) {
		for(int i=0;i<bricks.size();i++) {
			Rectangle hitbox = new Rectangle (a,b,70,30);
			Rectangle rect = new Rectangle(getBricksDrawed().get(i).getBrickXCoor(),getBricksDrawed().get(i).getBrickYCoor(),70,30);
			Rectangle brect= rect;
			if(brect.intersects(hitbox)) {
				return true;
			}	
		}
		return false;
	}
	
	public void selectSimpleBrick() {
		setSbmode(true);
		setHmbmode(false);
		setWbmode(false);
		setMbmode(false);
		setDeletemode(false);
	}
	
	public void selectHalfMetalBrick() {
		setSbmode(false);
		setHmbmode(true);
		setWbmode(false);
		setMbmode(false);
		setDeletemode(false);
	}
	
	public void selectWrapperBrick() {
		setSbmode(false);
		setHmbmode(false);
		setWbmode(true);
		setMbmode(false);
		setDeletemode(false);
	}
	
	public void selectMineBrick() {
		setSbmode(false);
		setHmbmode(false);
		setWbmode(false);
		setMbmode(true);
		setDeletemode(false);
	}
	
	public void selectDeleteBrick() {
		setSbmode(false);
		setHmbmode(false);
		setWbmode(false);
		setMbmode(false);
		setDeletemode(true);
	}
	
	public void alterMap(int x, int y, boolean playeable) {
		if(this.isDeletemode()) {
			
			this.removeBrick(x, y, playeable);
		}
		if(this.isHmbmode()) {
			
			if(!this.brickColliding(this.getBricksDrawed(), x-35, y-15)) {
				this.createHMB(x-35, y-15);
			}

		}
		if(this.isWbmode()) {
			
			if(!this.brickColliding(this.getBricksDrawed(), x-35, y-15)) {
				this.createWB(x-35, y-15);
			}

		}
		if(this.isMbmode()) {
			
			if(!this.brickColliding(this.getBricksDrawed(), x-35, y-15)) {
				this.createMB(x-35, y-15);
			}

		}
		if(this.isSbmode()) {		
			if(!this.brickColliding(this.getBricksDrawed(), x-35, y-15)) {
				this.createSB(x-35, y-15);
			}

		}
	}


}
