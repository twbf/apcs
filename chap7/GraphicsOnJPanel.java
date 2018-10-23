import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;

public class GraphicsOnJPanel extends JFrame{

    public int errors;

    public GraphicsOnJPanel(int e){
        errors = e;
        setSize (Toolkit.getDefaultToolkit ().getScreenSize ());
        setResizable (false);
        setContentPane (new JPanel (){

            public void paint (Graphics g){
                g.setColor (Color.RED);
                g.fillRect (100, 100, 100, 100);
                if (errors == 0){
                    g.setColor (Color.BLACK);
                    g.fillRect (200, 200, 100, 100);
                }
             }

         });
    setVisible (true);
}
}
