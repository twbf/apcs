import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class War{
    private Hand h1;
    private Hand h2;
    private JLabel l1;
    private JLabel l2;
    private CardPanel panel;

    public static void main(String[] args) {
        War a = new War();
    }

    public War(){
        JFrame frame = new JFrame("Game of War");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,650);

        //card display
        this.panel = new CardPanel();
        this.l1 = new JLabel("You Should Play");
        this.l2 = new JLabel("This is computer");
        panel.add(l1);
        panel.add(l2);

        JButton button = new JButton("NEXT");
        button.addActionListener(new WarListener()); // adds the listener
        JPanel buttonPanel=new JPanel();
        buttonPanel.add(button);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);

        Deck d = new Deck();
        d.shuffle();
        this.h1 = new Hand(d,0);
        this.h2 = new Hand(d,1);
    }

    public class WarListener implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            start();
        }
    }

    public void start(){
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(h1.flip());
        cards.add(h2.flip());
        Card one = cards.get(0);
        Card two = cards.get(1);
        int num1 = one.getVal();
        int num2 = two.getVal();

        //display cards

        l1.setText("" + h1.getScore());
        l2.setText("" + h2.getScore());

        panel.display(one, two);

        //compare
        if(num1>num2){
            h1.won(cards);
            panel.play(true);
        } else if(num2>num1){
            h2.won(cards);
            panel.play(false);
        } else { // tie
            //cards
            cards.add(h1.flip());
            cards.add(h2.flip());
            cards.add(h1.flip());
            cards.add(h2.flip());

            cards.add(h1.flip());
            cards.add(h2.flip());

            if(cards.get(6).getVal()<cards.get(7).getVal()){
                h2.won(cards);
            } else {
                h1.won(cards);  //wrong
            }
        }


    }
}
