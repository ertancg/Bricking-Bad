package game;
import ball.*;
import brick.*;
import factories.AlienFactory;
import factories.PowerUpFactory;
import paddle.*;
import powerups.ChemicalBall;
import powerups.DLG;
import powerups.FireBall;
import powerups.GangOfBalls;
import powerups.Magnet;
import powerups.PowerUp;
import powerups.TallerPaddle;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import Player.Player;
import alien.Alien;
import alien.CooperativeAlien;
import alien.DrunkAlien;
import alien.ProtectingAlien;
import alien.RepairingAlien;



public class RunningMode  {

	private Random rgen = new Random();
	private boolean play = false;
	private boolean ballsNotThrown = true;
	private boolean isPaused= false;
	private Paddle paddle = new Paddle(200,290,680,0);
	private Ball ball = new Ball(paddle.getPaddleXCoordinate()+paddle.getLength()/2, paddle.getPaddleYCoordinate()-Ball.getDiameter(),-1,-2,0);
	private ArrayList<Ball> ballIsDrawn = new ArrayList<Ball>();
	private ArrayList<Ball> stuckBalls = new ArrayList<Ball>();
	private ArrayList<Alien> aliensDrawn = new ArrayList<Alien>();
	private ArrayList<PowerUp> powerUpsDrawn = new ArrayList<PowerUp>();
	private int initBa;
	private boolean tpIsActive = false;
	private boolean magnetActive =false;
	private boolean chemicalActive = false;
	private boolean laserActive= false;
	private boolean copAlien = true;
	private Player player = new Player(0,0,0,0,0,0,0,3);

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getInitBa() {
		return initBa;
	}

	public void setInitBa(int initBa) {
		this.initBa = initBa;
	}

	public boolean isLaserActive() {
		return laserActive;
	}

	public void setLaserActive(boolean laserActive) {
		this.laserActive = laserActive;
	}

	public boolean isChemicalActive() {
		return chemicalActive;
	}

	public void setChemicalActive(boolean chemicalActive) {
		this.chemicalActive = chemicalActive;
	}

	public int getLifeAmount() {
		return player.getNoOfLives();
	}

	public void setLifeAmount(int lifeAmount) {
		player.setNoOfLives(lifeAmount);
	}

	public boolean isMagnetActive() {
		return magnetActive;
	}

	public void setMagnetActive(boolean magnetActive) {
		this.magnetActive = magnetActive;
	}

	public boolean isTpIsActive() {
		return tpIsActive;
	}

	public void setTpIsActive(boolean tpIsActive) {
		this.tpIsActive = tpIsActive;
	}

	public int getScore() {
		return player.getScore();
	}

	public void setScore(int score) {
		player.setScore(score);
	}

	public int getChemicalBA() {
		return player.getChemball();
	}

	public void setChemicalBA(int chemicalBA) {
		player.setChemball(chemicalBA);
	}

	public int getFireballA() {
		return player.getFireball();
	}

	public void setFireballA(int fireballA) {
		player.setFireball(fireballA);
	}

	public int getGangOfBallsA() {
		return player.getGob();
	}

	public void setGangOfBallsA(int gangOfBallsA) {
		player.setGob(gangOfBallsA);
	}

	public int getDlgA() {
		return player.getDlg();
	}

	public void setDlgA(int dlgA) {
		player.setDlg(dlgA);
	}

	public int getTpPowAmount() {
		return player.getTallp();
	}

	public int getMagnetamount() {
		return player.getMagnet();
	}

	public void setMagnetamount(int magnetamount) {
		player.setMagnet(magnetamount);
	}

	public void setTpPowAmount(int tpPowAmount) {
		player.setTallp(tpPowAmount);
	}

	public ArrayList<PowerUp> getPowerUpsDrawn() {
		return powerUpsDrawn;
	}

	public void setPowerUpsDrawn(ArrayList<PowerUp> powerUpsDrawn) {
		this.powerUpsDrawn = powerUpsDrawn;
	}

	public ArrayList<Alien> getAliensDrawn() {
		return aliensDrawn;
	}

	public void setAliensDrawn(ArrayList<Alien> aliensDrawn) {
		this.aliensDrawn = aliensDrawn;
	}

	public ArrayList<Ball> getBallIsDrawn() {
		return ballIsDrawn;
	}

	public void setBallIsDrawn(ArrayList<Ball> ballIsDrawn) {
		this.ballIsDrawn = ballIsDrawn;
	}

	public Ball getBall() {
		return ball;
	}

	public void setBall(Ball ball) {
		this.ball = ball;
	}

	public Paddle getPaddle() {
		return paddle;
	}

	public void setPaddle(Paddle paddle) {
		this.paddle = paddle;
	}

	public boolean isBallNotThrown() {
		return ballsNotThrown;
	}

	public void setBallNotThrown(boolean ballNotThrown) {
		this.ballsNotThrown = ballNotThrown;
	}

	public boolean isPaused() {
		return isPaused;
	}

	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}

	public boolean isPlay() {
		return play;
	}

	public void setPlay(boolean play) {
		this.play = play;
	}

	public void createFirstBall() {
		getBallIsDrawn().add(new Ball(getPaddle().getPaddleXCoordinate()+getPaddle().getLength()/2, getPaddle().getPaddleYCoordinate()-17,-1,-2,0));
	}

	public void moveRigth() {
		if (this.isPlay() && !this.isPaused) {
			if (paddle.getPaddleXCoordinate()+paddle.getLength() < 1280) {
				paddle.setPaddleXCoordinate(paddle.getPaddleXCoordinate()+paddle.getLength()/2);	
			}
		}
	}

	public void moveLeft() {
		if(this.isPlay() && !this.isPaused) {
			if (paddle.getPaddleXCoordinate()>0)
				paddle.setPaddleXCoordinate(paddle.getPaddleXCoordinate()-paddle.getLength()/2);	
		}

	}

	public void rotateRigth() {
		if(this.isPlay() && !this.isPaused) {
			if(paddle.getRotateAngle() < 22.5)
				paddle.setRotateAngle(paddle.getRotateAngle()+10);	
		}
	}

	public void rotateLeft() {
		if(this.isPlay() && !this.isPaused) {
			if(paddle.getRotateAngle() > -22.5) {
				paddle.setRotateAngle(paddle.getRotateAngle()-10);
			}	
		}

	}

	public void rigthAngle() {

		while(paddle.getRotateAngle()!=0)
			paddle.setRotateAngle(paddle.getRotateAngle()-10);
	}

	public void leftAngle() {

		while(paddle.getRotateAngle()!=0) {
			paddle.setRotateAngle(paddle.getRotateAngle()+10);
		}
	}


	public void pauseGame() {
		if(this.play) {
			if(isPaused==false) {
				this.isPaused = true;
			}else {
				this.isPaused=false;
			}
		}
	}

	public void ballIntersectsAlien() {
		for(int j=0;j<getBallIsDrawn().size();j++) {
			for(int i=0;i<aliensDrawn.size();i++) {		
				if(aliensDrawn.get(i) !=null && this.getBallIsDrawn().size()>0 && j < getBallIsDrawn().size() && this.getBallIsDrawn().get(j)!=null) {
					if(aliensDrawn.get(i) instanceof ProtectingAlien) {
						if(this.getLifeAmount()>0 && this.getBallIsDrawn().size()>0) {
							Rectangle rect = new Rectangle(aliensDrawn.get(i).getAlienXCoor(),aliensDrawn.get(i).getAlienYCoor(),50,50);
							Rectangle ballRect = new Rectangle(getBallIsDrawn().get(j).getBallXcoor(),getBallIsDrawn().get(j).getBallYcoor(),17,17);
							Rectangle paRect= rect;
							if(ballRect.intersects(paRect)) {
								if(getBallIsDrawn().get(j).getBallXcoor() + 16 <= paRect.x || getBallIsDrawn().get(j).getBallXcoor() + 1 >= paRect.x + paRect.width) {
									getBallIsDrawn().get(j).setBallXcoor(getBallIsDrawn().get(j).getBallXcoor() + (-1 * getBallIsDrawn().get(j).getBallXdir()));
									getBallIsDrawn().get(j).setBallXcoor(getBallIsDrawn().get(j).getBallXcoor() + (-1 * getBallIsDrawn().get(j).getBallXdir()));
									getBallIsDrawn().get(j).setBallXdir(getBallIsDrawn().get(j).getBallXdir()*-1);
								}else {
									if(getBallIsDrawn().get(j).getBallYcoor() < paRect.y) {
										aliensDrawn.remove(i);
									}
									getBallIsDrawn().get(j).setBallYcoor(getBallIsDrawn().get(j).getBallYcoor() + (-1 * getBallIsDrawn().get(j).getBallYdir()));
									getBallIsDrawn().get(j).setBallYcoor(getBallIsDrawn().get(j).getBallYcoor() + (-1 * getBallIsDrawn().get(j).getBallYdir()));
									getBallIsDrawn().get(j).setBallYdir(getBallIsDrawn().get(j).getBallYdir()*-1);
								}
							}
						}
					}else if(aliensDrawn.get(i) instanceof RepairingAlien) {
						if(this.getLifeAmount()>0 && this.getBallIsDrawn().size()>0) {
							Rectangle rect = new Rectangle(aliensDrawn.get(i).getAlienXCoor(),aliensDrawn.get(i).getAlienYCoor(),50,50);
							Rectangle ballRect = new Rectangle(getBallIsDrawn().get(j).getBallXcoor(),getBallIsDrawn().get(j).getBallYcoor(),17,17);
							Rectangle raRect= rect;
							if(ballRect.intersects(raRect)) {
								aliensDrawn.remove(i);
								if(getBallIsDrawn().get(j).getBallXcoor() + 16 <= raRect.x || getBallIsDrawn().get(j).getBallXcoor() + 1 >= raRect.x + raRect.width) {
									getBallIsDrawn().get(j).setBallXdir(getBallIsDrawn().get(j).getBallXdir()*-1);
								}else {					
									getBallIsDrawn().get(j).setBallYdir(getBallIsDrawn().get(j).getBallYdir()*-1);
								}
							}	
						}
					}else if(aliensDrawn.get(i) instanceof CooperativeAlien) {
						if(this.getLifeAmount()>0 && this.getBallIsDrawn().size()>0) {
							Rectangle rect = new Rectangle(aliensDrawn.get(i).getAlienXCoor(),aliensDrawn.get(i).getAlienYCoor(),50,50);
							Rectangle ballRect = new Rectangle(getBallIsDrawn().get(j).getBallXcoor(),getBallIsDrawn().get(j).getBallYcoor(),17,17);
							Rectangle caRect= rect;
							if(ballRect.intersects(caRect)) {
								aliensDrawn.remove(i);
								this.copAlien=false;
								if(getBallIsDrawn().get(j).getBallXcoor() + 16 <= caRect.x || getBallIsDrawn().get(j).getBallXcoor() + 1 >= caRect.x + caRect.width) {
									getBallIsDrawn().get(j).setBallXdir(getBallIsDrawn().get(j).getBallXdir()*-1);
								}else {					
									getBallIsDrawn().get(j).setBallYdir(getBallIsDrawn().get(j).getBallYdir()*-1);
								}
							}
						}
					}else if(aliensDrawn.get(i) instanceof DrunkAlien) {
						if(this.getLifeAmount()>0 && this.getBallIsDrawn().size()>0) {
							Rectangle rect = new Rectangle(aliensDrawn.get(i).getAlienXCoor(),aliensDrawn.get(i).getAlienYCoor(),50,50);
							Rectangle ballRect = new Rectangle(getBallIsDrawn().get(j).getBallXcoor(),getBallIsDrawn().get(j).getBallYcoor(),17,17);
							Rectangle raRect= rect;
							if(ballRect.intersects(raRect)) {
								aliensDrawn.remove(i);
								if(getBallIsDrawn().get(j).getBallXcoor() + 16 <= raRect.x || getBallIsDrawn().get(j).getBallXcoor() + 1 >= raRect.x + raRect.width) {
									getBallIsDrawn().get(j).setBallXdir(getBallIsDrawn().get(j).getBallXdir()*-1);
								}else {					
									getBallIsDrawn().get(j).setBallYdir(getBallIsDrawn().get(j).getBallYdir()*-1);
								}
							}	
						}
					}
				}
			}	
		}
	}
	public void ballIntersectsBrick(ArrayList<Brick> bricks,int passedT) {
		if(this.getLifeAmount()>0) {
			for(int j=0;j<getBallIsDrawn().size();j++) {
				for(int i=0;i<bricks.size();i++) {		
					if(bricks.get(i)!=null && this.getBallIsDrawn().size()>0 && j < getBallIsDrawn().size() && this.getBallIsDrawn().get(j)!=null) {
						if(bricks.get(i) instanceof SimpleBrick) {
							if(this.getLifeAmount()>0 && this.getBallIsDrawn().size()>0) {
								Rectangle rect = new Rectangle(bricks.get(i).getBrickXCoor(),bricks.get(i).getBrickYCoor(),70,30);
								Rectangle ballRect = new Rectangle(getBallIsDrawn().get(j).getBallXcoor(),getBallIsDrawn().get(j).getBallYcoor(),17,17);
								Rectangle simpleBrickRect= rect;
								if(ballRect.intersects(simpleBrickRect)) {
									if(getBallIsDrawn().get(j).isChemical()) {
										setScore(this.getScore()+(300/passedT));
										bricks.remove(i);
									}else if(getBallIsDrawn().get(j).isFire()){
										setScore(this.getScore()+(300/passedT));
										int brickCenterX = bricks.get(i).getBrickXCoor()+35;
										int brickCenterY = bricks.get(i).getBrickYCoor()+15;
										Rectangle boomRect = new Rectangle (brickCenterX-64,brickCenterY - 64,100,100);
										for(int r=0;r<bricks.size();r++) {
											Rectangle temp = new Rectangle(bricks.get(r).getBrickXCoor(),bricks.get(r).getBrickYCoor(),70,30);
											if(temp.intersects(boomRect)) {
												setScore(this.getScore()+(300/passedT));
												bricks.remove(r);
											}
										}
										if(getBallIsDrawn().get(j).getBallXcoor() + 16 <= simpleBrickRect.x || getBallIsDrawn().get(j).getBallXcoor() + 1 >= simpleBrickRect.x + simpleBrickRect.width) {
											getBallIsDrawn().get(j).setBallXdir(getBallIsDrawn().get(j).getBallXdir()*-1);
										}else {
											getBallIsDrawn().get(j).setBallYdir(getBallIsDrawn().get(j).getBallYdir()*-1);
										}
									}else {
										setScore(this.getScore()+(300/passedT));
										bricks.remove(i);
										if(getBallIsDrawn().get(j).getBallXcoor() + 16 <= simpleBrickRect.x || getBallIsDrawn().get(j).getBallXcoor() + 1 >= simpleBrickRect.x + simpleBrickRect.width) {
											getBallIsDrawn().get(j).setBallXdir(getBallIsDrawn().get(j).getBallXdir()*-1);
										}else {
											getBallIsDrawn().get(j).setBallYdir(getBallIsDrawn().get(j).getBallYdir()*-1);
										}
									}
								}
							}
						}else if(bricks.get(i) instanceof HalfMetalBrick) {	
							if(this.getLifeAmount()>0&& this.getBallIsDrawn().size()>0) {
								Rectangle rect = new Rectangle(bricks.get(i).getBrickXCoor(),bricks.get(i).getBrickYCoor(),70,30);
								Rectangle ballRect = new Rectangle(getBallIsDrawn().get(j).getBallXcoor(),getBallIsDrawn().get(j).getBallYcoor(),17,17);
								Rectangle hmbRect= rect;
								if(ballRect.intersects(hmbRect)) {
									if(getBallIsDrawn().get(j).isChemical()) {
										setScore(this.getScore()+(300/passedT));
										bricks.remove(i);
									}else if(getBallIsDrawn().get(j).isFire()){
										setScore(this.getScore()+10);
										int brickCenterX = bricks.get(i).getBrickXCoor()+35;
										int brickCenterY = bricks.get(i).getBrickYCoor()+15;
										Rectangle boomRect = new Rectangle (brickCenterX-64,brickCenterY - 64,100,100);
										for(int r=0;r<bricks.size();r++) {
											Rectangle temp = new Rectangle(bricks.get(r).getBrickXCoor(),bricks.get(r).getBrickYCoor(),70,30);
											if(temp.intersects(boomRect)) {
												setScore(this.getScore()+(300/passedT));
												bricks.remove(r);
											}
										}
										if(getBallIsDrawn().get(j).getBallXcoor() + 16 <= hmbRect.x || getBallIsDrawn().get(j).getBallXcoor() + 1 >= hmbRect.x + hmbRect.width) {
											getBallIsDrawn().get(j).setBallXdir(getBallIsDrawn().get(j).getBallXdir()*-1);
										}else {
											getBallIsDrawn().get(j).setBallYdir(getBallIsDrawn().get(j).getBallYdir()*-1);
										}
									}else {
										if(getBallIsDrawn().get(j).getBallXcoor() + 16 <= hmbRect.x || getBallIsDrawn().get(j).getBallXcoor() + 1 >= hmbRect.x + hmbRect.width) {
											getBallIsDrawn().get(j).setBallXcoor(getBallIsDrawn().get(j).getBallXcoor() + (-1 * getBallIsDrawn().get(j).getBallXdir()));
											getBallIsDrawn().get(j).setBallXcoor(getBallIsDrawn().get(j).getBallXcoor() + (-1 * getBallIsDrawn().get(j).getBallXdir()));
											getBallIsDrawn().get(j).setBallXdir(getBallIsDrawn().get(j).getBallXdir()*-1);
										}else {
											if(getBallIsDrawn().get(j).getBallYcoor() < hmbRect.y) {
												setScore(this.getScore()+(300/passedT));
												bricks.remove(i);
											}
											getBallIsDrawn().get(j).setBallYcoor(getBallIsDrawn().get(j).getBallYcoor() + (-1 * getBallIsDrawn().get(j).getBallYdir()));
											getBallIsDrawn().get(j).setBallYcoor(getBallIsDrawn().get(j).getBallYcoor() + (-1 * getBallIsDrawn().get(j).getBallYdir()));
											getBallIsDrawn().get(j).setBallYdir(getBallIsDrawn().get(j).getBallYdir()*-1);
										}
									}
								}
							}
						}else if(bricks.get(i) instanceof MineBrick) {
							if(this.getLifeAmount()>0&& this.getBallIsDrawn().size()>0) {
								Rectangle rect = new Rectangle(bricks.get(i).getBrickXCoor(),bricks.get(i).getBrickYCoor(),70,30);
								Rectangle ballRect = new Rectangle(getBallIsDrawn().get(j).getBallXcoor(),getBallIsDrawn().get(j).getBallYcoor(),17,17);
								Rectangle wbRect= rect;
								if(ballRect.intersects(wbRect)) {
									if(getBallIsDrawn().get(j).isChemical()) {
										setScore(this.getScore()+(300/passedT));
										int brickCenterX = bricks.get(i).getBrickXCoor()+35;
										int brickCenterY = bricks.get(i).getBrickYCoor()+15;
										Rectangle boomRect = new Rectangle (brickCenterX-64,brickCenterY - 64,128,128);
										for(int r=0;r<bricks.size();r++) {
											Rectangle temp = new Rectangle(bricks.get(r).getBrickXCoor(),bricks.get(r).getBrickYCoor(),70,30);
											if(temp.intersects(boomRect)) {
												setScore(this.getScore()+(300/passedT));
												bricks.remove(r);
											}
										}
									}else {
										int brickCenterX = bricks.get(i).getBrickXCoor()+35;
										int brickCenterY = bricks.get(i).getBrickYCoor()+15;
										Rectangle boomRect = new Rectangle (brickCenterX-64,brickCenterY - 64,128,128);
										for(int r=0;r<bricks.size();r++) {
											Rectangle temp = new Rectangle(bricks.get(r).getBrickXCoor(),bricks.get(r).getBrickYCoor(),70,30);
											if(temp.intersects(boomRect)) {
												setScore(this.getScore()+(300/passedT));
												bricks.remove(r);
											}
										}
										if(getBallIsDrawn().get(j).getBallXcoor() + 16 <= wbRect.x || getBallIsDrawn().get(j).getBallXcoor() + 1 >= wbRect.x + wbRect.width) {
											getBallIsDrawn().get(j).setBallXdir(getBallIsDrawn().get(j).getBallXdir()*-1);
										}else {
											getBallIsDrawn().get(j).setBallYdir(getBallIsDrawn().get(j).getBallYdir()*-1);
										}
									}
								}
							}
						}else if(bricks.get(i) instanceof WrapperBrick) {
							if(this.getLifeAmount()>0&& this.getBallIsDrawn().size()>0) {
								Rectangle rect = new Rectangle(bricks.get(i).getBrickXCoor(),bricks.get(i).getBrickYCoor(),70,30);
								Rectangle ballRect = new Rectangle(getBallIsDrawn().get(j).getBallXcoor(),getBallIsDrawn().get(j).getBallYcoor(),17,17);
								Rectangle mbRect= rect;
								if(ballRect.intersects(mbRect)) {
									if(getBallIsDrawn().get(j).isChemical()) {
										setScore(this.getScore()+(300/passedT));
										int randomNumber = rgen.nextInt(10);
										int x = bricks.get(i).getBrickXCoor();
										int y = bricks.get(i).getBrickYCoor();
										sendAlienOrPowerUp(randomNumber,x,y);
										bricks.remove(i);
									}else if(getBallIsDrawn().get(j).isFire()){
										int randomNumber = rgen.nextInt(10);
										int x = bricks.get(i).getBrickXCoor();
										int y = bricks.get(i).getBrickYCoor();
										sendAlienOrPowerUp(randomNumber,x,y);
										int brickCenterX = bricks.get(i).getBrickXCoor()+35;
										int brickCenterY = bricks.get(i).getBrickYCoor()+15;
										Rectangle boomRect = new Rectangle (brickCenterX-64,brickCenterY - 64,100,100);
										for(int r=0;r<bricks.size();r++) {
											Rectangle temp = new Rectangle(bricks.get(r).getBrickXCoor(),bricks.get(r).getBrickYCoor(),70,30);
											if(temp.intersects(boomRect)) {
												setScore(this.getScore()+(300/passedT));
												bricks.remove(r);
											}
										}
										if(getBallIsDrawn().get(j).getBallXcoor() + 16 <= mbRect.x || getBallIsDrawn().get(j).getBallXcoor() + 1 >= mbRect.x + mbRect.width) {
											getBallIsDrawn().get(j).setBallXdir(getBallIsDrawn().get(j).getBallXdir()*-1);
										}else {
											getBallIsDrawn().get(j).setBallYdir(getBallIsDrawn().get(j).getBallYdir()*-1);
										}
										setScore(this.getScore()+(300/passedT));
									}else {
										int randomNumber = rgen.nextInt(10);
										int x = bricks.get(i).getBrickXCoor();
										int y = bricks.get(i).getBrickYCoor();
										sendAlienOrPowerUp(randomNumber,x,y);
										bricks.remove(i);
										if(getBallIsDrawn().get(j).getBallXcoor() + 16 <= mbRect.x || getBallIsDrawn().get(j).getBallXcoor() + 1 >= mbRect.x + mbRect.width) {
											getBallIsDrawn().get(j).setBallXdir(getBallIsDrawn().get(j).getBallXdir()*-1);
										}else {
											getBallIsDrawn().get(j).setBallYdir(getBallIsDrawn().get(j).getBallYdir()*-1);
										}
										setScore(this.getScore()+(300/passedT));
									}
								}
							}
						}
					}
				}	
			}
		}
	}
	public void throwBalls() {
		if(this.play) {
			if(this.ballsNotThrown==true) {
				this.ballsNotThrown = false;
				getBallIsDrawn().get(0).setBallXdir(-1);
				getBallIsDrawn().get(0).setBallYdir(-2);	
			}
			for(int i=0;i<stuckBalls.size();i++) {
				stuckBalls.get(i).setBallXdir(-1);
				stuckBalls.get(i).setBallYdir(-2);
				stuckBalls.remove(i);
			}
		}
	}

	public void ballMovement() {
		if(this.getBallIsDrawn().size()==0 && this.play) {
			this.setLifeAmount(this.getLifeAmount()-1);
		}
		if(this.getLifeAmount()>0 && getBallIsDrawn().size()==0 && this.play) {
			createFirstBall();
			this.ballsNotThrown=true;
		}
		if(getBallIsDrawn().size()>0) {
			for(int i = 0;i<getBallIsDrawn().size();i++) {
				if(isBallNotThrown()) {
					getBallIsDrawn().get(i).setBallXdir(0);
					getBallIsDrawn().get(i).setBallYdir(0);
					getBallIsDrawn().get(i).setBallXcoor(getPaddle().getPaddleXCoordinate()+getPaddle().getLength()/2);
					getBallIsDrawn().get(i).setBallYcoor(getPaddle().getPaddleYCoordinate()-17);
				}else {
					if(stuckBalls.size()>0) {
						for(int q = 0;q<stuckBalls.size();q++) {
							stuckBalls.get(q).setBallXdir(0);
							stuckBalls.get(q).setBallYdir(0);
							stuckBalls.get(q).setBallXcoor(getPaddle().getPaddleXCoordinate()+getPaddle().getLength()/2);
							stuckBalls.get(q).setBallYcoor(getPaddle().getPaddleYCoordinate()-17);
						}
					}
					getBallIsDrawn().get(i).setBallXcoor(getBallIsDrawn().get(i).getBallXcoor()+getBallIsDrawn().get(i).getBallXdir());
					getBallIsDrawn().get(i).setBallYcoor(getBallIsDrawn().get(i).getBallYcoor()+getBallIsDrawn().get(i).getBallYdir());
					if(getBallIsDrawn().get(i).getBallXcoor()<0) {
						getBallIsDrawn().get(i).setBallXdir(getBallIsDrawn().get(i).getBallXdir()*-1);
					}
					if(getBallIsDrawn().get(i).getBallYcoor()<0) {
						getBallIsDrawn().get(i).setBallYdir(getBallIsDrawn().get(i).getBallYdir()*-1);
					}
					if(getBallIsDrawn().get(i).getBallXcoor() > 1270) {
						getBallIsDrawn().get(i).setBallXdir(getBallIsDrawn().get(i).getBallXdir()*-1);
					}
					Rectangle paddlerect = new Rectangle(getPaddle().getPaddleXCoordinate(),getPaddle().getPaddleYCoordinate(),getPaddle().getLength(),20);
					Rectangle ballRect = new Rectangle(getBallIsDrawn().get(i).getBallXcoor(),getBallIsDrawn().get(i).getBallYcoor(),17,17);
					Rectangle hitbox= paddlerect;
					if(hitbox.intersects(ballRect)) {
						if(isMagnetActive()) {
							stuckBalls.add(getBallIsDrawn().get(i));
						}else {
							if(getBallIsDrawn().get(i).getBallXcoor() + 16 <= getPaddle().getPaddleXCoordinate() || getBallIsDrawn().get(i).getBallXcoor() + 1 >= getPaddle().getPaddleXCoordinate() + getPaddle().getLength()) {
								getBallIsDrawn().get(i).setBallXdir(getBallIsDrawn().get(i).getBallXdir()*-1);
							}else {
								getBallIsDrawn().get(i).setBallYdir(getBallIsDrawn().get(i).getBallYdir()*-1);
							}
						}
					}
					if(getBallIsDrawn().get(i).getBallYcoor()>720) {
						getBallIsDrawn().remove(i);
					}
				}
			}
		}
	}
	public void sendAlienOrPowerUp(int x,int brickXC, int brickYC) {
		if(x==0) {
			int spawnX = rgen.nextInt(1230);
			int spawnY = rgen.nextInt(400);
			createPA(spawnX,spawnY);
		}
		if(x==1) {
			createTallerPaddlePow(brickXC+35,brickYC+15);
		}
		if(x==2) {
			createMagnet(brickXC+35,brickYC+15);
		}
		if(x==3) {
			createDLGPU(brickXC+35,brickYC+15);
		}
		if(x==4) {
			createCBPU(brickXC+35,brickYC+15);
		}
		if(x==5) {
			createGOBPU(brickXC+35,brickYC+15);
		}
		if(x==6) {
			createFBPU(brickXC+35,brickYC+15);
		}
		if(x==7) {
			int spawnX = rgen.nextInt(1230);
			int spawnY = rgen.nextInt(400);
			createRA(spawnX,spawnY);
		}
		if(x==8) {
			int spawnX = rgen.nextInt(1230);
			int spawnY = rgen.nextInt(400);
			if(this.copAlien) {
				createCOPA(spawnX,spawnY);
			}else {
				createPA(spawnX,spawnY);	
			}
		}
		if(x==9) {
			int spawnX = rgen.nextInt(1230);
			int spawnY = rgen.nextInt(400);
			createDA(spawnX,spawnY);
		}
	}
	public void createPA(int x, int y) {
		ProtectingAlien pa = (ProtectingAlien) AlienFactory.getAlien("ProtectingAlien");
		pa.setAlienXCoor(x);
		pa.setAlienYCoor(y);
		pa.setDirection(1);
		this.aliensDrawn.add(pa);
	}
	public void createRA(int x,int y) {
		RepairingAlien ra = (RepairingAlien) AlienFactory.getAlien("RepairingAlien");
		ra.setAlienXCoor(x);
		ra.setAlienYCoor(y);
		this.aliensDrawn.add(ra);
	}
	public void createCOPA(int x, int y) {
		CooperativeAlien ca = (CooperativeAlien) AlienFactory.getAlien("CooperativeAlien");
		ca.setAlienXCoor(x);
		ca.setAlienYCoor(y);
		this.aliensDrawn.add(ca);
	}
	public void createDA(int x,int y) {
		DrunkAlien da = (DrunkAlien) AlienFactory.getAlien("DrunkAlien");
		da.setAlienXCoor(x);
		da.setAlienYCoor(y);
		da.setDirection(1);
		this.aliensDrawn.add(da);
	}

	public void actAliens() {
		for(int i=0;i<aliensDrawn.size();i++) {
			if(aliensDrawn.get(i) instanceof ProtectingAlien) {
				if(aliensDrawn.get(i).getAlienXCoor() > 1230) {
					aliensDrawn.get(i).setDirection(-1);
				}
				if(aliensDrawn.get(i).getAlienXCoor() < 0) {
					aliensDrawn.get(i).setDirection(1);
				}
				aliensDrawn.get(i).doAction();
			}
		}
	}
	public void repairingAlienAction(ArrayList<Brick> bricks) {
		for(int i=0;i<aliensDrawn.size();i++) {
			if(aliensDrawn.get(i) instanceof RepairingAlien) {
				int x = rgen.nextInt(1160);
				int y = rgen.nextInt(500);
				aliensDrawn.get(i).setAlienXCoor(x);
				aliensDrawn.get(i).setAlienYCoor(y);
				bricks.add(new SimpleBrick(x+50,y));
			}
		}
	}
	public void cooperativeAlienAction(ArrayList<Brick> bricks) {
		for(int i=0;i<aliensDrawn.size();i++) {
			if(aliensDrawn.get(i) instanceof CooperativeAlien) {
				int location = rgen.nextInt(bricks.size());
				aliensDrawn.get(i).setAlienXCoor(bricks.get(location).getBrickXCoor()+20);
				aliensDrawn.get(i).setAlienYCoor(bricks.get(location).getBrickYCoor());
				Rectangle destroyedArea = new Rectangle(0,aliensDrawn.get(i).getAlienYCoor(),1280,50);
				for(int r =0 ;r<bricks.size();r++) {
					Rectangle brickRect = new Rectangle(bricks.get(r).getBrickXCoor(),bricks.get(r).getBrickYCoor(),70,30);
					if(destroyedArea.intersects(brickRect)) {
						bricks.remove(r);
					}
				}
			}
		}
		
	}
	public void drunkAlienProtectingAction() {
		for(int i=0;i<aliensDrawn.size();i++) {
			if(aliensDrawn.get(i) instanceof DrunkAlien) {
					if(aliensDrawn.get(i).getAlienXCoor() > 1230) {
						aliensDrawn.get(i).setDirection(-1);
					}
					if(aliensDrawn.get(i).getAlienXCoor() < 0) {
						aliensDrawn.get(i).setDirection(1);
					}
						aliensDrawn.get(i).doAction();
			}
		}
	}
	public void drunkAlienRepairingAction(ArrayList<Brick>bricks) {
		for(int i=0;i<aliensDrawn.size();i++) {
			if(aliensDrawn.get(i) instanceof DrunkAlien) {
				int x = rgen.nextInt(1160);
				int y = rgen.nextInt(500);
				aliensDrawn.get(i).setAlienXCoor(x);
				aliensDrawn.get(i).setAlienYCoor(y);
				bricks.add(new SimpleBrick(x+50,y));
			}
		}
	}
	public void drunkAlienCooperativeAction(ArrayList<Brick> bricks) {
		for(int i=0;i<aliensDrawn.size();i++) {
			if(aliensDrawn.get(i) instanceof DrunkAlien) {
				int location = rgen.nextInt(bricks.size());
				aliensDrawn.get(i).setAlienXCoor(bricks.get(location).getBrickXCoor()+20);
				aliensDrawn.get(i).setAlienYCoor(bricks.get(location).getBrickYCoor());
				Rectangle destroyedArea = new Rectangle(0,aliensDrawn.get(i).getAlienYCoor(),1280,50);
				for(int r =0 ;r<bricks.size();r++) {
					Rectangle brickRect = new Rectangle(bricks.get(r).getBrickXCoor(),bricks.get(r).getBrickYCoor(),70,30);
					if(destroyedArea.intersects(brickRect)) {
						bricks.remove(r);
					}
				}
			}
		}
	}
	public void drunkAlienSpecialAction(ArrayList<Brick> bricks,boolean builded) {
		for(int i=0;i<aliensDrawn.size();i++) {
			if(aliensDrawn.get(i) instanceof DrunkAlien) {
				if(!builded) {
					int x = rgen.nextInt(1160);
					int y = rgen.nextInt(500);
					aliensDrawn.get(i).setAlienXCoor(x);
					aliensDrawn.get(i).setAlienYCoor(y);
					for(int q=0;q<16;q++) {
						SimpleBrick sb = new SimpleBrick((80*q),y);
						bricks.add(sb);
					}
				}
				if(builded) {
					if(aliensDrawn.get(i).getAlienXCoor() > 1230) {
						aliensDrawn.get(i).setDirection(-1);
					}
					if(aliensDrawn.get(i).getAlienXCoor() < 0) {
						aliensDrawn.get(i).setDirection(1);
					}
						aliensDrawn.get(i).doAction();
				}
			}
		}
	}
	public void setDrunkAlienBehaviour(ArrayList<Brick> bricks) {
		for(int i=0;i<aliensDrawn.size();i++) {
			if(aliensDrawn.get(i) instanceof DrunkAlien) {
				double remainingBricks = bricks.size();
				double dbr = 1 - (remainingBricks/initBa);
				if(dbr < 0.3) {
					((DrunkAlien) aliensDrawn.get(i)).setBehaviour("c");
				}
				if(dbr > 0.3 && dbr < 0.4) {
					((DrunkAlien) aliensDrawn.get(i)).setBehaviour("i");
				}
				if(dbr > 0.4 && dbr < 0.5) {
					((DrunkAlien) aliensDrawn.get(i)).setBehaviour("r");
				}
				if(dbr > 0.5 && dbr < 0.6) {
					((DrunkAlien) aliensDrawn.get(i)).setBehaviour("p");
				}
				if(dbr > 0.6 && dbr < 0.7) {
					((DrunkAlien) aliensDrawn.get(i)).setBehaviour("i");
				}
				if(dbr > 0.7) {
					((DrunkAlien) aliensDrawn.get(i)).setBehaviour("s");
				}
			}
		}
	}
	public String getDrunkAlienBehaviour() {
		for(int i=0;i<aliensDrawn.size();i++) {
			if(aliensDrawn.get(i) instanceof DrunkAlien) {
				String behaviour = (String)((DrunkAlien) aliensDrawn.get(i)).getBehaviour();
				return behaviour;
			}
		}
		return null;
	}

	public void dropPowerUps() {
		for(int i=0;i<powerUpsDrawn.size();i++) {
			powerUpsDrawn.get(i).drop();
			if(powerUpsDrawn.get(i).getpXCoor()>1000) {
				powerUpsDrawn.remove(i);
			}
		}
	}

	public void paddleIntersectsPowerUp() {
		for(int i=0;i<powerUpsDrawn.size();i++) {
			Rectangle rect = new Rectangle(powerUpsDrawn.get(i).getpXCoor(),powerUpsDrawn.get(i).getpYCoor(),30,30);
			Rectangle paddleRect = new Rectangle(paddle.getPaddleXCoordinate(),paddle.getPaddleYCoordinate(),paddle.getLength(),20);
			if(paddleRect.intersects(rect)) {
				if(powerUpsDrawn.get(i) instanceof TallerPaddle) {
					player.setTallp(player.getTallp()+1);
					powerUpsDrawn.remove(i);
				}
				else if(powerUpsDrawn.get(i) instanceof Magnet) {
					player.setMagnet(player.getMagnet()+1);
					powerUpsDrawn.remove(i);
				}
				else if(powerUpsDrawn.get(i) instanceof ChemicalBall) {
					player.setChemball(player.getChemball()+1);
					powerUpsDrawn.remove(i);
				}
				else if(powerUpsDrawn.get(i) instanceof DLG) {
					player.setDlg(player.getDlg()+5);
					paddle.setArmed(true);
					powerUpsDrawn.remove(i);
				}
				else if(powerUpsDrawn.get(i) instanceof GangOfBalls) {
					player.setGob(player.getGob()+1);
					powerUpsDrawn.remove(i);
				}
				else if(powerUpsDrawn.get(i) instanceof FireBall) {
					player.setFireball(player.getFireball()+1);
					powerUpsDrawn.remove(i);
				}
			}
		}
	}
	public void DLGIntersectsBrick(Paddle p, ArrayList<Brick> bricks) {
		for(int i=0;i<bricks.size();i++) {
			Rectangle brickRect = new Rectangle(bricks.get(i).getBrickXCoor(),bricks.get(i).getBrickYCoor(),70,30);
			Rectangle rightBullet = new Rectangle(p.getPaddleXCoordinate() + p.getLength() -15,0,15,680);//paddle
			Rectangle leftBullet = new Rectangle(p.getPaddleXCoordinate(),0,15,680);//paddle
			if(brickRect.intersects(leftBullet) || brickRect.intersects(rightBullet)) {
				bricks.remove(i);
			}
		}
	}
	public void createTallerPaddlePow(int x , int y) {
		TallerPaddle tp = (TallerPaddle) PowerUpFactory.getPowerUp("TallerPaddle");
		tp.setpXCoor(x);
		tp.setpYCoor(y);
		this.powerUpsDrawn.add(tp);
	}
	public void createMagnet(int x , int y) {
		Magnet m = (Magnet) PowerUpFactory.getPowerUp("Magnet");
		m.setpXCoor(x);
		m.setpYCoor(y);
		this.powerUpsDrawn.add(m);
	}
	public void createCBPU(int x , int y) {
		ChemicalBall temp = (ChemicalBall) PowerUpFactory.getPowerUp("ChemicalBall");
		temp.setpXCoor(x);
		temp.setpYCoor(y);
		this.powerUpsDrawn.add(temp);
	}
	public void createDLGPU(int x , int y) {
		DLG temp = (DLG) PowerUpFactory.getPowerUp("DLG");
		temp.setpXCoor(x);
		temp.setpYCoor(y);
		this.powerUpsDrawn.add(temp);
	}
	public void createGOBPU(int x , int y) {
		GangOfBalls temp = (GangOfBalls) PowerUpFactory.getPowerUp("GangOfBalls");
		temp.setpXCoor(x);
		temp.setpYCoor(y);
		this.powerUpsDrawn.add(temp);
	}
	public void createFBPU(int x , int y) {
		FireBall temp = (FireBall) PowerUpFactory.getPowerUp("FireBall");
		temp.setpXCoor(x);
		temp.setpYCoor(y);
		this.powerUpsDrawn.add(temp);
	}

}
