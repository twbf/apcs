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

    public static void main(String args[]){
        JFrame frame = new JFrame();
        frame.setTitle("The eyes have it.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);

        Eyes eyes = new Eyes();

        frame.add(eyes);
        frame.setVisible(true);
    }
    class Eyes extends JPanel{
        public void paintComponent(Graphics g) {
            g.drawString(Integer.toString(x), 200, 200);
            System.out.println("y");
        }
    }

    class Mouse extends MouseInputAdapter{
        public void mouseMoved(MouseEvent event) {
            x = event.getX();
            y = event.getY();
            System.out.println("hh");
            repaint();
        }
    }
}
