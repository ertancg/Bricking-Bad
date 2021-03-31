package SaveLoad;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import Player.Player;
import alien.Alien;
import alien.CooperativeAlien;
import alien.DrunkAlien;
import alien.ProtectingAlien;
import alien.RepairingAlien;
import ball.Ball;
import brick.Brick;
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
import powerups.PowerUp;
import powerups.TallerPaddle;

public class MongoSaveRun implements MongoDBAdapter {

	public void deleteDuplicateUser(String userName) {
		MongoClient mongo = new MongoClient("localhost",27017);
		MongoDatabase database = mongo.getDatabase("RunningOrBuildingSaves"); 
		MongoCollection<Document> collection = database.getCollection("BSorRS"); 
		collection.deleteOne(Filters.eq("playerName", userName));
		collection.deleteOne(Filters.eq("playerName", null));
		collection.deleteOne(Filters.eq("playerName", "null"));
	}

	public void connectMongoAndSaveRunningMode(String playername,ArrayList<Brick> buildingModeBricks,ArrayList<Ball> balls,
		      								   ArrayList<PowerUp> powUps,ArrayList<Alien> aliens, Player p,Paddle pad) {
		MongoClient mongo = new MongoClient("localhost",27017);
		System.out.println("Connected to the database successfully");  
		// Accessing the database 
		MongoDatabase database = mongo.getDatabase("RunningOrBuildingSaves"); 
		//Creating a collection 
		// database.createCollection("BSorRS"); already created BSorRS collection
		System.out.println("Collection created successfully"); 
		// Retrieving a collection
		MongoCollection<Document> collection = database.getCollection("BSorRS");    
		System.out.println("Collection BSorRS selected successfully");   
		//////////Bricks
		List<BasicDBObject> bricks = new ArrayList<BasicDBObject>();
		for (Brick b : buildingModeBricks) {
			BasicDBObject brickDBObject = new BasicDBObject();
			if(b instanceof SimpleBrick) {
				brickDBObject.put("xcoordinate", b.getBrickXCoor());
				brickDBObject.put("ycoordinate", b.getBrickYCoor());
				brickDBObject.put("type", "SimpleBrick");
			}else if(b instanceof HalfMetalBrick) {
				brickDBObject.put("xcoordinate", b.getBrickXCoor());
				brickDBObject.put("ycoordinate", b.getBrickYCoor());
				brickDBObject.put("type", "HalfMetalBrick");
			}else if(b instanceof WrapperBrick) {
				brickDBObject.put("xcoordinate", b.getBrickXCoor());
				brickDBObject.put("ycoordinate", b.getBrickYCoor());
				brickDBObject.put("type", "WrapperBrick");
			}else {
				brickDBObject.put("xcoordinate", b.getBrickXCoor());
				brickDBObject.put("ycoordinate", b.getBrickYCoor());
				brickDBObject.put("type", "MineBrick");
			}
			bricks.add(brickDBObject);
		} 
		/////////////Aliens
		List<BasicDBObject> alienSaved = new ArrayList<BasicDBObject>();
		for (Alien a : aliens) {
			BasicDBObject alienDBObject = new BasicDBObject();
			if(a instanceof CooperativeAlien) {
				alienDBObject.put("xcoordinate", a.getAlienXCoor());
				alienDBObject.put("ycoordinate", a.getAlienYCoor());
				alienDBObject.put("type", "CooperativeAlien");
			}else if(a instanceof ProtectingAlien) {
				alienDBObject.put("xcoordinate", a.getAlienXCoor());
				alienDBObject.put("ycoordinate", a.getAlienYCoor());
				alienDBObject.put("direction", a.getDirection());
				alienDBObject.put("type", "ProtectingAlien");
			}else if(a instanceof RepairingAlien) {
				alienDBObject.put("xcoordinate", a.getAlienXCoor());
				alienDBObject.put("ycoordinate", a.getAlienYCoor());
				alienDBObject.put("type", "RepairingAlien");
			}else {
				alienDBObject.put("xcoordinate", a.getAlienXCoor());
				alienDBObject.put("ycoordinate", a.getAlienYCoor());
				alienDBObject.put("direction", a.getDirection());
				alienDBObject.put("type", "DrunkAlien");
			}
			alienSaved.add(alienDBObject);
		} 
		/////////////////Balls
		List<BasicDBObject> ballsSaved = new ArrayList<BasicDBObject>();
		for (Ball b : balls) {
			BasicDBObject ballDBObject = new BasicDBObject();
			ballDBObject.put("xcoordinate", b.getBallXcoor());
			ballDBObject.put("ycoordinate", b.getBallYcoor());
			ballDBObject.put("ydir", b.getBallYdir());
			ballDBObject.put("xdir", b.getBallXdir());
			if(b.isChemical()) {
				ballDBObject.put("type", "chemical");
			}
			if(b.isFire()) {
				ballDBObject.put("type", "fire");
			}
			if(b.isNormal()) {
				ballDBObject.put("type", "normal");
			}
			ballsSaved.add(ballDBObject);
		} 
		/////////////////////Power Ups
		List<BasicDBObject> powerUpsSaved = new ArrayList<BasicDBObject>();
		for (PowerUp pa : powUps) {
			BasicDBObject powupDBObject = new BasicDBObject();
			if(pa instanceof DLG) {
				powupDBObject.put("xcoordinate", pa.getpXCoor());
				powupDBObject.put("ycoordinate", pa.getpYCoor());
				powupDBObject.put("type", "DLG");
			}else if(pa instanceof FireBall) {
				powupDBObject.put("xcoordinate", pa.getpXCoor());
				powupDBObject.put("ycoordinate", pa.getpYCoor());
				powupDBObject.put("type", "FireBall");
			}else if(pa instanceof Magnet) {
				powupDBObject.put("xcoordinate", pa.getpXCoor());
				powupDBObject.put("ycoordinate", pa.getpYCoor());
				powupDBObject.put("type", "Magnet");
			}else if (pa instanceof TallerPaddle){
				powupDBObject.put("xcoordinate", pa.getpXCoor());
				powupDBObject.put("ycoordinate", pa.getpYCoor());
				powupDBObject.put("type", "TallerPaddle");
			}else if(pa instanceof GangOfBalls) {
				powupDBObject.put("xcoordinate", pa.getpXCoor());
				powupDBObject.put("ycoordinate", pa.getpYCoor());
				powupDBObject.put("type", "GangOfBalls");
			}else {
				powupDBObject.put("xcoordinate", pa.getpXCoor());
				powupDBObject.put("ycoordinate", pa.getpYCoor());
				powupDBObject.put("type", "ChemicalBall");
			}
			powerUpsSaved.add(powupDBObject);
		}
		//////////////////Player
		BasicDBObject playerDBObject = new BasicDBObject();
		playerDBObject.put("magnet",p.getMagnet());
		playerDBObject.put("dlg",p.getDlg());
		playerDBObject.put("fb",p.getFireball());
		playerDBObject.put("cb",p.getChemball());
		playerDBObject.put("tp",p.getTallp());
		playerDBObject.put("gob",p.getGob());
		playerDBObject.put("score",p.getScore());
		playerDBObject.put("noofl",p.getNoOfLives());
		////////////////Paddle
		BasicDBObject paddleDBObject = new BasicDBObject();
		paddleDBObject.put("xcoordinate",pad.getPaddleXCoordinate());
		paddleDBObject.put("ycoordinate",pad.getPaddleYCoordinate());
		paddleDBObject.put("length",pad.getLength());
		if(pad.isArmed()) {
			paddleDBObject.put("armed","t");
		}else {
			paddleDBObject.put("armed","f");
		}
		/////////////////////
		Document document = new Document("title", "MongoDB_RunningModeSave")
				.append("playerName", playername)
				.append("Bricks", bricks)
				.append("Aliens", alienSaved)
				.append("Balls", ballsSaved)
				.append("PowerUps", powerUpsSaved)
				.append("Player", playerDBObject)
				.append("Paddle", paddleDBObject);
		collection.insertOne(document);
		System.out.println("Document inserted successfully");  
	}
	
	public ArrayList<Brick> getRunningModeBricks(String username) {
		MongoClient mongo = new MongoClient("localhost",27017);
		MongoDatabase database = mongo.getDatabase("RunningOrBuildingSaves"); 
		MongoCollection<Document> collection = database.getCollection("BSorRS");
		FindIterable<Document> iterDoc = collection.find();
		ArrayList<Brick> bricks = new ArrayList<Brick>();
		for(Document d : iterDoc) {
			if(d.get("playerName").equals(username) && d.get("title").equals("MongoDB_RunningModeSave")) {
				ArrayList<Document> runningBricks = (ArrayList<Document>) d.get("Bricks");
				for(int i=0;i<runningBricks.size();i++) {		
					if(runningBricks.get(i).get("type").equals("SimpleBrick")) {
						Integer xc = (Integer) runningBricks.get(i).get("xcoordinate");
						Integer yc = (Integer) runningBricks.get(i).get("ycoordinate");
						bricks.add(new SimpleBrick(xc,yc));
					}else if(runningBricks.get(i).get("type").equals("HalfMetalBrick")) {
						Integer xc = (Integer) runningBricks.get(i).get("xcoordinate");
						Integer yc = (Integer) runningBricks.get(i).get("ycoordinate");
						HalfMetalBrick hmb = new HalfMetalBrick(xc,yc);
						bricks.add(hmb);
					}else if(runningBricks.get(i).get("type").equals("WrapperBrick")) {
						Integer xc = (Integer) runningBricks.get(i).get("xcoordinate");
						Integer yc = (Integer) runningBricks.get(i).get("ycoordinate");
						WrapperBrick wb = new WrapperBrick(xc,yc);
						bricks.add(wb);
					}else {
						Integer xc = (Integer) runningBricks.get(i).get("xcoordinate");
						Integer yc = (Integer) runningBricks.get(i).get("ycoordinate");
						MineBrick mb = new MineBrick(xc,yc);
						bricks.add(mb);
					}
				}
			}
		}
		return bricks;
	}
	public ArrayList<Alien> getRunningModeAliens(String username) {
		MongoClient mongo = new MongoClient("localhost",27017);
		MongoDatabase database = mongo.getDatabase("RunningOrBuildingSaves"); 
		MongoCollection<Document> collection = database.getCollection("BSorRS");
		FindIterable<Document> iterDoc = collection.find();
		ArrayList<Alien> aliens = new ArrayList<Alien>();
		for(Document d : iterDoc) {
			if(d.get("playerName").equals(username) && d.get("title").equals("MongoDB_RunningModeSave")) {
				ArrayList<Document> runningAliens = (ArrayList<Document>) d.get("Aliens");
				for(int i=0;i<runningAliens.size();i++) {		
					if(runningAliens.get(i).get("type").equals("CooperativeAlien")) {
						Integer xc = (Integer) runningAliens.get(i).get("xcoordinate");
						Integer yc = (Integer) runningAliens.get(i).get("ycoordinate");
						aliens.add(new CooperativeAlien(xc,yc));
					}else if(runningAliens.get(i).get("type").equals("RepairingAlien")) {
						Integer xc = (Integer) runningAliens.get(i).get("xcoordinate");
						Integer yc = (Integer) runningAliens.get(i).get("ycoordinate");
						aliens.add(new RepairingAlien(xc,yc));
					}else if(runningAliens.get(i).get("type").equals("ProtectingAlien")) {
						Integer xc = (Integer) runningAliens.get(i).get("xcoordinate");
						Integer yc = (Integer) runningAliens.get(i).get("ycoordinate");
						Integer dr = (Integer) runningAliens.get(i).get("direction");
						ProtectingAlien pa = new ProtectingAlien(xc,yc);
						pa.setDirection(dr);
						aliens.add(pa);
					}else {
						Integer xc = (Integer) runningAliens.get(i).get("xcoordinate");
						Integer yc = (Integer) runningAliens.get(i).get("ycoordinate");
						Integer dr = (Integer) runningAliens.get(i).get("direction");
						DrunkAlien da = new DrunkAlien(xc,yc);
						da.setDirection(dr);
						aliens.add(da);
					}
				}
			}
		}
		return aliens;
	}

	public ArrayList<Ball> getRunningModeBalls(String username) {
		MongoClient mongo = new MongoClient("localhost",27017);
		MongoDatabase database = mongo.getDatabase("RunningOrBuildingSaves"); 
		MongoCollection<Document> collection = database.getCollection("BSorRS");
		FindIterable<Document> iterDoc = collection.find();
		ArrayList<Ball> balls = new ArrayList<Ball>();
		for(Document d : iterDoc) {
			if(d.get("playerName").equals(username) && d.get("title").equals("MongoDB_RunningModeSave")) {
				ArrayList<Document> runningBalls = (ArrayList<Document>) d.get("Balls");
				for(int i=0;i<runningBalls.size();i++) {		
					if(runningBalls.get(i).get("type").equals("chemical")) {
						Integer xc = (Integer) runningBalls.get(i).get("xcoordinate");
						Integer yc = (Integer) runningBalls.get(i).get("ycoordinate");
						Integer yd = (Integer) runningBalls.get(i).get("ydir");
						Integer xd = (Integer) runningBalls.get(i).get("xdir");
						Ball temp = new Ball(xc,yc,xd,yd,0);
						temp.setChemical();
						balls.add(temp);
					}else if(runningBalls.get(i).get("type").equals("fire")) {
						Integer xc = (Integer) runningBalls.get(i).get("xcoordinate");
						Integer yc = (Integer) runningBalls.get(i).get("ycoordinate");
						Integer yd = (Integer) runningBalls.get(i).get("ydir");
						Integer xd = (Integer) runningBalls.get(i).get("xdir");
						Ball temp = new Ball(xc,yc,xd,yd,0);
						temp.setFire();
						balls.add(temp);
					}else {
						Integer xc = (Integer) runningBalls.get(i).get("xcoordinate");
						Integer yc = (Integer) runningBalls.get(i).get("ycoordinate");
						Integer yd = (Integer) runningBalls.get(i).get("ydir");
						Integer xd = (Integer) runningBalls.get(i).get("xdir");
						Ball temp = new Ball(xc,yc,xd,yd,0);
						temp.setNormal();
						balls.add(temp);
					}
				}
			}
		}
		return balls;
	}

	public ArrayList<PowerUp> getRunningModePowerUps(String username) {
		MongoClient mongo = new MongoClient("localhost",27017);
		MongoDatabase database = mongo.getDatabase("RunningOrBuildingSaves"); 
		MongoCollection<Document> collection = database.getCollection("BSorRS");
		FindIterable<Document> iterDoc = collection.find();
		ArrayList<PowerUp> powerUps = new ArrayList<PowerUp>();
		for(Document d : iterDoc) {
			if(d.get("playerName").equals(username) && d.get("title").equals("MongoDB_RunningModeSave")) {
				ArrayList<Document> runningPowerUps = (ArrayList<Document>) d.get("PowerUps");
				for(int i=0;i<runningPowerUps.size();i++) {		
					if(runningPowerUps.get(i).get("type").equals("TallerPaddle")) {
						Integer xc = (Integer) runningPowerUps.get(i).get("xcoordinate");
						Integer yc = (Integer) runningPowerUps.get(i).get("ycoordinate");
						powerUps.add(new TallerPaddle(xc,yc));
					}else if(runningPowerUps.get(i).get("type").equals("DLG")) {
						Integer xc = (Integer) runningPowerUps.get(i).get("xcoordinate");
						Integer yc = (Integer) runningPowerUps.get(i).get("ycoordinate");
						powerUps.add(new DLG(xc,yc));
					}else if(runningPowerUps.get(i).get("type").equals("FireBall")) {
						Integer xc = (Integer) runningPowerUps.get(i).get("xcoordinate");
						Integer yc = (Integer) runningPowerUps.get(i).get("ycoordinate");
						powerUps.add(new FireBall(xc,yc));
					}else if(runningPowerUps.get(i).get("type").equals("ChemicalBall")){
						Integer xc = (Integer) runningPowerUps.get(i).get("xcoordinate");
						Integer yc = (Integer) runningPowerUps.get(i).get("ycoordinate");
						powerUps.add(new ChemicalBall(xc,yc));
					}else if(runningPowerUps.get(i).get("type").equals("Magnet")) {
						Integer xc = (Integer) runningPowerUps.get(i).get("xcoordinate");
						Integer yc = (Integer) runningPowerUps.get(i).get("ycoordinate");
						powerUps.add(new Magnet(xc,yc));
					}else {
						Integer xc = (Integer) runningPowerUps.get(i).get("xcoordinate");
						Integer yc = (Integer) runningPowerUps.get(i).get("ycoordinate");
						powerUps.add(new GangOfBalls(xc,yc));
					}
				}
			}
		}
		return powerUps;
	}
	
	public Player getRunningModePlayer(String username) {
		MongoClient mongo = new MongoClient("localhost",27017);
		MongoDatabase database = mongo.getDatabase("RunningOrBuildingSaves"); 
		MongoCollection<Document> collection = database.getCollection("BSorRS");
		FindIterable<Document> iterDoc = collection.find();
		for(Document d : iterDoc) {
			if(d.get("playerName").equals(username) && d.get("title").equals("MongoDB_RunningModeSave")) {
				Document sp =  (Document) d.get("Player");
				Player player = new Player((int) sp.get("magnet"),(int) sp.get("cb"),(int) sp.get("fb"),
						(int) sp.get("dlg"),(int) sp.get("gob"),(int) sp.get("tp"),(int) sp.get("score"),(int) sp.get("noofl"));
				return player;
			}
		}
		return null;
	}
	public Paddle getRunningModePaddle(String username) {
		MongoClient mongo = new MongoClient("localhost",27017);
		MongoDatabase database = mongo.getDatabase("RunningOrBuildingSaves"); 
		MongoCollection<Document> collection = database.getCollection("BSorRS");
		FindIterable<Document> iterDoc = collection.find();
		for(Document d : iterDoc) {
			if(d.get("playerName").equals(username) && d.get("title").equals("MongoDB_RunningModeSave")) {
				Document sp =  (Document) d.get("Paddle");
				Paddle p = new Paddle((int) sp.get("length"),(int) sp.get("xcoordinate"),(int) sp.get("ycoordinate"),0);
				if(sp.get("armed").equals("t")) {
					p.setArmed(true);
				}else {
					p.setArmed(false);
				}
				return p;
			}
		}
		return null;
	}

	@Override
	public void connectMongoAndSaveBuildingMode(String playername, ArrayList<Brick> buildingModeBricks) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayTheDatabase() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Brick> getBuildingModeComponentsMongo(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveLocalB(String name, ArrayList<Brick> bmBricks) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Brick> getBuildingModeComponentsLocal(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveLocal(ArrayList<Brick> bmBricks, ArrayList<Ball> balls, ArrayList<PowerUp> powUps,
			ArrayList<Alien> aliens, Player p, Paddle pad, String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Brick> runModeBricks(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Alien> runModeAliens(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PowerUp> runModePowerUps(String username) {
		// TODO Auto-generated method stub
		return null;
	}


	public Player runModePlayer(String username) {
		// TODO Auto-generated method stub
		return null;
	}


	public Paddle runModePaddle(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
