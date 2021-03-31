package Player;

import java.io.Serializable;

public class Player implements Serializable {

	private String name;
	private int magnet;
	private int chemball;
	private int fireball;
	private int dlg;
	private int gob;
	private int tallp;
	private int score;
	private int noOfLives = 3;
	

	public Player(int magnet, int chemball, int fireball, int dlg, int gob, int tallp, int score,
			      int noOfLives) {
		super();
		this.magnet = magnet;
		this.chemball = chemball;
		this.fireball = fireball;
		this.dlg = dlg;
		this.gob = gob;
		this.tallp = tallp;
		this.score = score;
		this.noOfLives = noOfLives;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMagnet() {
		return magnet;
	}

	public void setMagnet(int magnet) {
		this.magnet = magnet;
	}

	public int getChemball() {
		return chemball;
	}

	public void setChemball(int chemball) {
		this.chemball = chemball;
	}

	public int getFireball() {
		return fireball;
	}

	public void setFireball(int fireball) {
		this.fireball = fireball;
	}

	public int getDlg() {
		return dlg;
	}

	public void setDlg(int dlg) {
		this.dlg = dlg;
	}

	public int getGob() {
		return gob;
	}

	public void setGob(int gob) {
		this.gob = gob;
	}

	public int getTallp() {
		return tallp;
	}

	public void setTallp(int tallp) {
		this.tallp = tallp;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getNoOfLives() {
		return noOfLives;
	}

	public void setNoOfLives(int noOfLives) {
		this.noOfLives = noOfLives;
	}
	
	
	
	
	
}
