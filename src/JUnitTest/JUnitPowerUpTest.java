package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import factories.PowerUpFactory;
import powerups.DLG;
import powerups.Magnet;



public class JUnitPowerUpTest {

	@Test
	/*
	 * OVERVIEW: Typical DestructiveLaserGun is a powerUp object in BrickingBadGame which satisfies the 
	 * methods in itself.
	 * REQUIRES: DLG is created
	 * MODIFIES: DLG coordinates are changed
	 * EFFECTS: Returns true if representation invariants holds.
	 * 
	 */
	public void testDLG0() {
		DLG temp = (DLG)PowerUpFactory.getPowerUp("DLG");
		temp.setpXCoor(-1);
		temp.setpYCoor(-1);
		assertEquals(temp.repOk(),false);
	}

	@Test
	/*
	 * OVERVIEW: Typical DestructiveLaserGun is a powerUp object in BrickingBadGame which satisfies the 
	 * methods in itself.
	 * REQUIRES: DLG is created
	 * MODIFIES: DLG coordinates are changed
	 * EFFECTS: Returns true if the coordinates changed correctly and the DLG is still
	 * satisfying the representation invariants
	 * 
	 */
	public void testDLG1() {
		DLG temp = (DLG)PowerUpFactory.getPowerUp("DLG");
		temp.setpXCoor(500);
		temp.setpYCoor(500);
		assertEquals(temp.getpXCoor(),500);
		assertEquals(temp.getpYCoor(),500);
		assertEquals(temp.repOk(),true);
	}
	@Test
	/*
	 * OVERVIEW: Typical DestructiveLaserGun is a powerUp object in BrickingBadGame which satisfies the 
	 * methods in itself.
	 * REQUIRES: DLG is created
	 * MODIFIES: Drops the DLG powerUp
	 * EFFECTS: Returns true if DLG dropped correctly
	 * 
	 */
	public void testDLG2() {
		DLG temp = (DLG)PowerUpFactory.getPowerUp("DLG");
		temp.setpXCoor(100);
		temp.setpYCoor(100);
		for(int i =0 ;i<10;i++) {
			temp.drop();
		}
		assertEquals(temp.getpYCoor(),120);
	}
	@Test
	/*
	 * OVERVIEW: Typical DestructiveLaserGun is a powerUp object in BrickingBadGame which satisfies the 
	 * methods in itself.
	 * REQUIRES: A DLG and a Magnet is created
	 * EFFECTS:	Returns true if they are the same object, else false.
	 * 
	 */
	public void testDLG3() {
		DLG temp = (DLG)PowerUpFactory.getPowerUp("DLG");
		Magnet temp1 = (Magnet) PowerUpFactory.getPowerUp("Magnet");
		assertSame(temp,temp1);
	}

}
