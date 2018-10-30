import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;

public class GraphicsOnJPanel extends JPanel{

    public int errors = 0;

    public GraphicsOnJPanel(){
        JPanel panel = new JPanel ();
    }

    public void setErrors(int e){
        errors = e;
    }

    public void paintComponent(Graphics g) {
        if (errors >= 0){
            g.setColor(Color.RED);
            g.fillRect(100, 100, 100, 100);
        }
        if (errors >=1)  {
            //head
            g.setColor(Color.GREEN);
            g.fillRect(100, 100, 100, 100);
        }
        if (errors >=2)  {
            //head
        }

    }
}
