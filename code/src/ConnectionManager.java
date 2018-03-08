import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;


import javax.swing.JOptionPane;

public class ConnectionManager 
{
	private static String url = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=blockbreaker;integratedSecurity=true";
	private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";   
    public static Connection con = null;
    
	public static Statement stmt = null;
	public static ResultSet rs = null;

    public static Connection getConnection()
    {
        try 
        {
            Class.forName(driverName);
            try 
            {            	
                con = DriverManager.getConnection(url);
            } 
            catch (SQLException ex) 
            {
                // log an exception. for example:
                System.out.println("Failed to create the database connection."); 
            }
        } 
        catch (ClassNotFoundException ex) 
        {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        return con;
    }
    
    //adds a new score to the database
    public static void addNewEntryToDatabase(int highscore,String username)
    {
    	Config config = new Config();
    	try 
		{
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			
		    String queryString = config.getProperty("insertQuery");

		    PreparedStatement preparedStatement = con.prepareStatement(queryString);
		    preparedStatement.setString(1,username);
		    preparedStatement.setInt(2,highscore);
		    // execute insert SQL stetement
		    preparedStatement .executeUpdate();
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		} 
		finally 
		{
			if (rs != null) try { rs.close(); } catch(Exception e) {}  
	        if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
	        if (con != null) try { con.close(); } catch(Exception e) {} 
		}         
    
    }
   //get top 5 highscores within database
    public static LinkedList<String> readHighScore()
    {
    	Config config = new Config();
    	LinkedList<String> mylist = new LinkedList<String>();
    	try 
    	{
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			
		    String queryString = config.getProperty("highScoreQuery");
		    rs = stmt.executeQuery(queryString);
		    while (rs.next() ) 
			{
		    	mylist.add(rs.getString(1));
		    	mylist.add(rs.getString(2));
		    	//System.out.println(rs.getString(1)+ " " + rs.getString(2));
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		} 
		finally 
		{
			if (rs != null) try { rs.close(); } catch(Exception e) {}  
	        if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
	        if (con != null) try { con.close(); } catch(Exception e) {} 
		}
	    return mylist;

    }
    
    //Asks user to input name, so appropriate name can be added to database
    public static void askUserForName()
    {
    	String input = JOptionPane.showInputDialog(null,"Please Enter your name");
    	Game.username = input;
    }   
}
