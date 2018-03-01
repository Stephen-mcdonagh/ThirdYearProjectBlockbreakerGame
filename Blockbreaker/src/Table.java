import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Table extends JFrame
{
	JTable table; 
	
	public Table()
	{
		setLayout(new FlowLayout());
		
		String[] columnNames = {"username","score"};
		
		Object [][] data =
			{
					{"stephen","440"},
					{"peter","380"},
					{"andrew","240"},
					{"David","240"},
					{"stephen","220"},
			}; 	
		
		table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500,80));
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
	}
	
	public static void showTable()
	{	
		Table highscoresTable = new Table();
		highscoresTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		highscoresTable.setSize(600,200);
		highscoresTable.setLocationRelativeTo(null);
		highscoresTable.setVisible(true);
		highscoresTable.setTitle("My highscores table");
		}


}
