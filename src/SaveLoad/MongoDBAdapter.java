package SaveLoad;

import java.util.ArrayList;

import Player.Player;
import alien.Alien;
import ball.Ball;
import brick.Brick;
import paddle.Paddle;
import powerups.PowerUp;

public interface MongoDBAdapter {
	public void connectMongoAndSaveBuildingMode(String playername,ArrayList<Brick> buildingModeBricks);
	public void deleteDuplicateUser(String userName);
	public void displayTheDatabase();
	public ArrayList<Brick> getBuildingModeComponentsMongo(String username);
	public void connectMongoAndSaveRunningMode(String playername,ArrayList<Brick> buildingModeBricks,ArrayList<Ball> balls,
			   ArrayList<PowerUp> powUps,ArrayList<Alien> aliens, Player p,Paddle pad);
	public ArrayList<Brick> getRunningModeBricks(String username);
	public ArrayList<Alien> getRunningModeAliens(String username);
	public ArrayList<Ball> getRunningModeBalls(String username);
	public ArrayList<PowerUp> getRunningModePowerUps(String username);
	public Player getRunningModePlayer(String username);
	public Paddle getRunningModePaddle(String username);
	public void saveLocalB(String name,ArrayList<Brick> bmBricks);
	public ArrayList<Brick> getBuildingModeComponentsLocal(String username);
	public void saveLocal(ArrayList<Brick> bmBricks,ArrayList<Ball> balls,
		      ArrayList<PowerUp> powUps,ArrayList<Alien> aliens, Player p,Paddle pad,String username);
	public ArrayList<Brick> runModeBricks(String username);
	public ArrayList<Alien> runModeAliens(String username);
	public ArrayList<PowerUp> runModePowerUps(String username);
	public Player runModePlayer(String username);
	public Paddle runModePaddle(String username);
}
