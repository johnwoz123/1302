package Dice;

//John Wozniak
//Project 2
//CS 1302
//July 22, 2014
//
import javax.swing.JFrame;

public class Dots
{
//-----------------------------------------------------------------
//  Creates and displays the application frame.
//-----------------------------------------------------------------
public static void main(String[] args)
{
   JFrame frame = new JFrame("John Wozniak's Dots!");
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   frame.getContentPane().add(new DotsPanel());

   frame.pack();
   frame.setVisible(true);
}

}

