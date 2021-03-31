package JUnitTest;
import static org.junit.Assert.*;

import org.junit.Test;


import brick.SimpleBrick;
import brick.WrapperBrick;
import factories.BrickFactory;

public class JUnitBrickTest {
	

	@Test
	/*
	 * OVERVIEW: Typical Wrapper Brick is a brick object in BrickingBadGame which satisfies the 
	 * methods in itself.
	 * REQUIRES: A brick object is created.
	 * MODIFIES: The bricks coordinates are changed.
	 * EFFECTS: Returns true if representation invariants holds.
	 * 
	 */
	public void testWrapperBrick0() {
		WrapperBrick temp = (WrapperBrick)BrickFactory.getBrick("WrapperBrick");
		temp.setBrickXCoor(-1);
		temp.setBrickYCoor(-1);
		assertEquals(temp.repOk(),false);
	}
	
	@Test
	/*
	 * OVERVIEW: Typical Wrapper Brick is a brick object in BrickingBadGame which satisfies the 
	 * methods in itself.
	 * REQUIRES: A brick object is created
	 * EFFECTS: Returns true if the length of the brick is correct
	 * 
	 */
	public void testWrapperBrick1() {
		assertEquals(WrapperBrick.getLength(),70);
	}
	@Test
	/*
	 * OVERVIEW: Typical Wrapper Brick is a brick object in BrickingBadGame which satisfies the 
	 * methods in itself.
	 * REQUIRES: A brick object is created
	 * MODIFIES: The bricks coordinates are changed
	 * EFFECTS:	Returns true if the coordinates changed correctly and the brick is still
	 * satisfying the representation invariants
	 * 
	 */
	public void testWrapperBrick2() {
		WrapperBrick temp = (WrapperBrick)BrickFactory.getBrick("WrapperBrick");
		temp.setBrickXCoor(500);
		temp.setBrickYCoor(500);
		assertEquals(temp.getBrickXCoor(),500);
		assertEquals(temp.getBrickYCoor(),500);
		assertEquals(temp.repOk(),true);
	}
	@Test
	/*
	 * OVERVIEW: Typical Wrapper Brick is a brick object in BrickingBadGame which satisfies the 
	 * methods in itself.
	 * REQUIRES: A SimpleBrick and a WrapperBrick is created
	 * EFFECTS:	Returns true if they are the same object, else false.
	 * 
	 */
	public void testWrapperBrick3() {
		WrapperBrick temp0 = (WrapperBrick)BrickFactory.getBrick("WrapperBrick");
		SimpleBrick temp1 = (SimpleBrick)BrickFactory.getBrick("SimpleBrick");
		assertSame(temp0,temp1);
	}
	
}
