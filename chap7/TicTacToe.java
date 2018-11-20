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
            if(checkWin(1)==1){
                JOptionPane.showMessageDialog(null, "You Won");
            }

            //computers turn
            int ci = -1;
            int cj = -1;

            //this sectiuon ios a sequance of proritized tasks that

            //checks if there is an open spot
            for(int k = 0; k<3; k++){
                for(int l = 0; l<3; l++){
                    if(board[k][l] == 0){
                        ci = k;
                        cj = l;
                    }
                }
            }

            //diagonals
            for(int k = 0; k<2; k+=2){
                for(int l = 0; l<2; k+=2){
                    if(board[k][l] == 0){
                        ci = k;
                        cj = l;
                    }
                }
            }

            if (board[0][0] == 1 && board[2][2] == 1 && board[0][1] == 0){
                ci = 0;
                cj = 1;
            }

            //center
            if(board[1][1] == 0){
                ci = 1;
                cj = 1;
            }


            //if the other player will win
            for(int k = 0; k<3; k++){
                for(int l = 0; l<3; l++){
                    if(board[k][l] == 0){
                        board[k][l] = 1; //asume they go there
                        if (checkWin(1) == 1){
                            ci = k;
                            cj = l;
                        }
                        board[k][l] = 0; // back
                    }
                }
            }

            //check if we will win
            for(int k = 0; k<3; k++){
                for(int l = 0; l<3; l++){
                    if(board[k][l] == 0){
                        board[k][l] = -1; //assume computer go there
                        if (checkWin(-1) == -1){
                            ci = k;
                            cj = l;
                        }
                        board[k][l] = 0; // back
                    }
                }
            }


            movePiece(ci,cj,false);
            if(checkWin(-1)==-1){
                JOptionPane.showMessageDialog(null, "Loser");
            }

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

        public int checkWin(int side){
            //rows
            for(int i = 0; i<3; i++){
                if(board[i][0] == side && board[i][1] == side && board[i][2] == side){
                    return side;
                }
            }

            //colloms
            for(int i = 0; i<3; i++){
                if(board[0][i] == side && board[1][i] == side && board[2][i] == side){
                    return side;
                }
            }

            //diagonals
            if(board[0][0] == side && board[1][1] == side && board[2][2] == side){
                return side;
            }
            if(board[0][2] == side && board[1][1] == side && board[2][0] == side){
                return side;
            }
            return 0;
        }
    }
}
