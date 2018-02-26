import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class ConnectionManager 
{
	private static String url = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=blockbreaker;integratedSecurity=true";
	private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";   
    private static Connection con = null;
    
	private static Statement stmt = null;
	private static ResultSet rs = null;

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
                // log an exception. fro example:
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
    	try 
		{
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			
		    String queryString = "insert into dbo.highscores (username, score) values (?,?)";

		    PreparedStatement preparedStatement = con.prepareStatement(queryString);
		    preparedStatement.setString(1,username);
		    preparedStatement.setInt(2,highscore);
		 //preparedStatement.setTimestamp(3, getCurrentTimeStamp());
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
    public static void readHighScore()
    {
    	try 
		{
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			
		    String queryString = "SELECT TOP (5) [username] , [score] FROM [blockbreaker].[dbo].[highscores] ORDER BY score DESC";
		    rs = stmt.executeQuery(queryString);
		    while (rs.next()) 
			{
		    	System.out.println(rs.getString(1)+ " " + rs.getString(2));
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
    }
    
   /* private static java.sql.Timestamp getCurrentTimeStamp() 
    {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}*/
    
    //Asks user to input name, so appropriate name can be added to database
    public static void askUserForName()
    {
    	String input = JOptionPane.showInputDialog(null,"Please Enter your name");
    	Game.username = input;
    	System.out.println(input);
    }   
}
