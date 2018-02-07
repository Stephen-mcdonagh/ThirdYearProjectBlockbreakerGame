
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class KeyInput
{
	
	static Game game = new Game();
	static Player player = new Player();



	// move right or left for paddle
	public static void keyPressed(KeyEvent e) 
	{
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT)
		{
			if(Player.getPlayerXPos() >= 600)
			{
				Player.setPlayerXPos(600);
			}
			else
			{
				player.goRight();
			}
		}
		if(key == KeyEvent.VK_LEFT)
		{
			if(Player.getPlayerXPos() <= 10)
			{
				Player.setPlayerXPos(0);
			}
			else
			{
				player.goLeft();
			}
		}
	}
	
	public static void actionPerformed()
	{

		if(new Rectangle(Ball.BallXPos,Ball.BallYPos,20,20).intersects(new Rectangle(Player.PlayerXPos,550,100,8)))
		{
			Ball.BallYDir = -Ball.BallYDir;
		}
		Ball.BallXPos += Ball.BallXDir;
		Ball.BallYPos += Ball.BallYDir;
		//left boarder
		if(Ball.BallXPos < 0)
		{
			Ball.BallXDir = -Ball.BallXDir;
		}
		//top
		if(Ball.BallYPos < 0)
		{
			Ball.BallYDir = -Ball.BallYDir;
		}
		//right
		if(Ball.BallXPos > 700)
		{
			Ball.BallXDir = -Ball.BallXDir;
		}
	}

	/*public static void keyReleased(KeyEvent e) 
	{
		if(Game.running=true) 
		{
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_SPACE)
			{
				while(Game.running)
				{
					if(new Rectangle(Ball.BallXPos,Ball.BallYPos,20,20).intersects(new Rectangle(Player.PlayerXPos,550,100,8)))
					{
						Ball.BallYDir = -Ball.BallYDir;
					}
					Ball.BallXPos += Ball.BallXDir;
					Ball.BallYPos += Ball.BallYDir;
					//left boarder
					if(Ball.BallXPos < 0)
					{
						Ball.BallXDir = -Ball.BallXDir;
					}
					//top
					if(Ball.BallYPos < 0)
					{
						Ball.BallYDir = -Ball.BallYDir;
					}
					//right
					if(Ball.BallXPos > 700)
					{
						Ball.BallXDir = -Ball.BallXDir;
					}
				}
			}
		}
	}*/
}
