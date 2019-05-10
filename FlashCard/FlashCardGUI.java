import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class FlashCardGUI {

    private JPanel panel;
    private JFrame frame;
    private JLabel text;
    private JButton flip;
    private Card current_card;
    private Stack current_stack;

    private Stack random;
    private Stack string;


    private int state;

    public FlashCardGUI(){

        panel = new JPanel();
        frame = new JFrame();
        text = new JLabel(" ");
        flip = new JButton("Flip");
        state = 1;

        flip.addActionListener(new Listener());
        panel.add(text);
        panel.add(flip);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,800);

        random = new Stack("FCrandom.txt");
        string = new Stack("FCstring.txt");

        current_stack = string;

        

        newCard();

        frame.setVisible(true);
    }

    public class Listener implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            if(state == 1){
                newCard();
            } else{
                back();
            }
        }
    }

    private void newCard(){
        current_card = current_stack.nextCard();
        text.setText(current_card.getQuestion());
        state = 0;
    }

    private void back(){
        text.setText(current_card.getAwnswer());
        state = 1;
    }

    public static void main(String args[]){
        FlashCardGUI g = new FlashCardGUI();
    }
}
