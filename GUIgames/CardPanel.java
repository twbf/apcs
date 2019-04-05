import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class CardPanel extends JPanel{

    BufferedImage image = null;
    BufferedImage imageONE = null;
    BufferedImage imageTWO = null;
    BufferedImage tie_imageONE = null;
    BufferedImage tie_imageTWO = null;
    BufferedImage back = null;
    boolean tie = false;
    int side = 0;

    public CardPanel(){
        JPanel panel = new JPanel();
        try {
            this.image = ImageIO.read(new File("Image.png"));
            this.imageONE = new BufferedImage(360,540,image.getType());
            this.imageTWO = new BufferedImage(360,540,image.getType());
            this.tie_imageONE = new BufferedImage(360,540,image.getType());
            this.tie_imageTWO = new BufferedImage(360,540,image.getType());

            this.back = ImageIO.read(new File("back.jpg"));
        } catch (IOException e) {
        }
    }

    public void display(Card one, Card two, boolean isTie){
        int x1=30+390*one.getVal();
        int y1=30+570*one.getSuit();
        int x2=30+390*two.getVal();
        int y2=30+570*two.getSuit();
        int width=360;
        int height=540;
        tie = isTie;
        if (tie){
            tie_imageONE=image.getSubimage(x1,y1,width,height);
            tie_imageTWO=image.getSubimage(x2,y2,width,height);
        } else {
            imageONE=image.getSubimage(x1,y1,width,height);
            imageTWO=image.getSubimage(x2,y2,width,height);
        }
        repaint();
    }

    public void play(int sideThatWon){
        //side = sideThatWon;
        //play = 1;
        //repaint();
    }

    public void paintComponent(Graphics g) {
        g.drawImage(imageONE,100, 50, null);
        g.drawImage(imageTWO,500, 50, null);
        if (tie){
            g.drawImage(back, 100,120,460,230,0,0,400,100, null);
            g.drawImage(back, 100,190,460,290,0,0,400,100, null);
            g.drawImage(back, 500,120,860,230,0,0,400,100, null);
            g.drawImage(back, 500,190,860,290,0,0,400,100, null);
            //g.drawImage(back, 500,130, null);
            //g.fillRect(100,130,360,500);
            //g.fillRect(500,130,360,500);
            g.drawImage(tie_imageONE,100, 250, null);
            g.drawImage(tie_imageTWO,500, 250, null);

        }
    }
}
