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

        for(int i = 0; i<9; i++){
            buttons[i] = new JButton(i);
            buttons[i].setPreferredSize(new Dimension(40, 20));
            panel.add(buttons[i]);
        }

        

    }

    public static void x(int x, int y){
        g.drawLine(x+10, y+10, x-10, y-10);
        g.drawLine(x-10, y+10, x-10, y+10);
    }

    public static void o(int x, int y){
        g.drawOval(x, y, 40, 40);
    }
}
