import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class KeyInput
{	
	static Game game = new Game();
	static Player player = new Player();

	
	public static void keyPressed(KeyEvent e) 
	{
		int key = e.getKeyCode();
		//allows user to go back if they want
		if(Game.myState == Game.STATE.HELP || Game.myState == Game.STATE.DIFFICULTY|| Game.myState == Game.STATE.HIGHSCORES)
		{
			if(key == KeyEvent.VK_BACK_SPACE)
			{
				Game.myState = Game.STATE.HOME;
			}			
		}
		// move right or left for paddle
		if (Game.myState == Game.STATE.LEVEL1 || Game.myState == Game.STATE.LEVEL2)
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
		}
	}

	
	public static void actionPerformedLevel1()
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
					
					if(ballRect.intersects(rect))
					{
						Block.setBlockValue(0, i, j);
						Game.levelOneTotalBlocks--;
						//different score depending on what the user chooses
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
					
						if(Ball.BallXPos + 19 <= rect.x || Ball.BallXPos + 1 >= rect.x + rect.width)
						{
							Ball.BallXDir = -Ball.BallXDir;
						}
						else
						{
							Ball.BallYDir = -Ball.BallYDir;
						}
						break;				
					}					
				}
			}
		}
		Ball.BallXPos += Ball.BallXDir;
		Ball.BallYPos += Ball.BallYDir;
		
		//Bounce left boarder
		if(Ball.BallXPos < 0)
		{
			Ball.BallXDir = -Ball.BallXDir;
		}
		
		//Bounce top
		if(Ball.BallYPos < 0)
		{
			Ball.BallYDir = -Ball.BallYDir;
		}
		
		//Bounce right
		if(Ball.BallXPos > 690)
		{
			Ball.BallXDir = -Ball.BallXDir;
		}
		
		//bottom game should restart, player loses a life
		if(Ball.BallYPos >550)
		{
			Game.loseLife();
			Game.restartGame();
		}
		
		//Go from level 1 to level 2 
		if(Game.levelOneTotalBlocks == 0) // will be changed to 0 when working
		{
			Game.myState = Game.STATE.LEVEL2;
			Game.restartGame();		
			Game.setRunning(false);
		}
		
		//user runs out of lives Game over 
		if(Game.lives ==0 )
		{
			Game.gameOver =true;
			ConnectionManager.addNewEntryToDatabase(Game.gameScore,Game.username);
			ConnectionManager.readHighScore();
			System.exit(0);
		}
	}
	
	public static void actionPerformedLevel2()
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
					
					if(ballRect.intersects(rect))
					{
						Block.setBlockValue(0, i, j);
						Game.levelTwoTotalBlocks--;
						//different score depending on what the user chooses
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
					
						if(Ball.BallXPos + 19 <= rect.x || Ball.BallXPos + 1 >= rect.x + rect.width)
						{
							Ball.BallXDir = -Ball.BallXDir;
						}
						else
						{
							Ball.BallYDir = -Ball.BallYDir;
						}
						break;				
					}					
				}
			}
		}
		if(game.isRunning())
		{
			Ball.BallXPos += Ball.BallXDir;
			Ball.BallYPos += Ball.BallYDir;
		}
	
		//Bounce left boarder
		if(Ball.BallXPos < 0)
		{
			Ball.BallXDir = -Ball.BallXDir;
		}
		
		//Bounce top
		if(Ball.BallYPos < 0)
		{
			Ball.BallYDir = -Ball.BallYDir;
		}
		
		//Bounce right
		if(Ball.BallXPos > 690)
		{
			Ball.BallXDir = -Ball.BallXDir;
		}
		
		//bottom game should restart, player loses a life
		if(Ball.BallYPos >550)
		{
			Game.loseLife();
			Game.restartGame();
		}
		//no more levals left
		if(Game.levelTwoTotalBlocks ==0)
		{
			Game.giveUserBonus();
			Game.gameOver = true;
		}
		//Game over 
		if(Game.lives ==0 || Game.gameOver ==true)
		{
			Game.gameOver =true;
			ConnectionManager.addNewEntryToDatabase(Game.gameScore,Game.username);
			ConnectionManager.readHighScore();
			System.exit(0);
		}
	}
}
