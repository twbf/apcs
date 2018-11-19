import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class Ex8{

    private JPanel panel;
    private JLabel label;
    private int x;
    private int y;
    private Ex8.Eyes eyes;

    public static void main(String args[]) throws FileNotFoundException{
        JFrame frame = new JFrame();
        frame.setTitle("The eyes have it.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        Ex8.Eyes eyes = new Ex8().new Eyes();
        frame.add(eyes);
        frame.setVisible(true);
    }

    public class Eyes extends JPanel{
        public Eyes(){
            JPanel pane = new JPanel();
            this.addMouseMotionListener(new Mouse());
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            //First Eye
            int x1 = (x-150)/5;
            int y1= (y-150)/5;

            g.drawOval(100,100, 100, 100);
            g.drawOval(250,100, 100, 100);
            g.fillOval(x1+150,y1+150,10,10);
            g.fillOval(x-50,y/2,10,10);
        }

        class Mouse extends MouseInputAdapter{
            public void mouseMoved(MouseEvent event) {
                x = event.getX();
                y = event.getY();
                repaint();
            }
        }

    }
}
