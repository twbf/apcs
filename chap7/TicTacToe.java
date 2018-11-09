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
            buttons[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    for(int i = 0; i<9; i++){
                        if (e.getSource() == buttons[i]){ // checks if the button is the one clicked
                            draw(i, panel);
                        }
                    }
                }
            });
        }

        frame.setVisible(true);
    }

    public void draw(int i, JPanel[] panel){

        //users turn
        panel[i].removeAll();
        panel[i].updateUI();
        JLabel label = new JLabel("x");
        label.setFont(new Font("Sans-Serif", Font.PLAIN, 120));
        panel[i].add(label);

        //computers turn
        
    }

    public static void main(String args[]) throws FileNotFoundException{
        TicTacToe b = new TicTacToe();
    }

}
