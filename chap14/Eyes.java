import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Yyes extends JPanel{

    JPanel panel;
    JLabel label;
    int x;
    int y;

    public void Eyes(){
        panel = new JPanel();
        label = new JLabel();
        panel.addMouseListener(new Mouse());
        panel.addMouseMotionListener(new Mouse());
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
