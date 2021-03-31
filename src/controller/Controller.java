package controller;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import Player.Player;
import SaveLoad.MongoDBAdapter;
import SaveLoad.MongoSaveBuild;
import SaveLoad.MongoSaveRun;
import SaveLoad.SaveBuilding;
import SaveLoad.SaveRunning;
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
import game.BuildingMode;
import game.Panel;
import game.RunningMode;
import paddle.Paddle;
import powerups.ChemicalBall;
import powerups.DLG;
import powerups.FireBall;
import powerups.GangOfBalls;
import powerups.Magnet;
import powerups.PowerUp;
import powerups.TallerPaddle;

public class Controller {


	private RunningMode run = new RunningMode();
	private BuildingMode map = new BuildingMode();
	private Panel panel = new Panel();
	private MongoDBAdapter mongoBuildSaver = new MongoSaveBuild();
	private MongoDBAdapter mongoRunSaver = new MongoSaveRun();
	private MongoDBAdapter localBuildSaver = new SaveBuilding();
	private MongoDBAdapter localRunSaver = new SaveRunning();
	private Opening starter = new Opening(false);

	public Controller () {
		super();
	}
	public void callSaveBuildLocal(String name) {
		localBuildSaver.saveLocalB(name, map.getBricksDrawed());
	}
	public ArrayList<Brick> loadedBuildingBricksLocal(String name) {
		return localBuildSaver.getBuildingModeComponentsLocal(name);
	}
	
	public void callSaveBuildMongo(String name) {
		mongoBuildSaver.deleteDuplicateUser(name);
		mongoBuildSaver.connectMongoAndSaveBuildingMode(name, map.getBricksDrawed());
	}
	public void callSaveRunMongo(String name) {
		mongoRunSaver.deleteDuplicateUser(name);
		mongoRunSaver.connectMongoAndSaveRunningMode(name, map.getBricksDrawed(), run.getBallIsDrawn(), run.getPowerUpsDrawn(), 
													run.getAliensDrawn(), run.getPlayer(), run.getPaddle());
	}
	public ArrayList<Brick> loadedBuildingBricksMongo(String name) {
		return mongoBuildSaver.getBuildingModeComponentsMongo(name);
	}
	public void callSaveRunLocal(String username) {
		localRunSaver.saveLocal(map.getBricksDrawed(), run.getBallIsDrawn(), run.getPowerUpsDrawn(), run.getAliensDrawn(), run.getPlayer(), run.getPaddle(),username);
	}
	public ArrayList<Brick> loadedRunningBricksLocal(String name){
		return localRunSaver.runModeBricks(name);
	}
	public ArrayList<Ball> loadedRunningBallsLocal(String name){
		return ((SaveRunning) localRunSaver).runModeBalls(name);
	}
	public ArrayList<PowerUp> loadedRunningPowerUpsLocal(String name){
		return localRunSaver.runModePowerUps(name);
	}
	public ArrayList<Alien> loadedRunningAliensLocal(String name){
		return localRunSaver.runModeAliens(name);
	}
	public Player loadedRunningPlayerLocal(String name) {
		return localRunSaver.runModePlayer(name);
	}
	public Paddle loadedRunningPaddleLocal(String name) {
		return localRunSaver.runModePaddle(name);
	}
	public ArrayList<Brick> loadedRunningBricksMongo(String name){
		return mongoRunSaver.getRunningModeBricks(name);
	}
	public ArrayList<Ball> loadedRunningBallsMongo(String name){
		return mongoRunSaver.getRunningModeBalls(name);
	}
	public ArrayList<Alien> loadedRunningAliensMongo(String name){
		return mongoRunSaver.getRunningModeAliens(name);
	}
	public ArrayList<PowerUp> loadedRunningPowerUpsMongo(String name){
		return mongoRunSaver.getRunningModePowerUps(name);
	}
	public Player loadedRunningPlayerMongo(String name){
		return mongoRunSaver.getRunningModePlayer(name);
	}
	public Paddle loadedRunningPaddleMongo(String name){
		return mongoRunSaver.getRunningModePaddle(name);
	}
	public void callDisplayMongoDatabase() {
		mongoBuildSaver.displayTheDatabase();
	}
	public void callDrunkAlienBehaviourSet() {
		run.setDrunkAlienBehaviour(map.getBricksDrawed());
	}
	public String getTheDrunkAlienBehaviours() {
		return run.getDrunkAlienBehaviour();
	}
	public void actDrunkAliensProtecting() {
		run.drunkAlienProtectingAction();
	}
	public void actDrunkAlienRepairing() {
		run.drunkAlienRepairingAction(map.getBricksDrawed());
	}
	public void actDrunkAlienCooperative() {
		run.drunkAlienCooperativeAction(map.getBricksDrawed());
	}
	public void actDrunkAlienSpecial(boolean b) {
		run.drunkAlienSpecialAction(map.getBricksDrawed(),b);
	}
	public void callDrawLASER(Graphics g,Paddle p) {
		panel.drawLeftLaser(p, g);
		panel.drawRightLaser(p, g);
	}
	public void callDrawDrunkAlien(Graphics g, DrunkAlien da) {
		panel.drawDrunkAlien(da, g);
	}
	public void callDrawFireBall(FireBall f, Graphics g) {
		panel.drawFireBall(f, g);
	}
	public void callDrawDLG(DLG d, Graphics g) {
		panel.drawDLG(d, g);
	}
	public void callDrawGOB(GangOfBalls gang, Graphics g) {
		panel.drawGOB(gang, g);
	}
	public void callDrawChemicalP(ChemicalBall c, Graphics g) {
		panel.drawChemicalP(c, g);
	}
	public void callDrawMagnet(Magnet m,Graphics g) {
		panel.drawMagnet(m, g);
	}
	public void callDrawTallerPaddlePow(TallerPaddle tp , Graphics g) {
		panel.drawTallerPaddlePow(tp, g);
	}
	public void callDrawP (Paddle p, Graphics g) {
		panel.drawPaddle(p, g);
	}

	public void callDrawBall(Ball b, Graphics g) {
		panel.drawBall(b, g);
	}

	public void callDrawSB(SimpleBrick sb, Graphics g) {
		panel.drawSimpleBrick(sb, g);
	}

	public void callDrawHMB(HalfMetalBrick hmb, Graphics g) {
		panel.drawHalfMetalBrick(hmb, g);
	}

	public void callDrawWB(WrapperBrick wb, Graphics g) {
		panel.drawWrapperBrick(wb, g);
	}

	public void callDrawMB(MineBrick mb, Graphics g) {
		panel.drawMineBrick(mb, g);
	}

	public void maintainMap(int x, int y) {
		map.alterMap(x, y, run.isPlay());
	}

	public void selectDeleteB() {
		map.selectDeleteBrick();
	}

	public void selectSB() {
		map.selectSimpleBrick();
	}

	public void selectHMB() {
		map.selectHalfMetalBrick();
	}

	public void selectWB() {
		map.selectWrapperBrick();
	}

	public void selectMB() {
		map.selectMineBrick();
	}

	public void startRunningMode () {
		panel.goRunningMode(this.playeable());
		this.startGameC();
		run.createFirstBall();
	}

	public void getPauseOutput() {
		panel.pauseOutput();
	}

	public void quit() {
		panel.quitGame();
	}

	public void callAdjustFrame() {
		panel.adjustFrame();
	}

	public JButton getSBButton() {
		return panel.getSimpleBrickSelected();
	}

	public JButton getHMBButton() {
		return panel.getHalfMetalBrickSelected();
	}

	public JButton getWBButton() {
		return panel.getWrapperBrickSelected();
	}

	public JButton getMBButton() {
		return panel.getMineBrickSelected();
	}

	public JButton getMapButton() {
		return panel.getGenerateMap();
	}

	public JButton getDeleteBButton() {
		return panel.getDeleteSelectedBrick();
	}


	public void createBuildingPanel() {

		panel.addBuildingPanels();

	}

	public JButton getSbutton ( ) {

		return panel.getSavebutton();

	}

	public JButton getSRbutton() {
		return panel.getSaveRbutton();
	}

	public JButton getLbutton ( ) {

		return panel.getLoadbutton();

	}

	public JButton getLRbutton() {
		return panel.getLoadRbutton();
	}

	public JButton getPbutton ( ) {

		return panel.getPausebutton();

	}

	public JButton getPRbutton () {
		return panel.getPauseRbutton();
	}

	public JButton getQbutton ( ) {

		return panel.getQuitbutton();

	}

	public JButton getQRbutton() {
		return panel.getQuitRbutton();
	}

	public JButton getRunningModeButton() {

		return panel.getGoRunningMode();

	}


	public JFrame getFrame() {

		return panel.getF1();

	}

	public void setFrame(JFrame f1) {

		panel.setF1(f1);

	}

	public Opening getOpening() {
		return panel.getO1();
	}


	public void setOpening(Opening opening) {
		panel.setO1(opening);
	}



	public RunningMode getRun() {
		return run;
	}

	public void setRun(RunningMode run) {
		this.run = run;
	}

	public BuildingMode getMap() {
		return map;
	}

	public void setMap(BuildingMode map) {
		this.map = map;
	}

	public boolean getRunPause() {

		return run.isPaused();
	}

	public ArrayList<Ball> getBalls() {

		return run.getBallIsDrawn();
	}

	public boolean getBallisnotThrown() {

		return run.isBallNotThrown();
	}

	public Ball getBall() {

		return run.getBall();

	}

	public Paddle getPaddleC() {

		return run.getPaddle();

	}

	public ArrayList<Brick> getBricks() {

		return map.getBricksDrawed();

	}

	public void getMoveRigth() {

		run.moveRigth();

	}

	public void getMoveLeft() {

		run.moveLeft();

	}

	public void getRotateRigth() {

		run.rotateRigth();

	}

	public void getRotateLeft() {

		run.rotateLeft();

	}

	public void getRigthAngle() {

		run.rigthAngle();

	}

	public void getLeftAngle() {

		run.leftAngle();

	}

	public void getThrowBall() {

		run.throwBalls();

	}

	public void getPause() {

		run.pauseGame();
	}

	public void getCreateSB(int x, int y) {

		map.createSB(x, y);

	}



	public boolean getFinishedC() {

		return map.isFinished();

	}

	public void getInit() {

		map.initializeMap(panel.getSbamount(), panel.getHmbamount(), panel.getWbamount(), panel.getMbamount());

	}

	public void startGameC() {

		run.setPlay(true);

	}

	public boolean playeable() {

		return run.isPlay();

	}

	public void destroyBrick(int sec) {

		run.ballIntersectsBrick(map.getBricksDrawed(),sec);

	}

	public void dropBrick(int x, int y) {

		map.removeBrick(x, y, run.isPlay());

	}

	public void moveBall() {

		run.ballMovement();

	}

	public Panel getPanel() {
		return panel;
	}

	public void setPanel(Panel panel) {
		this.panel = panel;
	}

	public ArrayList<Alien> getAliens(){
		return run.getAliensDrawn();
	}
	public void callDrawPA(ProtectingAlien pa, Graphics g) {
		panel.drawProtectingAlien(pa, g);
	}
	public void simulateAliens() {
		run.actAliens();
	}

	public void destroyAlien() {
		run.ballIntersectsAlien();
	}

	public ArrayList<PowerUp> getPowerUps(){
		return run.getPowerUpsDrawn();
	}
	public void callDropPowerUps() {
		run.dropPowerUps();
	}
	public void takePowerUp() {
		run.paddleIntersectsPowerUp();
	}
	public void updatePUL() {
		panel.updatePowerUpLabel(run.getPlayer().getTallp(),run.getPlayer().getMagnet(),
				run.getPlayer().getChemball(),run.getPlayer().getFireball(),
				run.getPlayer().getGob(),run.getPlayer().getDlg(),
				run.getPlayer().getScore(),run.getPlayer().getNoOfLives());	
	}
	public int getRemainingLives() {
		return run.getLifeAmount();
	}
	public void controlDLGIntersection() {
		if(run.isLaserActive()) {
			run.DLGIntersectsBrick(run.getPaddle(), map.getBricksDrawed());	
		}
	}
	public void actRepairingAliens() {
		run.repairingAlienAction(map.getBricksDrawed());
	}
	public void actCooperativeAliens() {
		run.cooperativeAlienAction(map.getBricksDrawed());
	}
	
	public void callDrawRepairingAlien(RepairingAlien rp, Graphics g) {
		panel.drawRepairingAlien(rp, g);
	}
	public void callDrawCooperativeAlien(CooperativeAlien ca,Graphics g) {
		panel.drawCooperativeAlien(ca, g);
	}

	public void setInitialBrickAmount(int initialBrickAmount) {
		run.setInitBa(initialBrickAmount);
	}
	public Player getThePlayer() {
		return starter.getPlayer();
	}
	public  void setThePLayer(Player p) {
		run.setPlayer(p);
	}
}
