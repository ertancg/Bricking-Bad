package JUnitTest;

public class TestPlan {
	
	enum MethodsToBeTested{
		Alien_RepOk,
		Alien_Length,
		Alien_Set_Get_Coordinates,
		Alien_AssertSame,
		Ball_RepOK,
		Ball_Set_Get_Coordinates,
		Ball_Direciton_Set,
		Ball_AssertSame,
		Brick_RepOk,
		Brick_Length,
		Brick_Set_Get_Coordinates,
		Brick_AssertSame,
		Paddle_RepOk,
		Paddle_Width,
		Paddle_Set_Get_Coordinates,
		Paddle_AssertSame,
		PowerUp_RepOk,
		PowerUP_Set_Get_Coordinates,
		PowerUp_DropTest,
		PowerUp_AssertSame
	}
	 public static void main(String[] args) {
		 for(MethodsToBeTested test :MethodsToBeTested.values()) {
			 System.out.println(test+ " is going to be tested.");
		 }
	 }
}
