public class Player 
{
	Game game = new Game();
	//position needs to be changed
	public static int PlayerXPos = 420;
	
	//moves paddle to right
	public void goRight()
	{
		if (game.isRunning() == true)
		{
			setPlayerXPos(getBoundsRight());
		}
	}
	
	//moves paddle to left 
	public void goLeft()
	{
		if (game.isRunning() == true)
		{
			setPlayerXPos(getBoundsLeft());
		}	
	}
	
	//gets x position of paddle (y position never changes)
	public static int getPlayerXPos()
	{
		return PlayerXPos;
	}

	public static void setPlayerXPos(int playerXPos) 
	{
		PlayerXPos = playerXPos;
	}
	
	//Need to create bounds methods for left and right hand side
	public int getBoundsLeft()
	{
		return getPlayerXPos() -20;
	}
	
	public int getBoundsRight()
	{
		return getPlayerXPos() +20;
	}	
	//these will be then used in goLeft and goRight methods
	
	//similar methods can be used for the ball	
}