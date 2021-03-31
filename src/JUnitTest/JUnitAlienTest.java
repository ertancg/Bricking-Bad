package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import alien.CooperativeAlien;
import alien.ProtectingAlien;
import factories.AlienFactory;


public class JUnitAlienTest {

	@Test
	/*
	 * OVERVIEW: Typical ProtectingAlien is a BrickingBadGame object which satisfies the method in 
	 * itself.
	 * REQUIRES: An Alien object is created
	 * MODIFIES: The aliens coordinates are changed 
	 * EFFECTS: Returns true if representation invariants holds.
	 * 
	 */
	public void testProtectingAlien0() {
		ProtectingAlien temp = (ProtectingAlien)AlienFactory.getAlien("ProtectingAlien");
		temp.setAlienXCoor(-1);
		temp.setAlienYCoor(-1);
		assertEquals(temp.repOk(),false);
	}
	@Test
	/*
	 * OVERVIEW: Typical ProtectingAlien is a BrickingBadGame object which satisfies the method in 
	 * itself.
	 * REQUIRES: An Alien object is created
	 * EFFECTS:	Returns true if the length of the alien is correct
	 * 
	 */
	public void testProtectingAlien1() {
		ProtectingAlien temp = (ProtectingAlien)AlienFactory.getAlien("ProtectingAlien");
		assertEquals(temp.getLength(),50);
	}
	@Test
	/*
	 * OVERVIEW: Typical ProtectingAlien is a BrickingBadGame object which satisfies the method in 
	 * itself.
	 * REQUIRES: An Alien object is created
	 * MODIFIES: The Aliens coordinates are modified
	 * EFFECTS: Returns true if the coordinates changed correctly and the ProtectingAlien is still
	 * satisfying the representation invariants
	 */
	public void testProtectingAlien2() {
		ProtectingAlien temp = (ProtectingAlien)AlienFactory.getAlien("ProtectingAlien");
		temp.setAlienXCoor(400);
		temp.setAlienYCoor(400);
		assertEquals(temp.getAlienXCoor(),400);
		assertEquals(temp.getAlienYCoor(),400);
		assertEquals(temp.repOk(),true);
	}
	@Test
	/*
	 * OVERVIEW: Typical ProtectingAlien is a BrickingBadGame object which satisfies the method in 
	 * itself.
	 * REQUIRES: A ProtectingAlien and a CooperativeAlien is created 
	 * EFFECTS: Returns true if they are the same object, else false
	 */
	public void testProtectingAlien3() {
		ProtectingAlien temp = (ProtectingAlien)AlienFactory.getAlien("ProtectingAlien");
		CooperativeAlien temp1 = (CooperativeAlien)AlienFactory.getAlien("CooperativeAlien");
		assertSame(temp,temp1);
	}
	

}
