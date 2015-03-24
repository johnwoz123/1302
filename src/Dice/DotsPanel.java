package Dice;

//********************************************************************
//DotsPanel.java       Author: Lewis/Loftus
//
//Represents the primary panel for the Dots program.
//********************************************************************

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.*;

/*
* Paint with continuous dots by adding a MouseMotionListener that adds points to the pointsList when the mouseDragged event is triggered.
* Add some color to the dots by changing the page.setColor(...).
*/
public class DotsPanel extends JPanel 
{
 int SIZE = 20;
 
 Timer timer;
 
 Color[] colors = new Color[10000]; 
 
private ArrayList<Point> pointList;
Random r;

int [] yvel = new int[10000];

int [] xvel = new int[10000];
//-----------------------------------------------------------------
//  Constructor: Sets up this panel to listen for mouse events.
//-----------------------------------------------------------------
public DotsPanel()
{
	r = new Random();
	
  pointList = new ArrayList<Point>();
  
  DotsListener myListener = new DotsListener();
  
  addMouseListener (myListener);
  
  addMouseMotionListener (myListener);
  
  timer = new Timer (33, myListener);
  
  addMouseWheelListener(new DotsListener());      
  

  setBackground(Color.BLACK);
  setPreferredSize(new Dimension(600, 400));
  timer.start();
}


//-----------------------------------------------------------------
//  Draws all of the dots stored in the list.
//-----------------------------------------------------------------
public void paintComponent(Graphics page)
{
  super.paintComponent(page);
  
  //Random r = new Random();
  
  int i = 0;
  for (Point spot : pointList)
  	{
	  	page.setColor( colors[i]);
  	
	  

	  	//page.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));

  
  
	  //page.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
    
     page.fillOval(spot.x-SIZE, spot.y-SIZE, SIZE*2, SIZE*2);
     i++;
  	}
     page.drawString("Count: " + pointList.size(), 5, 15);


}


//*****************************************************************
//  Represents the listener for mouse events.
//*****************************************************************
private class DotsListener implements MouseListener, MouseMotionListener,MouseWheelListener, ActionListener
{
  //--------------------------------------------------------------
  //  Adds the current point to the list of points and redraws
  //  the panel whenever the mouse button is pressed.
  //--------------------------------------------------------------
  public void mousePressed(MouseEvent event)
  {
	 colors[ pointList.size() ] = new Color(r.nextInt(256),r.nextInt(256), r.nextInt(256), r.nextInt(256));
	 
	 yvel[ pointList.size() ] = r.nextInt(10) + 2;
	 if(r.nextInt(2)==1) yvel[pointList.size() ] *= -1;
	 
	// xvel[pointList.size() ] = r.nextInt(10) + 2;
	// if(r.nextInt(2)==1) xvel[pointList.size() ] *= -1;
	 
	 pointList.add(event.getPoint());
	 repaint();
  }

  
  public void mouseClicked(MouseEvent event) 
  {
	  int X = event.getX();
	  int Y = event.getY();
  }
  public void mouseReleased(MouseEvent event) {}
  public void mouseEntered(MouseEvent event) {}
  public void mouseExited(MouseEvent event) {}

  public void mouseDragged(MouseEvent event) 
  {
	  colors[ pointList.size() ] = new Color(r.nextInt(256),r.nextInt(256), r.nextInt(256), r.nextInt(256));
	  
	  yvel[ pointList.size() ] = (r.nextInt(10) + 2);
	  if(r.nextInt(2)==1) yvel[pointList.size() ] *= -1;
	  
	  xvel[pointList.size() ] = r.nextInt(10) + 2;
		 if(r.nextInt(2)==1) xvel[pointList.size() ] *= -1;
	  
	  pointList.add(event.getPoint());
	  repaint();
  }

  public void mouseMoved(MouseEvent e) {}

  public void mouseWheelMoved(MouseWheelEvent event) 
  {
	 SIZE = (event.getWheelRotation());
  }

public void actionPerformed(ActionEvent event)
	{
		int i = 0;
		for(Point spot : pointList)
		{
			spot.y += yvel[i];
			spot.x += xvel[i];
			
			if(spot.y > getHeight())
				yvel[i] *= -1;
			if(spot.y < 0)
				yvel[i] *= -1;
			if(spot.x > getWidth())
				xvel[i] *= -1;
			if(spot.x < 0)
				xvel[i] *= -1;
			
			i++;
		}	
		repaint();
		
	}

/*private int processMouseWheelEvent(int scrollAmount) 
	{
		SIZE += scrollAmount;
		SIZE -= scrollAmount;
		return SIZE;
	}
*/
}
}
