package SaveLoad;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import Player.Player;
import alien.Alien;
import ball.Ball;
import brick.Brick;
import brick.HalfMetalBrick;
import brick.MineBrick;
import brick.SimpleBrick;
import brick.WrapperBrick;
import paddle.Paddle;
import powerups.PowerUp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.bson.BSONObject;
import org.bson.Document;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential;

public class MongoSaveBuild implements MongoDBAdapter{

	public void connectMongoAndSaveBuildingMode(String playername,ArrayList<Brick> buildingModeBricks) {
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
		//////////7
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
		Document document = new Document("title", "MongoDB_BuildingModeSave")
				.append("playerName", playername)
				.append("Bricks", bricks);
		collection.insertOne(document);
		System.out.println("Document inserted successfully");  
	}

	public void deleteDuplicateUser(String userName) {
		MongoClient mongo = new MongoClient("localhost",27017);
		MongoDatabase database = mongo.getDatabase("RunningOrBuildingSaves"); 
		MongoCollection<Document> collection = database.getCollection("BSorRS"); 
		collection.deleteOne(Filters.eq("playerName", userName));
		collection.deleteOne(Filters.eq("playerName", null));
		collection.deleteOne(Filters.eq("playerName", "null"));
	}

	public void displayTheDatabase() {
		MongoClient mongo = new MongoClient("localhost",27017);
		MongoDatabase database = mongo.getDatabase("RunningOrBuildingSaves"); 
		MongoCollection<Document> collection = database.getCollection("BSorRS"); 
		//Printing the Document
		FindIterable<Document> iterDoc = collection.find();
		Iterator it = iterDoc.iterator(); 
		while (it.hasNext()) {  
			System.out.println(it.next());  
		}
	}
	public ArrayList<Brick> getBuildingModeComponentsMongo(String username) {
		MongoClient mongo = new MongoClient("localhost",27017);
		MongoDatabase database = mongo.getDatabase("RunningOrBuildingSaves"); 
		MongoCollection<Document> collection = database.getCollection("BSorRS");
		FindIterable<Document> iterDoc = collection.find();
		ArrayList<Brick> bricks = new ArrayList<Brick>();
		for(Document d : iterDoc) {
			if(d.get("playerName").equals(username) && d.get("title").equals("MongoDB_BuildingModeSave")) {
				ArrayList<Document> buildingBricks = (ArrayList<Document>) d.get("Bricks");
				for(int i=0;i<buildingBricks.size();i++) {		
					if(buildingBricks.get(i).get("type").equals("SimpleBrick")) {
						Integer xc = (Integer) buildingBricks.get(i).get("xcoordinate");
						Integer yc = (Integer) buildingBricks.get(i).get("ycoordinate");
						bricks.add(new SimpleBrick(xc,yc));
					}else if(buildingBricks.get(i).get("type").equals("HalfMetalBrick")) {
						Integer xc = (Integer) buildingBricks.get(i).get("xcoordinate");
						Integer yc = (Integer) buildingBricks.get(i).get("ycoordinate");
						HalfMetalBrick hmb = new HalfMetalBrick(xc,yc);
						bricks.add(hmb);
					}else if(buildingBricks.get(i).get("type").equals("WrapperBrick")) {
						Integer xc = (Integer) buildingBricks.get(i).get("xcoordinate");
						Integer yc = (Integer) buildingBricks.get(i).get("ycoordinate");
						WrapperBrick wb = new WrapperBrick(xc,yc);
						bricks.add(wb);
					}else {
						Integer xc = (Integer) buildingBricks.get(i).get("xcoordinate");
						Integer yc = (Integer) buildingBricks.get(i).get("ycoordinate");
						MineBrick mb = new MineBrick(xc,yc);
						bricks.add(mb);
					}
				}
			}
		}
		return bricks;
	}

	@Override
	public void connectMongoAndSaveRunningMode(String playername, ArrayList<Brick> buildingModeBricks,
			ArrayList<Ball> balls, ArrayList<PowerUp> powUps, ArrayList<Alien> aliens, Player p, Paddle pad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Brick> getRunningModeBricks(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Alien> getRunningModeAliens(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Ball> getRunningModeBalls(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PowerUp> getRunningModePowerUps(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getRunningModePlayer(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paddle getRunningModePaddle(String username) {
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
