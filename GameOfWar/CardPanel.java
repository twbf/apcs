import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;

public class CardPanel extends JPanel{
    BufferedImage image=new BufferedImage("Image.png");
    BufferedImage ONE=new BufferedImage();
    int i=0;
    public CardPanel(){
        JPanel panel = new JPanel();

    }

    public void display(Card one, Card two){
        int x1=30+390*one.getVal();
        int y1=30+570*one.getSuit();
        int x2=30+390*two.getVal();
        int y2=30+570*two.getSuit();
        int width=360;
        int height=540;
        BufferedImage ONE=new BufferedImage(width,height,image.getType());
        ONE=image.getSubimage(x1,y1,width,height);
        repaint();
        ONE=image.getSubimage(x2,y2,width,height);
        repaint();
    }

    public void play(boolean one){

    }

    public void paintComponent(Graphics g) {
        g.fillRect(0, 0, 200, 200);
        if(i%2==0){
        g.drawImage(500,100,ONE);
        }
        g.drawImage(0,0,ONE);
    }
}
