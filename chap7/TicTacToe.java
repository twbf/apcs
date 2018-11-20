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

    public static void main(String args[]) throws FileNotFoundException{
        TicTacToe.BoardPanel b = new TicTacToe().new BoardPanel();
    }

    public class BoardPanel extends JFrame{

        private JLabel label;
        private TicTacToe.BoardPanel b;
        private int[][] board;
        private JPanel[][] panel;
        private JButton[][] buttons;

        public BoardPanel(){
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // so it closes nicely
            frame.setTitle("Tic-Tac-Toe");
            frame.setSize(1240,800);
            frame.setLayout(new GridLayout(3,3));

            this.panel = new JPanel[3][3];
            this.buttons = new JButton[3][3];
            this.board = new int[3][3];
            this.label = new JLabel();

            for(int i = 0; i<3; i++){
                for(int j = 0; j<3; j++){
                    board[i][j] = 0;
                    panel[i][j] = new JPanel();
                    buttons[i][j] = new JButton("Click");
                    buttons[i][j].setPreferredSize(new Dimension(100, 100));
                    panel[i][j].add(buttons[i][j]);
                    frame.add(panel[i][j]);
                    buttons[i][j].addActionListener(new Button());
                }
            }
            frame.setVisible(true);
        }

        public class Button implements ActionListener{
            public void actionPerformed(ActionEvent e){
                for(int i = 0; i<3; i++){
                    for(int j = 0; j<3; j++){
                        if (e.getSource() == BoardPanel.this.buttons[i][j]){ // checks if the button is the one clicked
                            BoardPanel.this.draw(i,j);
                        }
                    }
                }
            }
        }

        public void draw(int i, int j){ //i,j are users cordinaties wheras ci,cj are computer coudinates
            //users turn
            movePiece(i,j,true);

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
            movePiece(ci,cj,false);
        }

        public void movePiece(int i, int j, boolean user){
            if(user){
                board[i][j] = 1;
                label = new JLabel("x");
            } else {
                board[i][j] = -1;
                label = new JLabel("o");
            }
            label.setFont(new Font("Sans-Serif", Font.PLAIN, 120));
            panel[i][j].removeAll();
            panel[i][j].updateUI();
            panel[i][j].add(label);
        }
        
        //public static int checkWin(int[] board){

        //}
    }
}
