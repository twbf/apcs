import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;

public class GraphicsOnJPanel extends JPanel{

    public int errors;

    public GraphicsOnJPanel(){
        //setSize (500,500);
        //setResizable (false);
        JPanel panel = new JPanel (){
            public void paint (Graphics g){

                // initial
                g.setColor(Color.BLACK);
                g.fillRect(200, 200, 100, 100);
             }
         };
         setVisible(true);
    }

    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(100, 100, 100, 100);
    }
}
