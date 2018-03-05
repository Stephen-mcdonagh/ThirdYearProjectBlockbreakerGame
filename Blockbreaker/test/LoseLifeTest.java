import static org.junit.Assert.*;

import org.junit.Test;

public class LoseLifeTest {

	@Test
	public void LoseLifetest() {
		Game.lives = 3;
		Game.loseLife();
		assertEquals("user should be 1 life down",Game.lives,2);
	}
	@Test
	public void LoseLifetest2() {
		Game.lives = 2;
		Game.loseLife();
		assertFalse("user should be 1 life down",Game.lives==2);
	}
	@Test
	public void LoseLifetest3() 
	{
		Game.lives =1;
		Game.loseLife();
		assertEquals(Game.lives,0);
	}
}
