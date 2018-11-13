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
    private static int[] board;

    public TicTacToe(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // so it closes nicely
        frame.setTitle("Tic-Tac-Toe");
        frame.setSize(1240,800);
        frame.setLayout(new GridLayout(3,3));
        JPanel[] panel = new JPanel[9];
        JButton[] buttons = new JButton[9];
        int[] board = new int[9];

        for(int i = 0; i<9; i++){
            board[i] = 0;
            panel[i] = new JPanel();
            buttons[i] = new JButton("Click");
            buttons[i].setPreferredSize(new Dimension(100, 100));
            panel[i].add(buttons[i]);
            frame.add(panel[i]);
            buttons[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    for(int i = 0; i<9; i++){
                        if (e.getSource() == buttons[i]){ // checks if the button is the one clicked
                            draw(i, panel, board);
                        }
                    }
                }
            });
        }

        frame.setVisible(true);
    }

    public void draw(int user, JPanel[] panel, int[] board){

        //users turn
        board[user] = 1;
        panel[user].removeAll();
        panel[user].updateUI();
        JLabel label1 = new JLabel("x");
        label1.setFont(new Font("Sans-Serif", Font.PLAIN, 120));
        panel[user].add(label1);

        //computers turn
        int computer = -1;
        for(int j = 0; j<9; j++){
            if(board[j] == 0){
                computer = j;
            }
        }

        board[computer] = -1;
        panel[computer].removeAll();
        panel[computer].updateUI();
        JLabel label2 = new JLabel("o");
        label2.setFont(new Font("Sans-Serif", Font.PLAIN, 120));
        panel[computer].add(label2);

    }

    public static int checkWin(int[] board){

    }

    public static void main(String args[]) throws FileNotFoundException{
        TicTacToe b = new TicTacToe();
    }

}
