import java.awt.event.MouseEvent;

public class MouseInput 
{
	public static int difficultyChoice = 0 ;
	
	public static void mousePressedHome(MouseEvent e) 
	{
		int mouseX = e.getX(); //x value of mouse
		int mouseY = e.getY(); //y value of mouse
		
		/*public static Rectangle PlayButton = new Rectangle(280,150,220,50);
		public static Rectangle HighScoresButton = new Rectangle(280,250,220,50);
		public static Rectangle HelpButton = new Rectangle(280,350,220,50);
		*/
		if (Game.myState == Game.STATE.HOME)
		{
			if (mouseX >= 260 && mouseX <= 260 +220)
			{
				if(mouseY >= 150 && mouseY <= 200)
				{
					Game.myState = Game.STATE.DIFFICULTY;
				}
			}
		}
		
		//TODO: need to continue this for high score and help sections
	
	}
	public static void mousePressedDifficulty(MouseEvent e) 
	{
		int mouseX = e.getX(); //x value of mouse
		int mouseY = e.getY(); //y value of mouse
		Config config = new Config();
		
		//Easy difficulty pressed TODO: FIX BUG 	
		if (Game.myState == Game.STATE.DIFFICULTY)
		{
			if (mouseX >= 260 && mouseX <= 260 +220)
			{
				if(mouseY >= 150 && mouseY <= 200)
				{
					difficultyChoice = 1;
					Game.myState = Game.STATE.LEVEL1;
					Game.gameDifficulty = Integer.parseInt(config.getProperty("easySpeed"));		
					Game.setRunning(true);
				}
			}
		}		
		
		//Intermediate difficulty pressed
		if (Game.myState == Game.STATE.DIFFICULTY)
		{
			if (mouseX >= 260 && mouseX <= 260 +220)
			{
				if(mouseY >= 250 && mouseY <= 300)
				{
					difficultyChoice = 2;
					Game.myState = Game.STATE.LEVEL1;
					Game.gameDifficulty = Integer.parseInt(config.getProperty("mediumSpeed"));
					Game.setRunning(true);
				}
			}
		}
		
		//hard difficulty pressed
		if (Game.myState == Game.STATE.DIFFICULTY)
		{
			if (mouseX >= 260 && mouseX <= 260 +220)
			{
				if(mouseY >= 350 && mouseY <= 400)
				{
					difficultyChoice = 3;
					Game.myState = Game.STATE.LEVEL1;
					Game.gameDifficulty = Integer.parseInt(config.getProperty("hardSpeed"));
					Game.setRunning(true);
				}
			}
		}
	}
}
