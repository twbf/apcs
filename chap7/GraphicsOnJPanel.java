import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;

public class GraphicsOnJPanel extends JFrame{

    public int errors;

    public GraphicsOnJPanel(){
        setSize (500,500);
        setResizable (false);
        setContentPane (new JPanel (){
            public void paint (Graphics g){

                // initial
                g.setColor(Color.BLACK);
                g.fillRect(200, 200, 100, 100);
             }
         });
         setVisible(true);
    }

    public void paint(Graphics g, int e){
        errors = e;
        g.setColor(Color.RED);
        g.fillRect(100, 100, 100, 100);
    }



}
