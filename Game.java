import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;
//HELLO
@SuppressWarnings("serial")
public class Game extends JPanel implements KeyListener,ActionListener
{
	public static int score = 0;
	//private int numOfBricks = 21;
	public static boolean running = false;  //play
	public static Player player = new Player();  //To be removed
	
	private Timer timer;
	private int delay = 20;
	
	public Game()
	{
		addKeyListener(this);
		setFocusable(true);
		timer = new Timer(delay,this);
		timer.start();
	}
	
	//Put objects onto screen
	public void paint(Graphics g)
	{
		//background
		g.setColor(Color.black);
		g.fillRect(0, 0, 792, 592);
		
		//ball
		g.setColor(Color.green);
		g.fillOval(Ball.getBallXPos(),Ball.getBallYPos(),20,20);
		
		//paddle
		g.setColor(Color.red);
		g.fillRect(Player.getPlayerXPos(), 550, 120, 10);
		
		g.dispose();
		
		setRunning(true);
	}
	
	public boolean isRunning()
	{
		return running;
	}
	
	public static void setRunning(boolean isRunning)
	{
		running = isRunning;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		timer.start();
		KeyInput.actionPerformed();
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		KeyInput.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e)
	{                       
		//KeyInput.keyReleased(e);
	}
	
	@Override
	public void keyTyped(KeyEvent e)
	{
		// Auto-generated method stub
	}
}
