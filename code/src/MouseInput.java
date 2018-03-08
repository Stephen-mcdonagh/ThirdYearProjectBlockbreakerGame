import java.awt.event.MouseEvent;

public class MouseInput 
{
	public static int difficultyChoice = 0 ;
	
	public static void mousePressedHome(MouseEvent e) 
	{
		int mouseX = e.getX(); //x value of mouse
		int mouseY = e.getY(); //y value of mouse
		
		//Play pressed
		if (Game.myState == Game.STATE.HOME)
		{
			if (mouseX >= 260 && mouseX <= 260 +220)
			{
				if(mouseY >= 150 && mouseY <= 200)
				{
					Game.myState = Game.STATE.DIFFICULTY;
					ConnectionManager.askUserForName();
				}
			}
		}
		//Highscores pressed
		if (Game.myState == Game.STATE.HOME)
		{
			if (mouseX >= 260 && mouseX <= 260 +220)
			{
				if(mouseY >= 250 && mouseY <= 300)
				{
					Game.myState = Game.STATE.HIGHSCORES;
				}
			}
		}
		
		//Help pressed
		if (Game.myState == Game.STATE.HOME)
		{
			if (mouseX >= 260 && mouseX <= 260 +220)
			{
				if(mouseY >= 350 && mouseY <= 400)
				{
					Game.myState = Game.STATE.HELP;
				}
			}
		}			
	}
	public static void mousePressedDifficulty(MouseEvent e) 
	{
		int mouseX = e.getX(); //x value of mouse
		int mouseY = e.getY(); //y value of mouse
		Config config = new Config();
		
		//Easy difficulty pressed 	
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
