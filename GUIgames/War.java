import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.event.*;


// next class
// add won
// add tied
// add delay

public class War {
    private Hand h1;
    private Hand h2;
    private JLabel l1;
    private JLabel l2;
    private CardPanel panel;
    private ArrayList<Card> cards;
    private JButton button;
    private Timer time;

    public static void main(String[] args) {
        War a = new War();
    }

    public War(){
        JFrame frame = new JFrame("Game of War");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,800);

        //card display
        this.panel = new CardPanel();

        JPanel northPanel = new JPanel(new BorderLayout());
        this.l1 = new JLabel("You Should Play");
        l1.setFont(new Font("Sans-Serif", Font.PLAIN, 40));
        this.l2 = new JLabel("This is computer");
        l2.setFont(new Font("Sans-Serif", Font.PLAIN, 40));
        northPanel.add(l1, BorderLayout.WEST);
        northPanel.add(l2, BorderLayout.EAST);

        this.button = new JButton("NEXT");
        button.addActionListener(new WarListener()); // adds the listener
        button.setPreferredSize(new Dimension(60, 60));
        JPanel buttonPanel=new JPanel(new GridLayout(1,1));
        buttonPanel.add(button);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(northPanel, BorderLayout.NORTH);
        frame.setVisible(true);

        Deck d = new Deck();
        d.shuffle();
        this.h1 = new Hand(d,0);
        this.h2 = new Hand(d,1);
        this.cards = new ArrayList<Card>();
        this.time =null;
    }

    public class WarListener implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            start();
        }
    }

    public class WarTieListener implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            cards.add(h1.flip());
            cards.add(h2.flip());
            cards.add(h1.flip());
            cards.add(h2.flip());

            cards.add(h1.flip());
            cards.add(h2.flip());
            panel.display(cards.get(6), cards.get(7), true);
            if(cards.get(6).getVal()<cards.get(7).getVal()){
                h2.won(cards);
            } else {
                h1.won(cards);
            }
        }
    }



    public void start(){
        cards = new ArrayList<Card>();
        cards.add(h1.flip());
        cards.add(h2.flip());
        Card one = cards.get(0);
        Card two = cards.get(1);
        int num1 = one.getVal();
        int num2 = two.getVal();

        //display cards

        l1.setText("" + h1.getScore());
        l2.setText("" + h2.getScore());

        panel.display(one, two, false);

        //compare
        if(num1>num2){
            h1.won(cards);
        } else if(num2>num1){
            h2.won(cards);
        } else { // tie

            cards.add(h1.flip());
            cards.add(h2.flip());
            cards.add(h1.flip());
            cards.add(h2.flip());

            cards.add(h1.flip());
            cards.add(h2.flip());
            panel.display(cards.get(6), cards.get(7), true);
            if(cards.get(6).getVal()<cards.get(7).getVal()){
                h2.won(cards);
            } else {
                h1.won(cards);
            }
        }


    }
}
