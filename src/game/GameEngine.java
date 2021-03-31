package game;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Player.Player;
import alien.Alien;
import alien.CooperativeAlien;
import alien.DrunkAlien;
import alien.ProtectingAlien;
import alien.RepairingAlien;
import authentication.Opening;
import ball.Ball;
import brick.Brick;
import brick.HalfMetalBrick;
import brick.MineBrick;
import brick.SimpleBrick;
import brick.WrapperBrick;
import controller.Controller;
import paddle.Paddle;
import powerups.ChemicalBall;
import powerups.DLG;
import powerups.FireBall;
import powerups.GangOfBalls;
import powerups.Magnet;
import powerups.PowerUp;
import powerups.TallerPaddle;

public class GameEngine extends JPanel implements KeyListener, MouseListener, ActionListener {	

	private ImageIcon background = new ImageIcon("src/images/background.jpg");
	private Controller c1 = new Controller();
	private Random rgen = new Random();
	private boolean drunkAlienSpecialBuild = false;

	public GameEngine() {
		super();
		c1.setOpening(new Opening(true));
		while(!c1.getOpening().isReady()) {
			c1.getFrame().setVisible(false);
		}
		c1.createBuildingPanel();
		c1.getSbutton().addActionListener(this);
		c1.getLbutton().addActionListener(this);
		c1.getQbutton().addActionListener(this);
		c1.getRunningModeButton().addActionListener(this);
		c1.getSBButton().addActionListener(this);
		c1.getHMBButton().addActionListener(this);
		c1.getWBButton().addActionListener(this);
		c1.getMBButton().addActionListener(this);
		c1.getMapButton().addActionListener(this);
		c1.getDeleteBButton().addActionListener(this);
		c1.getFrame().add(this);
		c1.callAdjustFrame();
		this.setFocusable(true);
		addKeyListener(this);
		addMouseListener(this);
		this.start();
		while (c1.getRemainingLives()!=0) {
			if(c1.playeable() && c1.getRunPause()) {
				
			}else {
				this.repaint();
				c1.destroyBrick(this.getPassedSeconds());
				c1.destroyAlien();
				c1.takePowerUp();
				c1.controlDLGIntersection();
			}
			if(c1.playeable() && c1.getBricks().size()==0) {
				JOptionPane.showMessageDialog(null,"You win!!");
				c1.getFrame().setVisible(false);
				c1.getFrame().dispose();
				System.exit(0);
			}
		} 
		if(c1.getBalls().size()==0) {
			JOptionPane.showMessageDialog(null,"Computer Wins!!");
			c1.getFrame().setVisible(false);
			c1.getFrame().dispose();
			System.exit(0);
		}
	}


	// TODO Auto-generated method stub
	private int passedSeconds;
	private int tallerPaddleSec;
	private int magnetSec;
	private int chemicalSec;
	private int dlgSec;
	private int repairSec;
	private int cooperativeSec;
	private int drs;
	private int cdas;



	public int getPassedSeconds() {
		return passedSeconds;
	}

	public void setPassedSeconds(int passedSeconds) {
		this.passedSeconds = passedSeconds;
	}

	Timer myTimer = new Timer();
	Timer panelUpdater = new Timer();
	Timer powerUpUpdater = new Timer();
	TimerTask task = new TimerTask() {
		public void run() {	
			if(c1.getRunPause()) {

			}else {
				c1.moveBall();
				c1.simulateAliens();
				c1.callDropPowerUps();
				c1.callDrunkAlienBehaviourSet();
				if(c1.getTheDrunkAlienBehaviours()!=null && c1.getTheDrunkAlienBehaviours().equals("p")) {
					c1.actDrunkAliensProtecting();
				}
				if(c1.getTheDrunkAlienBehaviours()!=null&&c1.getTheDrunkAlienBehaviours().equals("s")) {
					c1.actDrunkAlienSpecial(drunkAlienSpecialBuild);
					drunkAlienSpecialBuild=true;
				}
			}
		}
	};	
	TimerTask task2 = new TimerTask() {
		public void run() {	
			if(c1.playeable()) {
				if(c1.getRunPause()) {
					
				}else {
					passedSeconds++;
					if(c1.getRun().isTpIsActive()) { //TALLERPADDLE USAGE
						tallerPaddleSec++;
						if(tallerPaddleSec==10) {
							c1.getRun().setTpIsActive(false);
							c1.getRun().getPaddle().setLength(200);
							tallerPaddleSec=0;
						}
					}
					if(c1.getRun().isMagnetActive()) { //MAGNET USAGE 
						magnetSec++;
						if(magnetSec==5) {
							c1.getRun().setMagnetActive(false);
							magnetSec=0;
						}
					}
					if(c1.getRun().isChemicalActive()) { //CHEMİCAL USAGE 
						chemicalSec++;
						if(chemicalSec==10) {
							c1.getRun().setChemicalActive(false);
							c1.getRun().getBallIsDrawn().get(0).setNormal();
							chemicalSec=0;
						}
					}
					if(c1.getRun().isLaserActive()) { //DLG USAGE
						dlgSec++;
						if(dlgSec == 1) {
							c1.getRun().setLaserActive(false);
							dlgSec=0;
						}
					}
					if(repairSec%5 ==0) { //REPAIRINGALIEN REPAIR PATTERN
						c1.actRepairingAliens();
					}
					repairSec++;
					if(cooperativeSec %5 ==0) {
						c1.actCooperativeAliens();
					}
					cooperativeSec++;
					//////////////////////
					if(c1.getTheDrunkAlienBehaviours()!=null&&c1.getTheDrunkAlienBehaviours().equals("r")) {
						if(drs%5 ==0) {
							c1.actDrunkAlienRepairing();
						}

					}
					drs++;
					if(c1.getTheDrunkAlienBehaviours()!=null&&c1.getTheDrunkAlienBehaviours().equals("c")) {
						if(cdas%5==0) {
							c1.actDrunkAlienCooperative();
						}

					}
					cdas++;
					if(c1.getTheDrunkAlienBehaviours()!=null&&c1.getTheDrunkAlienBehaviours().equals("i")) {
						for(int i=0;i<c1.getRun().getAliensDrawn().size();i++) {
							if(c1.getRun().getAliensDrawn().get(i) instanceof DrunkAlien) {
								DrunkAlien temp = (DrunkAlien) c1.getRun().getAliensDrawn().get(i);
								temp.setInconsistentlifeTime(temp.getInconsistentlifeTime()+1);	
								if(temp.getInconsistentlifeTime()==5) {
									c1.getRun().getAliensDrawn().remove(i);
								}
							}
						}
					}
				}
			}
		}
	};	
	TimerTask task3 = new TimerTask() {
		public void run() {	
			if(c1.playeable()) {
				c1.updatePUL();
			}
			if(c1.getRun().getDlgA()==0) {
				c1.getRun().getPaddle().setArmed(false);
			}
		}
	};
	public void start() {
		myTimer.scheduleAtFixedRate(task,1,7);
		powerUpUpdater.scheduleAtFixedRate(task2,10,1000);
		panelUpdater.scheduleAtFixedRate(task3, 10, 100);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//RUNNING MODE SAVE LOAD
		if(e.getSource().equals(c1.getSRbutton())) {
			if(c1.getRunPause()) {
				String localOrMongo = JOptionPane.showInputDialog("Where do you want to save the RunningMode?\n Type l for LocalSave \n Type m for MongoDatabase");
				if(localOrMongo.equals("l")) {
					c1.callSaveRunLocal(c1.getRun().getPlayer().getName());
					JOptionPane.showMessageDialog(null, "RunningMode saved to LocalSave");
				}
				else if(localOrMongo.equals("m")) {
					c1.callSaveRunMongo(c1.getRun().getPlayer().getName());
					c1.callDisplayMongoDatabase();
					JOptionPane.showMessageDialog(null, "RunningMode saved to MongoDatabase");
				}else {
					JOptionPane.showMessageDialog(null, "Undefined key pressed nothing will be happen");
				}
			}
		}
		if(e.getSource().equals(c1.getLRbutton())) {
			if(c1.playeable()) {
				String localOrMongo = JOptionPane.showInputDialog("Where do you want to load the RunningMode?\n Type l for LocalSave \n Type m for MongoDatabase");
				if(localOrMongo.equals("l")) {
					ArrayList<Ball> tempballs = c1.loadedRunningBallsLocal(c1.getRun().getPlayer().getName());
					ArrayList<Brick> tempbricks = c1.loadedRunningBricksLocal(c1.getRun().getPlayer().getName());
					ArrayList<PowerUp> temppowups = c1.loadedRunningPowerUpsLocal(c1.getRun().getPlayer().getName());
					ArrayList<Alien> tempaliens = c1.loadedRunningAliensLocal(c1.getRun().getPlayer().getName());
					Player tempplayer= c1.loadedRunningPlayerLocal(c1.getRun().getPlayer().getName());
					Paddle temppaddle = c1.loadedRunningPaddleLocal(c1.getRun().getPlayer().getName());
					c1.getRun().setPlayer(tempplayer);
					c1.getRun().setBallIsDrawn(tempballs);
					c1.getRun().setAliensDrawn(tempaliens);
					c1.getRun().setPowerUpsDrawn(temppowups);
					c1.getMap().setBricksDrawed(tempbricks);
					c1.getRun().setPaddle(temppaddle);
					for(int i = 0;i< tempballs.size();i++) {
						if(tempballs.get(i).getBallYcoor()>650) {
							c1.getRun().setBallNotThrown(true);
						}else {
							c1.getRun().setBallNotThrown(false);
						}
					}
					JOptionPane.showMessageDialog(null, "RunningMode loaded from LocalSave");
				}
				else if(localOrMongo.equals("m")) {
					ArrayList<Ball> tempballs = c1.loadedRunningBallsMongo(c1.getRun().getPlayer().getName());
					ArrayList<Brick> tempbricks = c1.loadedRunningBricksMongo(c1.getRun().getPlayer().getName());
					ArrayList<PowerUp> temppowups = c1.loadedRunningPowerUpsMongo(c1.getRun().getPlayer().getName());
					ArrayList<Alien> tempaliens = c1.loadedRunningAliensMongo(c1.getRun().getPlayer().getName());
					Player tempplayer= c1.loadedRunningPlayerMongo(c1.getRun().getPlayer().getName());
					Paddle temppaddle = c1.loadedRunningPaddleMongo(c1.getRun().getPlayer().getName());
					c1.getRun().setPlayer(tempplayer);
					c1.getRun().setBallIsDrawn(tempballs);
					c1.getRun().setAliensDrawn(tempaliens);
					c1.getRun().setPowerUpsDrawn(temppowups);
					c1.getMap().setBricksDrawed(tempbricks);
					c1.getRun().setPaddle(temppaddle);
					for(int i = 0;i< tempballs.size();i++) {
						if(tempballs.get(i).getBallYcoor()>650) {
							c1.getRun().setBallNotThrown(true);
						}else {
							c1.getRun().setBallNotThrown(false);
						}
					}
					JOptionPane.showMessageDialog(null, "RunningMode loaded from MongoDatabase");
				}else {
					JOptionPane.showMessageDialog(null, "Undefined key pressed nothing will be happen");
				}
			}
		}
		if(e.getSource().equals(c1.getQbutton()) || e.getSource().equals(c1.getQRbutton())) {
			c1.getPause();
			c1.quit();
		}
		if(e.getSource().equals(c1.getPRbutton())) {
			c1.getPauseOutput();
			c1.getPause();
		}
		if(e.getSource().equals(c1.getRunningModeButton())) {
			c1.getSRbutton().addActionListener(this);
			c1.getLRbutton().addActionListener(this);
			c1.getPRbutton().addActionListener(this);
			c1.getQRbutton() .addActionListener(this);
			c1.setInitialBrickAmount(c1.getMap().getBricksDrawed().size());//initial amount is set for DrunkAlien
			c1.startRunningMode();
			c1.setThePLayer(c1.getThePlayer());
			c1.getThePlayer().setName(c1.getPanel().playerNickName());
		}
		if(e.getSource().equals(c1.getMapButton())) {
			c1.getInit();
		}
		if(e.getSource().equals(c1.getSBButton())) {
			c1.selectSB();
		}
		if(e.getSource().equals(c1.getHMBButton())) {
			c1.selectHMB();
		}
		if(e.getSource().equals(c1.getWBButton())) {
			c1.selectWB();
		}
		if(e.getSource().equals(c1.getMBButton())) {
			c1.selectMB();
		}
		if(e.getSource().equals(c1.getDeleteBButton())) {
			c1.selectDeleteB();
		}
		///////BUILDINGMODE SAVE LOAD
		if(e.getSource().equals(c1.getLbutton())) {	
			String localOrMongo = JOptionPane.showInputDialog("Where do you want to load?\n Type l for LocalSave. \n Type m for MongoDatabase.");
			if(localOrMongo.equals("l")) {
				ArrayList<Brick> temp = c1.loadedBuildingBricksLocal(c1.getPanel().playerNickName());
				c1.getMap().setBricksDrawed(temp);
				JOptionPane.showMessageDialog(null, "BuildingMode loaded from LocalSave.");
			}
			else if(localOrMongo.equals("m")) {
				ArrayList<Brick> temp = c1.loadedBuildingBricksMongo(c1.getPanel().playerNickName());
				c1.getMap().setBricksDrawed(temp);
				c1.callDisplayMongoDatabase();
				JOptionPane.showMessageDialog(null, "BuildingMode loaded from MongoDatabase.");
			}else {
				JOptionPane.showMessageDialog(null, "Undefined key pressed nothing will be happen.");
			}
		}
		if(e.getSource().equals(c1.getSbutton())) {
			String localOrMongo = JOptionPane.showInputDialog("Where do you want to save?\n Type l for LocalSave \n Type m for MongoDatabase");
			if(localOrMongo.equals("l")) {
				c1.callSaveBuildLocal(c1.getPanel().playerNickName());
				JOptionPane.showMessageDialog(null, "BuildingMode saved to LocalSave");
			}
			else if(localOrMongo.equals("m")) {
				c1.callSaveBuildMongo(c1.getPanel().playerNickName());
				c1.callDisplayMongoDatabase();
				JOptionPane.showMessageDialog(null, "BuildingMode saved to MongoDatabase");
			}else {
				JOptionPane.showMessageDialog(null, "Undefined key pressed nothing will be happen");
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub		

		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			c1.getMoveRigth();
		}

		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			c1.getMoveLeft();
		}

		if(e.getKeyCode()==KeyEvent.VK_D) {
			c1.getRotateRigth();
		}

		if(e.getKeyCode()==KeyEvent.VK_A) {
			c1.getRotateLeft();
		}

		if(e.getKeyCode()==KeyEvent.VK_W) {
			c1.getThrowBall();
		}

		if(e.getKeyCode()==KeyEvent.VK_T) {
			if(c1.getRun().getTpPowAmount()>0 && !c1.getRun().isTpIsActive()) {
				c1.getRun().getPaddle().setLength(c1.getRun().getPaddle().getLength()*2);
				c1.getRun().setTpPowAmount(c1.getRun().getTpPowAmount()-1);
				c1.getRun().setTpIsActive(true);
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_M) {
			if(c1.getRun().getMagnetamount()>0 && !c1.getRun().isMagnetActive()) {
				c1.getRun().setMagnetamount(c1.getRun().getMagnetamount()-1);
				c1.getRun().setMagnetActive(true);
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_G) {
			if(c1.getRun().getGangOfBallsA()>0 && !c1.getRun().isMagnetActive()) {
				int location = c1.getRun().getBallIsDrawn().size()-1;
				for(int i=0;i<10;i++) {
					Ball temp = new Ball(c1.getRun().getBallIsDrawn().get(location).getBallXcoor(),
							c1.getRun().getBallIsDrawn().get(location).getBallYcoor(),
							0,
							0,
							c1.getRun().getBallIsDrawn().get(location).getDamage());
					int[] randomDirections = {-2,-1,1,2};
					int randomDirection = rgen.nextInt(4);
					temp.setBallXdir(randomDirections[randomDirection]);
					temp.setBallYdir(randomDirections[randomDirection]);
					Ball added = temp;
					c1.getRun().getBallIsDrawn().add(added);
				}
				c1.getRun().setGangOfBallsA(c1.getRun().getGangOfBallsA()-1);
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_C) {
			if(c1.getRun().getChemicalBA()>0 && !c1.getRun().isChemicalActive()) {
				c1.getRun().setChemicalBA(c1.getRun().getChemicalBA()-1);
				c1.getRun().getBallIsDrawn().get(0).setChemical();
				c1.getRun().setChemicalActive(true);
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_F) {
			if(c1.getRun().getFireballA()>0) {
				c1.getRun().setFireballA(c1.getRun().getFireballA()-1);
				c1.getRun().getBallIsDrawn().get(0).setFire();
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_Q) {
			if(c1.getRun().getDlgA()>0) {
				c1.getRun().setLaserActive(true);
				c1.getRun().setDlgA(c1.getRun().getDlgA()-1);
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_D) {

			c1.getRigthAngle();
		}

		if(e.getKeyCode()==KeyEvent.VK_A) {

			c1.getLeftAngle();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		c1.maintainMap(x, y);
	}


	public void paint(Graphics g) {
		g.drawImage(background.getImage(),0,0,null);
		for(Brick obj : c1.getBricks()) {
			if(obj instanceof SimpleBrick) {
				c1.callDrawSB((SimpleBrick)obj, g);
			}
			else if(obj instanceof HalfMetalBrick) {
				c1.callDrawHMB((HalfMetalBrick)obj, g);
			}
			else if(obj instanceof WrapperBrick) {
				c1.callDrawWB((WrapperBrick)obj, g);
			}
			else{
				c1.callDrawMB((MineBrick) obj, g);
			}
		}
		c1.callDrawP(c1.getPaddleC(),g);
		for(Ball obj : c1.getBalls()) {
			c1.callDrawBall(obj,g);
		}
		for(Alien obj : c1.getAliens()) {
			if(obj instanceof ProtectingAlien) {
				c1.callDrawPA((ProtectingAlien)obj, g);
			}
			else if(obj instanceof CooperativeAlien) {
				c1.callDrawCooperativeAlien((CooperativeAlien)obj, g);
			}
			else if(obj instanceof RepairingAlien) {
				c1.callDrawRepairingAlien((RepairingAlien)obj, g);
			}
			else{
				c1.callDrawDrunkAlien(g, (DrunkAlien)obj);
			}
		}
		for(PowerUp obj : c1.getPowerUps()) {
			if(obj instanceof TallerPaddle) {
				c1.callDrawTallerPaddlePow((TallerPaddle)obj, g);
			}
			else if(obj instanceof Magnet) {
				c1.callDrawMagnet((Magnet)obj, g);
			}
			else if(obj instanceof ChemicalBall) {
				c1.callDrawChemicalP((ChemicalBall)obj, g);
			}
			else if(obj instanceof GangOfBalls) {
				c1.callDrawGOB((GangOfBalls)obj, g);
			}
			else if(obj instanceof DLG) {
				c1.callDrawDLG((DLG)obj, g);
			}
			else{
				c1.callDrawFireBall((FireBall) obj, g);
			}
		}
		if(c1.getRun().isLaserActive()) {
			c1.callDrawLASER(g, c1.getRun().getPaddle());
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}


}
