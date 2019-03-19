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
        if (!tie){
            imageONE=image.getSubimage(x1,y1,width,height);
            imageTWO=image.getSubimage(x2,y2,width,height);
        } else {
            tie_imageONE=image.getSubimage(x1,y1,width,height);
            tie_imageTWO=image.getSubimage(x2,y2,width,height);
        }
        tie = isTie;
        repaint();
    }

    public void play(int sideThatWon){
        //side = sideThatWon;
        //play = 1;
        //repaint();
    }

    public void paintComponent(Graphics g) {
        if(!tie){
            g.drawImage(imageONE,100, 50, null);
            g.drawImage(imageTWO,500, 50, null);
        } else {
            g.drawImage(tie_imageONE,100, 150, null);
            g.drawImage(tie_imageTWO,500, 150, null);
        }
    }
}
