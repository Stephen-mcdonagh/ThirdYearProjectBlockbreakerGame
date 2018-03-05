import static org.junit.Assert.*;

import org.junit.Test;

public class BonusTest {

	@Test
	public void testGiveUserBonus() 
	{
		//user gets 200 points extra for having 2 lives
		Game.gameScore = 500;
		Game.lives = 3;
		int result = Game.giveUserBonus();
		assertEquals("user gets 200 points extra for having 2 lives",700,result);
	}
	@Test
	public void testGiveUserBonus2() 
	{
		//user gets 100 points extra for having 2 lives
		Game.gameScore = 500;
		Game.lives = 2;
		int result = Game.giveUserBonus();
		assertEquals("user gets 100 points extra for having 2 lives",600,result);
	}
	@Test
	public void testGiveUserBonus3() 
	{
		//user doesnt get bonus if they only have 1 life
		Game.gameScore = 500;
		Game.lives = 1;
		int result = Game.giveUserBonus();
		assertFalse("user gets no extra points for having 1 life left, result should be 500",result == 600);
	}
}
