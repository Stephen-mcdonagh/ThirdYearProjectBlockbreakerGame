import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Block 
{
	public static int blocks[][];
	public static int brickWidth;
	public static int brickHeight;
	
	public Block(int row, int col)
	{
		blocks = new int[row][col];
		for(int i = 0; i < blocks.length; i ++)
		{
			for(int j = 0; j < blocks[0].length; j++)
			{
				// the 1 is set to each block to see if ball had intersected or not			
				blocks[i][j] = 1;
			}
		}
		brickWidth = 540/col;
		brickHeight = 150/row;
	}
	
	public static void drawLevelOne(Graphics2D g)
	{
		for(int i = 0; i < blocks.length; i ++)
		{
			for(int j = 0; j < blocks[0].length; j++)
			{
				if(blocks[i][j] > 0)
				{
					g.setColor(Color.yellow);
					g.fillRect(j * brickWidth + 80,  i * brickHeight + 50, brickWidth, brickHeight);
					
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.black);
					g.drawRect(j * brickWidth + 80,  i * brickHeight + 50, brickWidth, brickHeight);
				}
			}
		}
	}
	
	public static void drawLevelTwo(Graphics2D g)
	{
		for(int i = 0; i < blocks.length; i ++)
		{
			for(int j = 0; j < blocks[0].length; j++)
			{
				if(i == 0)
				{
					if(blocks[i][j] > 0)
					{
						g.setColor(Color.yellow);
						g.fillRect(j * brickWidth + 80,  i * brickHeight + 50, brickWidth, brickHeight);
						
						g.setStroke(new BasicStroke(5));
						g.setColor(Color.black);
						g.drawRect(j * brickWidth + 80,  i * brickHeight + 50, brickWidth, brickHeight);
					}
				}
				if(i == 1 && (j == 1 || j == 2 || j == 3 || j == 4 || j == 5))
				{
					if(blocks[i][j] > 0)
					{
						g.setColor(Color.yellow);
						g.fillRect(j * brickWidth + 80,  i * brickHeight + 50, brickWidth, brickHeight);
						
						g.setStroke(new BasicStroke(5));
						g.setColor(Color.black);
						g.drawRect(j * brickWidth + 80,  i * brickHeight + 50, brickWidth, brickHeight);
					}
				}
				else if(i == 1)
					setBlockValue(0, 1, j);
				if(i == 2 && ( j == 2 || j == 3 || j == 4))
				{
					if(blocks[i][j] > 0)
					{
						g.setColor(Color.yellow);
						g.fillRect(j * brickWidth + 80,  i * brickHeight + 50, brickWidth, brickHeight);
						
						g.setStroke(new BasicStroke(5));
						g.setColor(Color.black);
						g.drawRect(j * brickWidth + 80,  i * brickHeight + 50, brickWidth, brickHeight);
					}
				}
				else if(i == 2)
					setBlockValue(0, 2, j);
				if(i == 3 && (j == 3))
				{
					if(blocks[i][j] > 0)
					{
						g.setColor(Color.yellow);
						g.fillRect(j * brickWidth + 80,  i * brickHeight + 50, brickWidth, brickHeight);
						
						g.setStroke(new BasicStroke(5));
						g.setColor(Color.black);
						g.drawRect(j * brickWidth + 80,  i * brickHeight + 50, brickWidth, brickHeight);
					}
				}
				else if(i == 3)
					setBlockValue(0, 3, j);				
			}
		}
	}
	
	public static void setBlockValue(int value, int row, int col)
	{
		blocks[row][col] = value;		
	}
}
