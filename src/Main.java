import java.awt.Canvas;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Main extends Canvas 
{
		
	public static final String TITLE = "BlockBreaker";
	public static int HEIGHT = 720;
	public static int WIDTH = 600;
	
	public static void main(String [] args)
	{ 
		onInit();
	}

	private static void onInit() 
	{
		Game game = new Game();
		JFrame frame = new JFrame(TITLE);
		frame.add(game);
		frame.setVisible(true);
		frame.setBounds(11,11,HEIGHT,WIDTH);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); //middle of screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
}


/* try {        
 private Connection con = null   
private Statement stmt = null;
private ResultSet rs = null;

con = ConnectionManager.getConnection();
stmt = con.createStatement();
rs = stmt.executeQuery(sql);
} catch (Exception e) {
System.out.println(e.getMessage());
} finally {
try {
    if (conn != null) { conn.close(); }
} catch (SQLException sqlExc) {
    System.out.println(sqlExc.getMessage());
} // try-catch
} // try-catch-finally */


/*private Connection con = null;
private Statement stmt = null;
private ResultSet rs = null;

con = ConnectionManager.getConnection();
stmt = con.createStatement();
rs = stmt.executeQuery(sql); */