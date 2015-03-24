//********************************************************************
//  DotsRebound.java       Author: Dr. Payne
//
//  Demonstrates mouse events.
//********************************************************************

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;

public class DotsRebound
{
	private static JTextField textField;
	private static DotsReboundPanel myDots;
   //-----------------------------------------------------------------
   //  Creates and displays the application frame.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      myDots = new DotsReboundPanel();
	  JFrame frame = new JFrame ("Dots");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      
      frame.getContentPane().add(myDots, BorderLayout.NORTH);
      
      JPanel panel = new JPanel();
      myDots.add(panel);
      
      JLabel lblNewLabel = new JLabel("Radius:");
      panel.add(lblNewLabel);
      
      textField = new JTextField();
      textField.setText("15");
      panel.add(textField);
      textField.setColumns(4);
      
      JButton btnNewButton = new JButton("Change");
      btnNewButton.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) 
      	{
      		int radius = Integer.parseInt(textField.getText());
      		myDots.setRadius(radius);
      	}
      });
      panel.add(btnNewButton);

      frame.pack();
      frame.setVisible(true);
   }
}