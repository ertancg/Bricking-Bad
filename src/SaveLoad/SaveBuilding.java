package SaveLoad;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Player.Player;
import alien.Alien;
import ball.Ball;
import brick.Brick;
import paddle.Paddle;
import powerups.PowerUp;

public class SaveBuilding implements MongoDBAdapter  {
		
	public void saveLocalB(String name,ArrayList<Brick> bmBricks) {
		String filename = name+"_BuildingModeSave";
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename));
			for(int i=0;i<bmBricks.size();i++) {
				Brick b = bmBricks.get(i);
				os.writeObject(b);
			}
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done Saving.");
	}

	public ArrayList<Brick> getBuildingModeComponentsLocal(String username) {
		// TODO Auto-generated method stub
		String filename = username+"_BuildingModeSave";
		ArrayList<Brick> bricks = new ArrayList<Brick>();
			try {
				ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename));
			    Object obj = null;
				while ((obj = is.readObject()) != null) {
					if(obj instanceof Brick) {
					    bricks.add((Brick)obj);
					}
				}
				is.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("Done Loading.");
		return bricks;
	}

	@Override
	public void connectMongoAndSaveBuildingMode(String playername, ArrayList<Brick> buildingModeBricks) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDuplicateUser(String userName) {
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
