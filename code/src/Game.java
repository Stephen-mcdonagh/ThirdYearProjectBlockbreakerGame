import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Timer;


import javax.swing.JPanel;
@SuppressWarnings("serial")
public class Game extends JPanel implements KeyListener,ActionListener,MouseListener
{
	
	public static boolean running = false;  //play
	
	public static int score1 = 0;
	public static int lives = 3;
	public static int numOfBalls = 1; 
	
	public static Timer timer;
	public static int levelOneTotalBlocks = 28;
	public static int levelTwoTotalBlocks = 16;
	
	public static int gameDifficulty;
	public static int gameScore = 0 ;
	
	public static String username;
	
	public static boolean gameOver = false;
	
	public static enum STATE
	{
		HOME,
		HIGHSCORES,
		HELP,
		DIFFICULTY,
		LEVEL1,
		LEVEL2
	};
	
	public static STATE myState = STATE.HOME;
	
	public Game()
	{
		new Block(4,7); 
		addKeyListener(this);
		addMouseListener(this);
		setFocusable(true);
		
		if(isRunning())
		{
			timer = new Timer(gameDifficulty,this);
			timer.start();
		}		
	}
	
	//When you lose a life, game restarts
	public static void restartGame()
	{
		Ball.BallXPos = 450;
		Ball.BallYPos = 505;
		Ball.BallXDir = -1.0;
		Ball.BallYDir = -1.0;
		Player.PlayerXPos = 420;
	}
	
	//removes a life from user
	public static int loseLife()
	{
		return lives--;
	}
	
	//User is rewarded with bonus for finishing game with 3 or 2 lives 
	public static int giveUserBonus()
	{
		if(lives == 3)
		{
			gameScore = gameScore +200;
		}
		if(lives == 2)
		{
			gameScore = gameScore + 100;
		}
		return gameScore;
	}
		
	//Put objects onto screen
	public void paint(Graphics g)
	{
		if(!isRunning() && myState == STATE.LEVEL2)
		{
			new Block(4,7);
		}
		
		if(myState == STATE.HOME)
		{
			Screen.renderHome(g);
			repaint();
		}
		if(myState == STATE.HIGHSCORES)
		{
			Screen.renderHighScores(g);
			repaint();
		}
		else if(myState == STATE.HELP)
		{		
			Screen.renderHowToPlay(g);
			repaint();
		}
		else if(myState == STATE.DIFFICULTY)
		{
			Screen.renderDifficulty(g);
			repaint();
		}
		else if(myState == STATE.LEVEL1)
		{
			Screen.renderLevelOne(g);
			repaint();	
		}
		else if(myState ==STATE.LEVEL2)
		{
			Screen.renderLevelTwo(g);
			repaint();
		}
	}
	
	public boolean isRunning()
	{
		return running;
	}
	
	public static void setRunning(boolean isRunning)
	{
		running = isRunning;
	}

	public void actionPerformed(ActionEvent e)
	{
		if(myState == STATE.LEVEL1)
		{
			KeyInput.actionPerformedLevel1();
		}
		if(myState == STATE.LEVEL2)
		{
			KeyInput.actionPerformedLevel2();
		}
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if(myState == STATE.HELP||myState == STATE.HIGHSCORES || myState == STATE.DIFFICULTY ||myState == STATE.LEVEL1 ||myState == STATE.LEVEL2 )
		{
			KeyInput.keyPressed(e);
		}
	}
	
	@Override
	//had to create new method as was "skipping" state difficulty 
	public void mousePressed(MouseEvent e) 
	{
		if(myState == STATE.HOME)
		{
			MouseInput.mousePressedHome(e);	
		}
		else if(myState == STATE.DIFFICULTY)
		{
			MouseInput.mousePressedDifficulty(e);	
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{                       
	}
	
	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub	
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		// TODO Auto-generated method stub	
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		// TODO Auto-generated method stub		
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		// TODO Auto-generated method stub
	}
}
