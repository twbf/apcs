import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.event.*;

// Make sure that all of the objects are global

public class TicTacToe{

    private JFrame frame;
    private JPanel big;
    private TicTacToe.BoardPanel b;
    private int[][] board;
    private JPanel[][] panel;
    private JButton[][] buttons;

    public static void main(String args[]) throws FileNotFoundException{
        TicTacToe.BoardPanel b = new TicTacToe().new BoardPanel();
    }

    public class BoardPanel extends JFrame{
        public BoardPanel(){
            //TicTacToe b = new TicTacToe();
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // so it closes nicely
            frame.setTitle("Tic-Tac-Toe");
            frame.setSize(1240,800);
            frame.setLayout(new GridLayout(3,3));
            JPanel[][] panel = new JPanel[3][3];
            JButton[][] buttons = new JButton[3][3];
            int[][] board = new int[3][3];
            for(int i = 0; i<3; i++){
                for(int j = 0; j<3; j++){
                    board[i][j] = 0;
                    panel[i][j] = new JPanel();
                    buttons[i][j] = new JButton("Click");
                    buttons[i][j].setPreferredSize(new Dimension(100, 100));
                    panel[i][j].add(buttons[i][j]);
                    frame.add(panel[i][j]);
                    buttons[i][j].addActionListener(new Button());
                    System.out.println("h");
                }
            }
            frame.setVisible(true);
        }
        public class Button implements ActionListener{
            public void actionPerformed(ActionEvent e){
                for(int i = 0; i<3; i++){
                    for(int j = 0; j<3; j++){
                        if (e.getSource() == buttons[i][j]){ // checks if the button is the one clicked
                            draw(i,j);
                        }
                    }
                }
            }
        }

        public void draw(int i, int j){
            //i,j are users cordinaties wheras ci,cj are computer coudinates


            //users turn
            board[i][j] = 1;
            panel[i][j].removeAll();
            panel[i][j].updateUI();
            JLabel label1 = new JLabel("x");
            label1.setFont(new Font("Sans-Serif", Font.PLAIN, 120));
            panel[i][j].add(label1);

            //computers turn
            int ci = -1;
            int cj = -1;
            for(int k = 0; k<3; k++){
                for(int l = 0; l<3; l++){
                    if(board[k][l] == 0){
                        ci = k;
                        cj = l;
                    }
                }
            }

            board[ci][cj] = -1;
            panel[ci][cj].removeAll();
            panel[ci][cj].updateUI();
            JLabel label2 = new JLabel("o");
            label2.setFont(new Font("Sans-Serif", Font.PLAIN, 120));
            panel[ci][cj].add(label2);
        }

        //public static int checkWin(int[] board){

        //}
    }
}
