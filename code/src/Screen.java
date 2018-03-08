import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;


public class Screen 
{
	public static Rectangle PlayButton = new Rectangle(260,150,220,50);
	public static Rectangle HighScoresButton = new Rectangle(260,250,220,50);
	public static Rectangle HelpButton = new Rectangle(260,350,220,50);
	
	public static Rectangle EasyButton = new Rectangle(260,150,220,50);
	public static Rectangle IntermediateButton = new Rectangle(260,250,220,50);
	public static Rectangle HardButton = new Rectangle(260,350,220,50);
	
	
	public static void renderHome(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g ;
		g.setColor(Color.black);
		g.fillRect(0, 0, 720, 600);
		//displayBackground();
		//BufferedImage image = displayBackground();
		//g.drawImage(image, 720, 600, null);
		
		Font fnt0 = new Font("ariel",Font.BOLD,50);
		g.setFont(fnt0);
		g.setColor(Color.WHITE);
		g.drawString("BlockBreaker", 200, 100);
		
		
		Font fnt1 = new Font("ariel",Font.BOLD,28);
		g.setFont(fnt1);
		
		g.setColor(Color.RED);	
		g.fillRect(260,150,220,50);
		g.setColor(Color.black);		
		g.drawString("PLAY",PlayButton.x+70 , PlayButton.y+40);		
		g2d.draw(PlayButton);
		
		g.setColor(Color.green);
		g.fillRect(260,250,220,50);
		g.setColor(Color.black);
		g.drawString("HIGHSCORES",HighScoresButton.x +10 , HighScoresButton.y+40);
		g2d.draw(HighScoresButton);
		
		g.setColor(Color.blue);
		g.fillRect(260,350,220,50);
		g.setColor(Color.black);
		g.drawString("HELP",HelpButton.x+70 , HelpButton.y+40);
		g2d.draw(HelpButton);
		
	}
	
	//will display top scores in game
	public static void renderHighScores(Graphics g)
	{		
		int y = 200;
    	LinkedList<String> myHighScores = new LinkedList<String>();
		g.setColor(Color.black);
		g.fillRect(0, 0, 720, 600);
		
		Font fnt0 = new Font("ariel",Font.BOLD,50);
		g.setFont(fnt0);
		g.setColor(Color.WHITE);
		g.drawString("Highscores", 200, 100);
		
		Font fnt1 = new Font("ariel",Font.BOLD,28);
		g.setFont(fnt1);
		g.setColor(Color.WHITE);
		myHighScores = ConnectionManager.readHighScore();
		g.drawString("NAME", 200, 150);
		g.drawString("SCORE", 400, 150);
		
		g.drawRect(150, 112, 200, 50);
		g.drawRect(150, 160, 200, 50);
		g.drawRect(150, 212, 200, 50);
		g.drawRect(150, 264, 200, 50);
		g.drawRect(150, 316, 200, 50);
		g.drawRect(150, 368, 200, 50);
		
		g.drawRect(350, 112, 200, 50);
		g.drawRect(350, 160, 200, 50);
		g.drawRect(350, 212, 200, 50);
		g.drawRect(350, 264, 200, 50);
		g.drawRect(350, 316, 200, 50);
		g.drawRect(350, 368, 200, 50);
		int number =0;
		while(number < myHighScores.size()) 
		{
			String first = myHighScores.get(number);
			number++;
			String second = myHighScores.get(number);
			number++;
			g.drawString(first, 200, y);
			g.drawString(second, 400, y);
			y = y+50;	  
		}		
	}

	//will give user instructions on how to play 
	public static void renderHowToPlay(Graphics g)
	{				
			g.setColor(Color.black);
			g.fillRect(0, 0, 720, 600);
			
			Font fnt0 = new Font("ariel",Font.BOLD,50);
			g.setFont(fnt0);
			g.setColor(Color.WHITE);
			g.drawString("How to play", 200, 100);
			
			Font fnt1 = new Font("ariel",Font.BOLD,30);
			g.setFont(fnt1);
			g.setColor(Color.RED);
			g.drawString("Objective", 90, 150);
			
			Font fnt2 = new Font("ariel",Font.BOLD,15);
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawString("The aim of the game is to destroy all the blocks coloured yellow without losing all", 90, 180);
			g.drawString("the lives by missing the ball and allowing it to hit the bottom. Destroying all the ", 90, 200);
			g.drawString("blocks will take you to level 2 with the same amount of blocks. Destroying all the", 90, 220);
			g.drawString("level 2 blocks means you have completed the game and your high score is recorded ", 90, 240);
			
			g.setFont(fnt1);	
			g.setColor(Color.RED);
			g.drawString("Controls", 90, 280);	
					
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawString("To begin the game click “PLAY” with your mouse and enter your name.", 90, 300);
			g.drawString("Then choose your desired difficulty and press and key to start.", 90, 320);
			g.drawString("Left key (<-) moves the paddle left and the right key (->) moves the paddle right.", 90, 340);

			
			g.setFont(fnt1);	
			g.setColor(Color.RED);
			g.drawString("Score", 90, 380);	
			
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawString("The score is calulated based on the difficulty and how many blocks a user destroys.", 90, 400);
			g.drawString("In easy, each block that is destroyed counts for 10 points, 15 for intermediate and ", 90, 420);
			g.drawString("20 for hard. If a user completes the game with 3 lives to spare they are", 90, 440);
			g.drawString("given an extra 200 points and 100 points if 2 lives to spare", 90, 460);

			
		
	}
	
	//puts onto screen different difficulty options for user
	public static void renderDifficulty(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g ;
		
		g.setColor(Color.black);
		g.fillRect(0, 0, 720, 600);
		Font fnt0 = new Font("ariel",Font.BOLD,50);
		g.setFont(fnt0);
		g.setColor(Color.WHITE);
		g.drawString("Choose Difficulty", 160, 100);
		
		g.setColor(Color.RED);	
		g.fillRect(260,150,220,50);
		g.setColor(Color.black);	
		Font fnt1 = new Font("ariel",Font.BOLD,28);
		g.setFont(fnt1);
		g.drawString("EASY",EasyButton.x+70 , EasyButton.y+40);
		g2d.draw(EasyButton);
		
		g.setColor(Color.green);
		g.fillRect(260,250,220,50);
		g.setColor(Color.black);
		g.drawString("INTERMEDIATE",IntermediateButton.x +5 , IntermediateButton.y+40);
		g2d.draw(IntermediateButton);
		
		g.setColor(Color.blue);
		g.fillRect(260,350,220,50);
		g.setColor(Color.black);
		g.drawString("HARD",HardButton.x+70 , HardButton.y+40);
		g2d.draw(HardButton);
	}
	
	//draws first level 
	public static void renderLevelOne(Graphics g)
	{
		//background
		g.setColor(Color.black);
		g.fillRect(0, 0, 720, 600);
		
		//ball
		g.setColor(Color.green);
		g.fillOval(Ball.getBallXPos(),Ball.getBallYPos(),20,20);
		
		//paddle
		g.setColor(Color.red);
		g.fillRect(Player.getPlayerXPos(), 530, 120, 10);
		
		//blocks
		Block.drawLevelOne((Graphics2D)g);
		
		//Score
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.BOLD,25));
		g.drawString("" + Game.gameScore, 590, 30);
		
		//Lives
		g.setColor(Color.red);
		g.drawString("Lives = " + Game.lives, 30, 30);
		
		
		g.dispose();		
		Game.setRunning(true);
	}
	
	//draws second level
	public static void renderLevelTwo(Graphics g)
	{
		//background
		g.setColor(Color.black);
		g.fillRect(0, 0, 720, 600);
		
		//ball
		g.setColor(Color.green);
		g.fillOval(Ball.getBallXPos(),Ball.getBallYPos(),20,20);
		
		//paddle
		g.setColor(Color.red);
		g.fillRect(Player.getPlayerXPos(), 525, 120, 10);
		
		//blocks
		Block.drawLevelTwo((Graphics2D)g);
		
		//Score
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.BOLD,25));
		g.drawString("" + Game.gameScore, 590, 30);
		
		//Lives
		g.setColor(Color.red);
		g.drawString("Lives = " + Game.lives, 30, 30);
	
		g.dispose();		
		Game.setRunning(true);
	}
}
