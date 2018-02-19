import java.awt.Canvas;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Main extends Canvas 
{
		
	public static final String TITLE = "BlockBreaker";
	public static int Width = 735;
	public static int Height = 600;
	
	public static void main(String [] args)
	{ 
		onInit();
	}

	private static void onInit() 
	{
		Game game = new Game();
		JFrame frame = new JFrame(TITLE);
		frame.add(game);
		frame.setBounds(11,11,Width,Height);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null); //middle of screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}	
}