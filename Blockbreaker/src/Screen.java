import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Screen 
{
	public static Rectangle PlayButton = new Rectangle(260,150,220,50);
	public static Rectangle HighScoresButton = new Rectangle(260,250,220,50);
	public static Rectangle HelpButton = new Rectangle(260,350,220,50);
	
	public static Rectangle EasyButton = new Rectangle(260,150,220,50);
	public static Rectangle IntermediateButton = new Rectangle(260,250,220,50);
	public static Rectangle HardButton = new Rectangle(260,350,220,50);
	
	//private static BufferedImage image;
	
	/*public static BufferedImage displayBackground()
	{
		//TODO: fix problem - not working 
		try 
		{
			BufferedImage image = ImageIO.read(new File("res/projectBackground.png"));
			System.out.println("image read");
			return image;
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}*/		
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
		g.setColor(Color.black);
		g.fillRect(0, 0, 720, 600);
	}

	//will give user instructions on how to play 
	public static void renderHowToPlay(Graphics g)
	{		
		g.setColor(Color.black);
		g.fillRect(0, 0, 720, 600);
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
		
				
			/*Game Over
			g.setColor(Color.RED);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("Game Over!!, Score is " + Game.gameScore, 190, 300);
			
			//Restart
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("Press Enter to restart", 190, 300);
			*/
	
		g.dispose();		
		Game.setRunning(true);
	}
}
