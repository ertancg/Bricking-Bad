package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ball.Ball;
import paddle.Paddle;



public class JUnitPaddleTest {

	@Test
	/*
	 * OVERVIEW: Typical Paddle is a paddle object in BrickingBadGame which satisfies the 
	 * methods in itself.
	 * REQUIRES: A paddle is created
	 * MODIFIES: Paddle's X and Y coordinates are modified
	 * EFFECTS: Returns true if representation invariants holds.
	 * 
	 */
	public void testPaddle0() {
		Paddle temp = new Paddle(0,0,0,0);
		temp.setPaddleXCoordinate(-100);
		temp.setPaddleYCoordinate(-100);
		assertEquals(temp.repOk(),false);
	}
	@Test
	/*
	 * OVERVIEW: Typical Paddle is a paddle object in BrickingBadGame which satisfies the 
	 * methods in itself.
	 * REQUIRES: A Paddle is created
	 * EFFECTS: Returns true if the width of the Paddle is correct
	 *   
	 */
	public void testPaddle1() {
		assertEquals(Paddle.getWidthPaddle(),20);
	}
	@Test
	/*
	 * OVERVIEW: Typical Paddle is a paddle object in BrickingBadGame which satisfies the 
	 * methods in itself.
	 * REQUIRES: A Paddle is created
	 * MODIFIES: Paddle coordinates are changed
	 * EFFECTS: Returns true if the coordinates changed correctly and the Paddle is still
	 * satisfying the representation invariants
	 * 
	 */
	public void testPaddle2() {
		Paddle temp = new Paddle(0,0,0,0);
		for(int i=0;i<100;i++) {
			temp.setPaddleXCoordinate(temp.getPaddleXCoordinate()+1);
		}
		assertEquals(temp.getPaddleXCoordinate(),100);
		assertEquals(temp.repOk(),true);
	}
	@Test
	/*
	 * OVERVIEW: Typical Paddle is a paddle object in BrickingBadGame which satisfies the 
	 * methods in itself.
	 * REQUIRES: A Paddle and a Ball is created
	 * EFFECTS:	Returns true if they are the same object, else false. 
	 * 
	 */
	public void testPaddle3() {
		Paddle temp = new Paddle(0,0,0,0);
		Ball temp1 = new Ball(0,0,0,0,0);
		assertSame(temp,temp1);
	}
	
}
