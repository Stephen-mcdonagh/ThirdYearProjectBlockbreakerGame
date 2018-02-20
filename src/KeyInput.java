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
		if(Game.myState == Game.STATE.HOWTOPLAY || (Game.myState == Game.STATE.DIFFICULTY))
		{
			if(key == KeyEvent.VK_BACK_SPACE)
			{
				System.out.print("back pressed");
				Game.myState = Game.STATE.HOME;
			}			
		}
	
		if (Game.myState == Game.STATE.LEVEL1)
		{
			
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
			//Release new ball feature using B key ,
			/*if(Game.score >200)
			{
				if(key == KeyEvent.VK_B)
				{
				// release a new ball 
				//press button b
				Game.numOfBalls ++ ;		
				}
			}*/
		}
	}
	
	public static void actionPerformed()
	{
		Config config = new Config();
		
		if(new Rectangle(Ball.BallXPos,Ball.BallYPos,20,20).intersects(new Rectangle(Player.PlayerXPos,525,120,10)))
		{
			Ball.BallYDir = -Ball.BallYDir;
		}
		 for(int i = 0; i < Block.blocks.length; i++)
		{
			for(int j = 0; j < Block.blocks[0].length; j++)
			{
				if(Block.blocks[i][j] > 0)
				{
					int brickX = j * Block.brickWidth + 80;
					int brickY = i * Block.brickHeight + 50;
					int brickWidth = Block.brickWidth;
					int brickHeight = Block.brickHeight;
					
					Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
					Rectangle ballRect = new Rectangle(Ball.BallXPos, Ball.BallYPos, 20, 20);
					//No need for this line
					//Rectangle brickRect = rect;
					
					if(ballRect.intersects(rect))
					{
						Block.setBrickValue(0, i, j);
						Game.levelOneTotalBlocks--;
						if(MouseInput.difficultyChoice == 1)
						{
							Game.gameScore = Game.gameScore + Integer.parseInt(config.getProperty("easyScore"));
							
						}
						if(MouseInput.difficultyChoice == 2)
						{
							Game.gameScore = Game.gameScore + Integer.parseInt(config.getProperty("mediumScore"));

						}
						if(MouseInput.difficultyChoice == 3)
						{
							Game.gameScore = Game.gameScore + Integer.parseInt(config.getProperty("hardScore"));

						}
					
						if(Ball.BallXPos + 19 <= rect.x || Ball.BallYPos + 1 >= rect.x + rect.width)
							Ball.BallXDir = -Ball.BallXDir;
						else
							Ball.BallYDir = -Ball.BallYDir;
						break;				
					}					
				}
			}
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
		if(Ball.BallXPos > 690)
		{
			Ball.BallXDir = -Ball.BallXDir;
		}
		//bottom
		if(Ball.BallYPos >550)
		{
			Ball.BallYDir = -Ball.BallYDir; // dont bounce back
			Game.lives --;
			//TODO: restart game, wait for user to press a button
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
