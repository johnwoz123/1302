package Project1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class DrawPanel  extends JFrame
{
	/**
	 * initiate a DrowObjectPanel, 
	 * A variable that holds the spot of another JPanel; I shall name you APanel = new JPanel!!
	 * Initiate variable JFrame = newJFrame()
	 */
	
	//Constructor 
	
	private DrawObjects panel = new DrawObjects();
	private JPanel APanel = new JPanel();
	private JFrame window = new JFrame();
	
	DrawPanel()
	{
		buildGUI();
	}
		 public void buildGUI()
		// Method that add
		{
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setLayout(new GridLayout(2,2));
			window.add(panel);
			window.add(APanel);
			APanel.setBackground(Color.GRAY);
			
			
			// Define the buttons and add the panel
			
			JButton rect = new JButton("rect");
			JButton oval = new JButton("oval");
			APanel.add(rect);
			APanel.add (oval);
			
			rect.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					panel.setType(1);
					
				}
				
			});
			
			oval.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					panel.setType(2);
				}
			});
			
			window.setVisible(true);
			window.setSize(1000, 850);
		}
		
		public static void main(String[]args)
		{
			//creates the new Object that draws 
			new DrawPanel();
		}

		
		
}
