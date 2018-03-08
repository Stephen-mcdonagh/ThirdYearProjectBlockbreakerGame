import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.Test;

public class ActionPerformed2Test 
{
	@Test
	public void restartTest() 
	{
		Ball.BallXPos = 550;
		KeyInput.actionPerformedLevel2();
		assertFalse("game should restart, this means ball position changes", Ball.BallXPos < 450);		
	}
	
	@Test
	public void BallIntersectingWithBlockTest()
	{	
		Ball.BallXPos =150;
		Ball.BallYPos =250;
		Game.levelOneTotalBlocks =10;
		Rectangle rect = new Rectangle(150, 250, 50, 50);
		Rectangle ballRect = new Rectangle(Ball.BallXPos, Ball.BallYPos, 20, 20);
		KeyInput.actionPerformedLevel2();
		assertFalse(Game.levelTwoTotalBlocks != Game.levelTwoTotalBlocks--);
	}
	
	@Test
	public void BallBounceLeftTest() 
	{
		Ball.BallXPos = -1;
		Ball.BallXDir = -1;
		double oldBallDirection = Ball.BallXDir;
		KeyInput.actionPerformedLevel2();
		assertFalse("Ball direction should change",oldBallDirection == Ball.BallXDir);		
	}
	
	@Test
	public void BallBounceRightTest() 
	{
		Ball.BallXPos = 300;
		Ball.BallXDir = -1;
		double oldBallDirection = Ball.BallXDir;
		KeyInput.actionPerformedLevel2();
		assertTrue("Ball direction should not change",oldBallDirection == Ball.BallXDir);		
	}
	
	@Test
	public void BallBounceTopTest() 
	{
		Ball.BallYPos = -1;
		Ball.BallYDir = -1;
		double oldBallDirection = Ball.BallYDir;
		KeyInput.actionPerformedLevel2();
		assertFalse("Ball direction should change",oldBallDirection == Ball.BallYDir);		
	}
	
}
