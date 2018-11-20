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
            int x1 = (x-150)/5 + 150;
            int y1 = (y-150)/5 + 150;

            //secound
            int x2 = (x-300)/5 + 300;
            int y2 = (y-150)/5 + 150;

            g.drawOval(100,100, 100, 100);
            g.drawOval(250,100, 100, 100);
            g.fillOval(x1,y1,20,20);
            g.fillOval(x2,y2,20,20);
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
