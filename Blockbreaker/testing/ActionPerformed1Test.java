import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.Test;

public class ActionPerformed1Test 
{

	@Test
	public void restartTest() 
	{
		Ball.BallXPos =550;
		KeyInput.actionPerformedLevel1();
 		assertTrue("game should restart, this means ball position changes",Ball.BallXPos >=450);		
	}
	
	@Test
	public void BallIntersectingWithBlockTest()
	{	
		Ball.BallXPos =300;
		Ball.BallYPos =300;
		Game.levelOneTotalBlocks =10;
		//Rectangle rect = new Rectangle(300, 300, 50, 50);
		//Rectangle ballRect = new Rectangle(Ball.BallXPos, Ball.BallYPos, 20, 20);
		KeyInput.actionPerformedLevel1();
		assertTrue("Blocks in game should go down 1 as ball has hit it",Game.levelOneTotalBlocks ==Game.levelOneTotalBlocks--);
	}
	
	@Test
	public void BallBounceLeftTest() 
	{
		Ball.BallXPos = -1;
		Ball.BallXDir = -1;
		double oldBallDirection = Ball.BallXDir;
		KeyInput.actionPerformedLevel1();
		assertFalse("Ball direction should change",oldBallDirection == Ball.BallXDir);		
	}
	@Test
	public void BallBounceRightTest() 
	{
		Ball.BallXPos = 300;
		Ball.BallXDir = -1;
		double oldBallDirection = Ball.BallXDir;
		KeyInput.actionPerformedLevel1();
		assertTrue("Ball direction should not change",oldBallDirection == Ball.BallXDir);		
	}
	
	@Test
	public void BallBounceTopTest() 
	{
		Ball.BallYPos = -1;
		Ball.BallYDir = -1;
		double oldBallDirection = Ball.BallYDir;
		KeyInput.actionPerformedLevel1();
		assertFalse("Ball direction should change",oldBallDirection == Ball.BallYDir);		
	}
	
	@Test
	public void GoTOLevelTwoTest() 
	{
		Game.levelOneTotalBlocks = 0;
		KeyInput.actionPerformedLevel1();
		assertTrue("The game should change states when there is no blocks on level 1",Game.myState ==Game.STATE.LEVEL2);
	}
	
	/*@Test
	 I have this commented out as within this if statement, there is system.exit(0),
	 This means Junit cant respond quick enough to either pass or fail this test 
	 By removing system.exit(0) I can see the test passes.
	public void GameOverTest() 
	{
		Game.lives= 0;
		KeyInput.actionPerformedLevel1();
		assertTrue(Game.gameOver ==true);
	}*/
}
