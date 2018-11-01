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
            g.fillRect(700, 500, 200, 20);
            g.fillRect(800, 100, 20, 400);
            g.fillRect(600, 100, 200, 20);
            g.fillRect(600, 100, 20, 50);
        }
        if (errors >= 1)  {
            //head
            g.drawOval(550, 150, 100, 100);
        }
        if (errors >= 2){
            //neck
            g.drawLine(600, 250, 600, 270);
        }
        if (errors >= 3){
            //arm
            g.drawLine(600, 270, 640, 340);
        }
        if (errors >= 4){
            //arm
            g.drawLine(600, 270, 560, 340);

        }
        if (errors >= 5){
            //body
            g.drawLine(600, 270, 600, 370);
        }
        if (errors >= 6){
            //leg
            g.drawLine(600, 370, 620, 470);
        }
        if (errors >= 7){
            //leg
            g.drawLine(600, 370, 580, 470);
        }
        if (errors >= 8){
            //loser
            g.drawString("LOSER", 580, 470);
        }

    }
}
