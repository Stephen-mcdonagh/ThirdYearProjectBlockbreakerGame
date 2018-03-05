import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerMovingTest 
{
	@SuppressWarnings("static-access")
	@Test
	public void MovetestRight() 
	{
		//checking the go right method works as it should
		Player newPlayer = new Player();
		newPlayer.PlayerXPos = 400;
		Game.running = true;
		newPlayer.goRight();
		//Move right should move player right by 20
		assertEquals(420,newPlayer.getPlayerXPos());	
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void MovetestLeft() 
	{
		//checking the go left method works as it should
		Player newPlayer = new Player();
		newPlayer.PlayerXPos = 400;
		Game.running = true;
		newPlayer.goLeft();
		//Move right should move player right by 20
		assertEquals(380,newPlayer.getPlayerXPos());	
	}
	@SuppressWarnings("static-access")
	@Test
	public void MovetestRight2() 
	{
		//checking the go left method works as it should
		Player newPlayer = new Player();
		newPlayer.PlayerXPos = 400;
		Game.running = true;
		newPlayer.goRight();
		//Move right should move player right by 20
		assertFalse("negative test to show goRight method doesnt go left",newPlayer.getPlayerXPos() == 380);	
	}
}
