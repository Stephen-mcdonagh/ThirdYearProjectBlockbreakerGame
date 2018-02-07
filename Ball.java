

public class Ball 
{
	Game game = new Game();
	public static int BallXPos = 420;
	public static int BallYPos = 400;
	
	public static int Width = 20;
	public static int Height = 20;
	
	public static double BallXDir = -1.0;   //3
	public static double BallYDir = -1.0;//2
	
	public static int getBallXPos()
	{
		return BallXPos;		
	}
	
	public static int getBallYPos()
	{
		return BallYPos;		
	}
	
	public static double getBallXDir()
	{
		return BallXDir;		
	}
	
	public static double getBallYDir()
	{
		return BallYDir;		
	}
	
}
