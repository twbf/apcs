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

    public int getErrors(){
        return errors;
    }

    public void paintComponent(Graphics g) {
        if (errors >= 0){
            g.setColor(Color.BLACK);
            g.fillRect(100, 100, 100, 100);
        }
        if (errors >= 1)  {
            //head
            g.setColor(Color.GREEN);
            g.fillRect(100, 100, 100, 100);
        }
        if (errors >= 2){
            //neck
        }
        if (errors >= 3){
            //arms
        }
        if (errors >= 4){
            //arm
        }
        if (errors >= 5){
            //body
        }
        if (errors >= 6){
            //leg
        }
        if (errors >= 7){
            //leg
        }
        if (errors >= 8){
            //loser
        }

    }
}
