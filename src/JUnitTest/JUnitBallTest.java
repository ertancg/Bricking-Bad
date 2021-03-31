package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ball.Ball;
import paddle.Paddle;



public class JUnitBallTest {

	@Test
	/*
	 * OVERVIEW: Typical Ball is an object in BrickingBadGame which satisfies the 
	 * methods in itself.
	 * REQUIRES: Ball is created 
	 * EFFECTS: Returns true if representation invariants holds.
	 * 
	 */
	public void testBall0() {
		Ball temp = new Ball(-1,-1,-1,-1,-1);
		assertEquals(temp.repOk(),false);
	}
	@Test
	/*
	 * OVERVIEW: Typical Ball is an object in BrickingBadGame which satisfies the 
	 * methods in itself.
	 * REQUIRES: Ball is created
	 * MODIFIES: Ball coordinates are changed
	 * EFFECTS: Returns true if the coordinates changed correctly and the Ball is still
	 * satisfying the representation invariants
	 * 
	 */
	public void testBall1() {
		Ball temp = new Ball(-1,-1,-1,-1,0);
		for(int i=0;i<100;i++) {
			temp.setBallXcoor(temp.getBallXcoor()+1);
			temp.setBallYcoor(temp.getBallYcoor()+1);
		}
		assertEquals(temp.getBallXcoor(),99);
		assertEquals(temp.getBallYcoor(),99);
		assertEquals(temp.repOk(),true);		
	}
	@Test
	/*
	 * OVERVIEW: Typical Ball is an object in BrickingBadGame which satisfies the 
	 * methods in itself.
	 * REQUIRES: Ball is created
	 * MODIFIES: Ball's X direction changed
	 * EFFECTS: Returns true if the ball's X coordinate changed
	 * 
	 */
	public void testBall2() {
		Ball temp = new Ball(100,100,-1,-2,0);
		temp.setBallXdir(99);
		assertEquals(temp.getBallXdir(),99);
	}
	@Test
	/*
	 * OVERVIEW: Typical Ball is an object in BrickingBadGame which satisfies the 
	 * methods in itself.
	 * MODIFIES: A ball and a paddle is created
	 * EFFECTS: Returns true if they are the same object, else false.
	 * 
	 */
	public void testBall3() {
		Ball temp = new Ball(100,100,-1,-2,0);
		Paddle temp1 = new Paddle(0,0,0,0);
		assertSame(temp,temp1);
	}
	

}
