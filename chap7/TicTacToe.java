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


    public TicTacToe(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // so it closes nicely
        frame.setTitle("Tic-Tac-Toe");
        frame.setSize(1240,800);
        frame.setLayout(new GridLayout(3,3));

        JPanel[] panel = new JPanel[9];
        JButton[] buttons = new JButton[9];
        for(int i = 0; i<9; i++){
            panel[i] = new JPanel();
            buttons[i] = new JButton("Click");
            buttons[i].setPreferredSize(new Dimension(100, 100));
            panel[i].add(buttons[i]);
            frame.add(panel[i]);
        }

        frame.setVisible(true);
    }

    public void x(int x, int y){
        g.drawLine(x+10, y+10, x-10, y-10);
        g.drawLine(x-10, y+10, x-10, y+10);
    }

    public void o(int x, int y){
        g.drawOval(x, y, 40, 40);
    }

    public static void main(String args[]) throws FileNotFoundException{
        TicTacToe b = new TicTacToe();
    }

}
