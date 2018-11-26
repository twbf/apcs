import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.event.*;


public class TicTacToe2{

    //notes
    //game play
    //make board cleaner

    private int[][] board;
    private JPanel[][] panel;
    private JButton[][] buttons;
    private JFrame frame;
    private JPanel gridPanel;
    private JLabel label;
    private int sideGoingFirst = 1;

    public static void main(String args[]) throws FileNotFoundException{
        TicTacToe2 b = new TicTacToe2();
    }

    public TicTacToe2(){
        this.frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // so it closes nicely
        frame.setTitle("Tic-Tac-Toe");
        frame.setSize(1240,800);
        frame.setLayout(new BorderLayout());

        this.panel = new JPanel[3][3];
        this.buttons = new JButton[3][3];
        this.board = new int[3][3];
        this.gridPanel = new JPanel();
        this.label = new JLabel();

        gridPanel.setLayout(new GridLayout(3,3));
        start();
    }

    public void start(){
        frame.getContentPane().removeAll();
        frame.getContentPane().repaint();
        gridPanel.removeAll();
        gridPanel.updateUI();
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                board[i][j] = 0;
                panel[i][j] = new JPanel();
                buttons[i][j] = new JButton("Click");
                buttons[i][j].setPreferredSize(new Dimension(100, 100));
                panel[i][j].add(buttons[i][j]);
                gridPanel.add(panel[i][j]);
                buttons[i][j].addActionListener(new Button());
            }
        }
        frame.add(gridPanel, BorderLayout.CENTER);

        JButton switchSides = new JButton("Computer Go First");
        switchSides.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                sideGoingFirst = 1;
                movePiece(1,1,false); //moves to center
            }
        });
        frame.add(switchSides, BorderLayout.NORTH);

        frame.setVisible(true);
    }

    public class Button implements ActionListener{
        public void actionPerformed(ActionEvent e){
            for(int i = 0; i<3; i++){
                for(int j = 0; j<3; j++){
                    if (e.getSource() == TicTacToe2.this.buttons[i][j]){ // checks if the button is the one clicked
                        TicTacToe2.this.draw(i,j);
                    }
                }
            }
        }
    }

    public void draw(int i, int j){ //i,j are users cordinaties wheras ci,cj are computer coudinates
        //users turn
        movePiece(i,j,true);
        if(checkWin(1)==1){
            end(1);
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
            for(int l = 0; l<2; l+=2){
                if(board[k][l] == 0){
                    ci = k;
                    cj = l;
                }
            }
        }

        // to fix weird loophole
        if (board[0][0] == 1 && board[2][2] == 1 && board[0][1] == 0){
            ci = 0;
            cj = 1;
        }
        if (board[0][2] == 1 && board[2][0] == 1 && board[0][1] == 0){
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
            end(-1);
        }
    }

    public void end(int side){ // 0 if stalemate
        frame.getContentPane().removeAll();
        frame.getContentPane().repaint();

        String message = "Stalemate";
        if (side == -1){
            message = "Loser";
        } else if (side == 1){
            message = "You achived the impossible";
        }
        frame.add(new JLabel(message + " Want to try again?"), BorderLayout.NORTH);
        JButton start = new JButton("START");
        start.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                start();
            }
        });
        frame.add(start, BorderLayout.CENTER);
    }

    public void movePiece(int i, int j, boolean user){
        try{
            if(user){
                board[i][j] = 1;
                label = new JLabel("x");
            } else {
                board[i][j] = -1;
                label = new JLabel("o");
            }
        } catch (Exception e){ // no spots avalible
            end(0);
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
