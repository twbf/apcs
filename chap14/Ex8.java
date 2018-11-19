import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class Ex8{

    JPanel panel;
    JLabel label;
    int x;
    int y;
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
            this.addMouseListener(new Mouse());
            this.addMouseMotionListener(new Ex8().new Mouse());
            System.out.println("e");
        }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString(Integer.toString(x), 200, 200);
            System.out.println("y");
        }
    }

    class Mouse extends MouseInputAdapter{
        public void mouseMoved(MouseEvent event) {
            x = event.getX();
            y = event.getY();
            System.out.println("hh");
            eyes.repaint();
        }
    }
}
