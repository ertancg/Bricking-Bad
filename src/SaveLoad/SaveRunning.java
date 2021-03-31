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

public class SaveRunning implements MongoDBAdapter{

	public void saveLocal(ArrayList<Brick> bmBricks,ArrayList<Ball> balls,
					      ArrayList<PowerUp> powUps,ArrayList<Alien> aliens, Player p,Paddle pad,String username) {
		String filename = username+"_RunningModeSave";
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename));
			for(int i=0;i<bmBricks.size();i++) {
				Brick b0 = bmBricks.get(i);
				os.writeObject(b0);
			}
			for(int j=0;j<balls.size();j++) {
				Ball b1 = balls.get(j);
				os.writeObject(b1);
			}
			for(int k = 0;k< powUps.size();k++) {
				PowerUp p1 = powUps.get(k);
				os.writeObject(p1);
			}
			for(int h = 0;h< aliens.size();h++) {
				Alien a1 = aliens.get(h);
				os.writeObject(a1);
			}
			os.writeObject(pad);
			os.writeObject(p);
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
	public ArrayList<Brick> runModeBricks(String username){
		String filename = username+"_RunningModeSave";
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
		System.out.println("Done Loading Bricks.");
		return bricks;
	}
	//TODO
	public ArrayList<Ball> runModeBalls(String username){
		String filename = username+"_RunningModeSave";
		ArrayList<Ball> balls = new ArrayList<Ball>();
			try {
				ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename));
			    Object obj = null;
				while ((obj = is.readObject()) != null) {
					if(obj instanceof Ball) {
					    balls.add((Ball)obj);
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
		System.out.println("Done Loading Balls.");
		return balls;
	}
	public ArrayList<Alien> runModeAliens(String username){
		String filename = username+"_RunningModeSave";
		ArrayList<Alien> aliens = new ArrayList<Alien>();
			try {
				ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename));
			    Object obj = null;
				while ((obj = is.readObject()) != null) {
					if(obj instanceof Alien) {
					    aliens.add((Alien)obj);
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
		System.out.println("Done Loading Aliens.");
		return aliens;
	}
	public ArrayList<PowerUp> runModePowerUps(String username){
		String filename = username+"_RunningModeSave";
		ArrayList<PowerUp> powup = new ArrayList<PowerUp>();
			try {
				ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename));
			    Object obj = null;
				while ((obj = is.readObject()) != null) {
					if(obj instanceof PowerUp) {
					    powup.add((PowerUp)obj);
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
		System.out.println("Done Loading PowerUps.");
		return powup;
	}
	public Player runModePlayer(String username){
		String filename = username+"_RunningModeSave";
			try {
				ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename));
			    Object obj = null;
			    Player p1 = new Player(-1,-1,-1,-1,-1,-1,-1,-1);
				while ((obj = is.readObject()) != null) {
					if(obj instanceof Player) {
					    p1 = (Player) obj;
					    return p1;
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
		System.out.println("Done Loading Player.");
		return null;
	}
	public Paddle runModePaddle(String username){
		String filename = username+"_RunningModeSave";
			try {
				ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename));
			    Object obj = null;
			    Paddle p = null;
				while ((obj = is.readObject()) != null) {
					if(obj instanceof Paddle) {
					    p = (Paddle) obj;
					    return p;
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
		System.out.println("Done Loading Paddle.");
		return null;
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
	public void saveLocalB(String name, ArrayList<Brick> bmBricks) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<Brick> getBuildingModeComponentsLocal(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
