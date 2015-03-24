package Dice;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
 
public class WheelE extends JPanel implements MouseWheelListener {
 
    JTextArea jTextArea;
    JScrollPane scPane;
    final static String nl = "n";
 
    public WheelE() {
 
  super(new BorderLayout());
 
  jTextArea = new JTextArea();
 
  jTextArea.setEditable(false);
 
  scPane = new JScrollPane(jTextArea);
 
  scPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
 
  scPane.setPreferredSize(new Dimension(420, 350));
 
  add(scPane, BorderLayout.CENTER);
 
  jTextArea.append("");
 
  jTextArea.addMouseWheelListener(this);
 
  setPreferredSize(new Dimension(500, 500));
 
  setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
    }
 
    public void mouseWheelMoved(MouseWheelEvent event) {
 
  String print;
 
  int steps = event.getWheelRotation();
 
  if (steps < 0) {
 
print = "Wheel moved UP " + -steps + " step(s)"
 
  + nl;
 
  } else {
 
print = "Wheel moved DOWN " + steps + " step(s)"
 
  + nl;
 
  }
 
  if (event.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) {
 
print += "Type: WHEEL_UNIT_SCROLL" + nl;
 
print += "Amount: " + event.getScrollAmount()
 
  + " unit increments per step" + nl;
 
print += "Units to scroll: " + event.getUnitsToScroll()
 
  + " unit increments" + nl;
 
print += "Vertical unit increment: "
 
  + scPane.getVerticalScrollBar().getUnitIncrement(1)
 
  + " pixels" + nl;
 
  } else { //scroll type == MouseWheelEvent.WHEEL_BLOCK_SCROLL
 
print += "Type: WHEEL_BLOCK_SCROLL" + nl;
 
print += "Vertical block increment: "
 
  + scPane.getVerticalScrollBar().getBlockIncrement(1)
 
  + " pixels" + nl;
 
  }
 
  saySomething(print, event);
    }
 
    void saySomething(String eventDescription, MouseWheelEvent e) {
 
  jTextArea.append(e.getComponent().getClass().getName() + ": "
 
    + eventDescription);
 
  jTextArea.setCaretPosition(jTextArea.getDocument().getLength());
    }
 
    private static void dispGUI() {
 
  JFrame.setDefaultLookAndFeelDecorated(true);
 
  JFrame frame = new JFrame("MouseWheelEventExample");
 
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
  JComponent newContentPane = new WheelE();
 
  newContentPane.setOpaque(true);
 
  frame.setContentPane(newContentPane);
 
  frame.pack();
 
  frame.setVisible(true);
    }
 
    public static void main(String[] args) {
 
  javax.swing.SwingUtilities.invokeLater(new Runnable() {
 
public void run() {
 
    dispGUI();
 
}
 
  });
    }
}
