import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;

public class War{
    private Hand h1;
    private Hand h2;
    private JLabel l1;
    private JLabel l2;

    public static void main(String[] args) {
        War a = new War();
    }

    public War(){
        JFrame frame = new JFrame("Game of War");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640,480);
        frame.setResizable(false);

        //card display
        JPanel panel = new JPanel();
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
        int num1 = cards.get(0).getVal();
        int num2 = cards.get(1).getVal();

        //display cards
        l1.setText("" + num1);
        l2.setText("" + num2);

        //compare
        if(num1>num2){
            h1.won(cards);
        } else if(num2>num1){
            h2.won(cards);
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
