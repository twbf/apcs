import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

// Make sure that all of the objects are global

public class TicTacToe{

    public JFrame frame;
    public JPanel panel;
    private Graphics g;


    public static void main(String args[]) throws FileNotFoundException{
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // so it closes nicely
        frame.setTitle("Tic-Tac-Toe");
        frame.setSize(1240,800);

        for(int i = 0; i<26; i++){
            buttons[i] = new JButton(i);
            buttons[i].setPreferredSize(new Dimension(40, 20));
        }
    }

    public static void x(int x, int y){
        g.drawLine(600, 250, 600, 270);
        g.drawLine(600, 250, 600, 270);
    }

    public static void o(int x, int y){
        g.drawOval(x, y, 40, 40);
    }
}
