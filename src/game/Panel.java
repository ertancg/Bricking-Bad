package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import alien.CooperativeAlien;
import alien.DrunkAlien;
import alien.ProtectingAlien;
import alien.RepairingAlien;
import authentication.Opening;
import ball.Ball;
import brick.HalfMetalBrick;
import brick.MineBrick;
import brick.SimpleBrick;
import brick.WrapperBrick;
import paddle.Paddle;
import powerups.ChemicalBall;
import powerups.DLG;
import powerups.FireBall;
import powerups.GangOfBalls;
import powerups.Magnet;
import powerups.TallerPaddle;

public class Panel extends JPanel{

	private JFrame f1 = new JFrame("BrickingBad / Gandhi");
	private Opening o1 = new Opening(false);
	private JButton savebutton = new JButton("Save");
	private JButton loadbutton = new JButton("Load");
	private JButton pausebutton = new JButton("Pause/Resume");
	private JButton quitbutton = new JButton("Quit");
	private JButton goRunningMode = new JButton("Go Run Mode With This Map");
	private JButton saveRbutton = new JButton("Save");
	private JButton loadRbutton = new JButton("Load");
	private JButton pauseRbutton = new JButton("Pause");
	private JButton quitRbutton = new JButton("Quit");
	private JButton simpleBrickSelected = new JButton("SimpleBrick:");
	private JTextField sbamount = new JTextField(2);
	private JButton mineBrickSelected = new JButton("MineBrick:");
	private JTextField mbamount = new JTextField(2);
	private JButton wrapperBrickSelected = new JButton("WrapperBrick:");
	private JTextField wbamount = new JTextField(2);
	private JButton halfMetalBrickSelected = new JButton("HalfMetalBrick:");
	private JTextField hmbamount = new JTextField(2);
	private JButton deleteSelectedBrick = new JButton("DeleteMode");
	private JButton generateMap = new JButton("Generate Random Map With Given Amounts");
	private JPanel controlPanel = new JPanel();
	private JPanel brickControl = new JPanel();
	private JPanel runningControlPanel  = new JPanel();
	private JPanel runningPowerUpPanel = new JPanel();
	private JLabel tallerpaddle = new JLabel("TallerPaddle(T) x 0 // ");
	private JLabel magnet = new JLabel("Magnet(M) x 0 // ");
	private JLabel chemical = new JLabel("ChemicalBall(C) x 0 // ");
	private JLabel fireball = new JLabel("FireBall(F) x 0 // ");
	private JLabel gangofballs = new JLabel("GangOfBalls(G) x 0 // ");
	private JLabel dlg = new JLabel("DLG(Q) x 0 // ");
	private JLabel score = new JLabel("Score: 0 //");
	private JLabel noOfLives = new JLabel("No of Lives: 0 ");

	public void drawBall(Ball b,Graphics g) {
		if(b.isNormal()) {
			g.setColor(Color.YELLOW);
			g.fillOval(b.getBallXcoor(), b.getBallYcoor(), Ball.getDiameter(), Ball.getDiameter());
		}
		if(b.isChemical()) {
			g.setColor(Color.GREEN);
			g.fillOval(b.getBallXcoor(), b.getBallYcoor(), Ball.getDiameter(), Ball.getDiameter());
		}
		if(b.isFire()) {
			g.setColor(Color.RED);
			g.fillOval(b.getBallXcoor(), b.getBallYcoor(), Ball.getDiameter(), Ball.getDiameter());
		}
	}
	
	public void drawPaddle(Paddle p,Graphics g) {
		if(p.isArmed()) {
			Graphics2D gg = (Graphics2D) g.create();
			AffineTransform transform = new AffineTransform();
			transform.rotate(Math.toRadians(p.getRotateAngle()), p.getPaddleXCoordinate() + p.getLength()/2, p.getPaddleYCoordinate() + 10);
			Rectangle paddle = new Rectangle(p.getPaddleXCoordinate(),p.getPaddleYCoordinate(),p.getLength(),20);
			Shape transformed = transform.createTransformedShape(paddle);
			gg.setColor(Color.MAGENTA);
			gg.fill(transformed);
			gg.dispose();
		}
		if(!p.isArmed()) {
			Graphics2D gg = (Graphics2D) g.create();
			AffineTransform transform = new AffineTransform();
			transform.rotate(Math.toRadians(p.getRotateAngle()), p.getPaddleXCoordinate() + p.getLength()/2, p.getPaddleYCoordinate() + 10);
			Rectangle paddle = new Rectangle(p.getPaddleXCoordinate(),p.getPaddleYCoordinate(),p.getLength(),20);
			Shape transformed = transform.createTransformedShape(paddle);
			gg.setColor(Color.RED);
			gg.fill(transformed);
			gg.dispose();
		}
	}
	public void drawSimpleBrick(SimpleBrick sb, Graphics g) {
		g.drawImage(sb.getI().getImage(),sb.getBrickXCoor(),sb.getBrickYCoor(),null);
	}
	public void drawHalfMetalBrick(HalfMetalBrick hmb,Graphics g) {
		g.drawImage(hmb.getI().getImage(),hmb.getBrickXCoor(),hmb.getBrickYCoor(),null);
	}
	public void drawWrapperBrick(WrapperBrick wb,Graphics g) {
		g.drawImage(wb.getI1().getImage(),wb.getBrickXCoor(),wb.getBrickYCoor(),null);
	}
	public void drawMineBrick(MineBrick mb,Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(mb.getBrickXCoor(), mb.getBrickYCoor(), 70, 30);
	}
	public void drawProtectingAlien(ProtectingAlien pa,Graphics g) {
		g.drawImage(pa.getI().getImage(),pa.getAlienXCoor(),pa.getAlienYCoor(),null);
	}
	public void drawRepairingAlien(RepairingAlien rp,Graphics g) {
		g.drawImage(rp.getI().getImage(),rp.getAlienXCoor(),rp.getAlienYCoor(),null);
	}
	public void drawCooperativeAlien(CooperativeAlien ca,Graphics g) {
		g.drawImage(ca.getI().getImage(),ca.getAlienXCoor(),ca.getAlienYCoor(),null);
	}
	public void drawDrunkAlien(DrunkAlien da, Graphics g) {
		g.drawImage(da.getI().getImage(),da.getAlienXCoor(),da.getAlienYCoor(),null);
	}
	public void drawTallerPaddlePow(TallerPaddle tp,Graphics g) {
		g.drawImage(tp.getI().getImage(),tp.getpXCoor(),tp.getpYCoor(),null);
	}
	public void drawMagnet(Magnet m,Graphics g) {
		g.drawImage(m.getI().getImage(),m.getpXCoor(),m.getpYCoor(),null);
	}
	public void drawChemicalP(ChemicalBall c,Graphics g) {
		g.drawImage(c.getI().getImage(),c.getpXCoor(),c.getpYCoor(),null);
	}
	public void drawDLG(DLG d,Graphics g) {
		g.drawImage(d.getI().getImage(),d.getpXCoor(),d.getpYCoor(),null);
	}
	public void drawGOB(GangOfBalls gang,Graphics g) {
		g.drawImage(gang.getI().getImage(),gang.getpXCoor(),gang.getpYCoor(),null);
	}
	public void drawFireBall(FireBall f,Graphics g) {
		g.drawImage(f.getI().getImage(),f.getpXCoor(),f.getpYCoor(),null);
	}
	public void drawRightLaser(Paddle p,Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(p.getPaddleXCoordinate()+p.getLength()-15, 0,15,680);
	}
	public void drawLeftLaser(Paddle p,Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(p.getPaddleXCoordinate(),0,15,680);
	}
	public void goRunningMode(boolean playeable) {
		if(!playeable) {
			f1.remove(brickControl);
			f1.remove(controlPanel);
			addRunningPanels();
			f1.add(runningControlPanel,BorderLayout.NORTH);
			f1.add(runningPowerUpPanel, BorderLayout.SOUTH);
			f1.validate();	
		}
	}
	
	public void quitGame() {
		JOptionPane.showMessageDialog(null,"See You Later :)");
		f1.setVisible(false);
		f1.dispose();
		System.exit(0);
	}
	
	public void adjustFrame() {
		f1.setSize (1280,900);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);	
		f1.setResizable(false);
	}
	
	public void pauseOutput() {
		System.out.println("PLayer is: " + getO1().getPlayer().getName());
	}
	public String playerNickName() {
		return getO1().getPlayer().getName();
	}

	public void addBuildingPanels() {
		controlPanel.add(loadbutton);
		controlPanel.add(savebutton);
		controlPanel.add(quitbutton);
		controlPanel.add(goRunningMode);
		controlPanel.setBackground(Color.DARK_GRAY);
		quitbutton.setFocusable(false);
		savebutton.setFocusable(false);
		loadbutton.setFocusable(false);
		goRunningMode.setFocusable(false);
		brickControl.add(simpleBrickSelected);
		brickControl.add(sbamount);
		brickControl.add(halfMetalBrickSelected);
		brickControl.add(hmbamount);
		brickControl.add(wrapperBrickSelected);
		brickControl.add(wbamount);
		brickControl.add(mineBrickSelected);
		brickControl.add(mbamount);
		brickControl.add(deleteSelectedBrick);
		brickControl.add(generateMap);
		brickControl.setBackground(Color.DARK_GRAY);
		simpleBrickSelected.setFocusable(false);
		halfMetalBrickSelected.setFocusable(false);
		wrapperBrickSelected.setFocusable(false);
		mineBrickSelected.setFocusable(false);
		deleteSelectedBrick.setFocusable(false);
		generateMap.setFocusable(false);
		f1.add(brickControl,BorderLayout.SOUTH);
		f1.add(controlPanel,BorderLayout.NORTH);
	}
	
	public void addRunningPanels() {
		runningControlPanel.add(saveRbutton);
		runningControlPanel.add(loadRbutton);
		runningControlPanel.add(pauseRbutton);
		runningControlPanel.add(quitRbutton);
		runningControlPanel.setBackground(Color.DARK_GRAY);
		saveRbutton.setFocusable(false);
		loadRbutton.setFocusable(false);
		pauseRbutton.setFocusable(false);
		quitRbutton.setFocusable(false);
		tallerpaddle.setForeground(Color.WHITE);
		runningPowerUpPanel.add(tallerpaddle);
		magnet.setForeground(Color.WHITE);
		runningPowerUpPanel.add(magnet);
		chemical.setForeground(Color.WHITE);
		runningPowerUpPanel.add(chemical);
		fireball.setForeground(Color.WHITE);
		runningPowerUpPanel.add(fireball);
		gangofballs.setForeground(Color.WHITE);
		runningPowerUpPanel.add(gangofballs);
		dlg.setForeground(Color.WHITE);
		runningPowerUpPanel.add(dlg);
		score.setForeground(Color.WHITE);
		runningPowerUpPanel.add(score);
		noOfLives.setForeground(Color.WHITE);
		runningPowerUpPanel.add(noOfLives);
		runningPowerUpPanel.setBackground(Color.DARK_GRAY);

	}

	
	public JButton getSaveRbutton() {
		return saveRbutton;
	}




	public void setSaveRbutton(JButton saveRbutton) {
		this.saveRbutton = saveRbutton;
	}




	public JButton getLoadRbutton() {
		return loadRbutton;
	}




	public void setLoadRbutton(JButton loadRbutton) {
		this.loadRbutton = loadRbutton;
	}




	public JButton getPauseRbutton() {
		return pauseRbutton;
	}




	public void setPauseRbutton(JButton pauseRbutton) {
		this.pauseRbutton = pauseRbutton;
	}




	public JButton getQuitRbutton() {
		return quitRbutton;
	}




	public void setQuitRbutton(JButton quitRbutton) {
		this.quitRbutton = quitRbutton;
	}




	public JButton getSimpleBrickSelected() {
		return simpleBrickSelected;
	}




	public void setSimpleBrickSelected(JButton simpleBrickSelected) {
		this.simpleBrickSelected = simpleBrickSelected;
	}




	public String getSbamount() {
		return sbamount.getText();
	}




	public void setSbamount(JTextField sbamount) {
		this.sbamount = sbamount;
	}




	public JButton getMineBrickSelected() {
		return mineBrickSelected;
	}




	public void setMineBrickSelected(JButton mineBrickSelected) {
		this.mineBrickSelected = mineBrickSelected;
	}




	public String getMbamount() {
		return mbamount.getText();
	}




	public void setMbamount(JTextField mbamount) {
		this.mbamount = mbamount;
	}




	public JButton getWrapperBrickSelected() {
		return wrapperBrickSelected;
	}




	public void setWrapperBrickSelected(JButton wrapperBrickSelected) {
		this.wrapperBrickSelected = wrapperBrickSelected;
	}




	public String getWbamount() {
		return wbamount.getText();
	}




	public void setWbamount(JTextField wbamount) {
		this.wbamount = wbamount;
	}




	public JButton getHalfMetalBrickSelected() {
		return halfMetalBrickSelected;
	}




	public void setHalfMetalBrickSelected(JButton halfMetalBrickSelected) {
		this.halfMetalBrickSelected = halfMetalBrickSelected;
	}




	public String getHmbamount() {
		return hmbamount.getText();
	}




	public void setHmbamount(JTextField hmbamount) {
		this.hmbamount = hmbamount;
	}




	public JButton getDeleteSelectedBrick() {
		return deleteSelectedBrick;
	}




	public void setDeleteSelectedBrick(JButton deleteSelectedBrick) {
		this.deleteSelectedBrick = deleteSelectedBrick;
	}




	public JButton getGenerateMap() {
		return generateMap;
	}


	public void setGenerateMap(JButton generateMap) {
		this.generateMap = generateMap;
	}
	
	public Panel() {
		super();
	}
	public JFrame getF1() {
		return f1;
	}
	public void setF1(JFrame f1) {
		this.f1 = f1;
	}
	public Opening getO1() {
		return o1;
	}
	public void setO1(Opening o1) {
		this.o1 = o1;
	}
	public JButton getSavebutton() {
		return savebutton;
	}
	public void setSavebutton(JButton savebutton) {
		this.savebutton = savebutton;
	}
	public JButton getLoadbutton() {
		return loadbutton;
	}
	public void setLoadbutton(JButton loadbutton) {
		this.loadbutton = loadbutton;
	}
	public JButton getPausebutton() {
		return pausebutton;
	}
	public void setPausebutton(JButton pausebutton) {
		this.pausebutton = pausebutton;
	}
	public JButton getQuitbutton() {
		return quitbutton;
	}
	public void setQuitbutton(JButton quitbutton) {
		this.quitbutton = quitbutton;
	}
	public JButton getGoRunningMode() {
		return goRunningMode;
	}
	public void setGoRunningMode(JButton goRunningMode) {
		this.goRunningMode = goRunningMode;
	}
	public JPanel getRunningControlPanel() {
		return runningControlPanel;
	}
	public void setRunningControlPanel(JPanel runningControlPanel) {
		this.runningControlPanel = runningControlPanel;
	}
	public JPanel getRunningPowerUpPanel() {
		return runningPowerUpPanel;
	}
	public void setRunningPowerUpPanel(JPanel runningPowerUpPanel) {
		this.runningPowerUpPanel = runningPowerUpPanel;
	}
	
	public void updatePowerUpLabel(int a,int b, int c, int d, int e, int f, int g, int h) {
		JPanel p1 = getRunningPowerUpPanel();
		for(Component jc : p1.getComponents()) {
			if(jc instanceof JLabel) {
				String text = ((JLabel) jc).getText();
				if(text.contains("TallerPaddle")) {
					((JLabel) jc).setText("TallerPaddle(T) x "+ a + " //");
					((JLabel) jc).setForeground(Color.WHITE);
				}
				if(text.contains("Magnet")) {
					((JLabel) jc).setText("Magnet(M/W) x "+ b + " //");
					((JLabel) jc).setForeground(Color.WHITE);
				}
				if(text.contains("Chemical")) {
					((JLabel) jc).setText("ChemicalBall(C) x "+ c + " //");
					((JLabel) jc).setForeground(Color.WHITE);
				}
				if(text.contains("FireBall")) {
					((JLabel) jc).setText("FireBall(F) x "+ d + " //");
					((JLabel) jc).setForeground(Color.WHITE);
				}
				if(text.contains("GangOfBalls")) {
					((JLabel) jc).setText("GangOfBalls(G) x "+ e + " //");
					((JLabel) jc).setForeground(Color.WHITE);
				}
				if(text.contains("DLG")) {
					((JLabel) jc).setText("DLG(Q) x "+ f + " //");
					((JLabel) jc).setForeground(Color.WHITE);
				}
				if(text.contains("Score")) {
					((JLabel) jc).setText("Score: "+ g + " //");
					((JLabel) jc).setForeground(Color.WHITE);
				}
				if(text.contains("No of Lives")) {
					((JLabel) jc).setText("No of Lives: "+ h );
					((JLabel) jc).setForeground(Color.WHITE);
				}
			}
		}
		f1.remove(runningPowerUpPanel);
		f1.add(p1,BorderLayout.SOUTH);
		f1.validate();
	}

	
}