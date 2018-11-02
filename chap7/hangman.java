import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Hangman{
    public static void main(String args[]) throws FileNotFoundException{

        //sets frame
        JFrame guiFrame = new JFrame();
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // so it closes nicely
        guiFrame.setTitle("Hangman");
        guiFrame.setSize(1240,800);
        JPanel pane1 = new JPanel();
        JPanel pane2 = new JPanel();

        GraphicsOnJPanel s = new GraphicsOnJPanel();

        //sets word that is supposed to be guessed.
        String word = "and";

        //word lines
        JLabel[] labels = new JLabel[word.length()];
        for(int i = 0; i<word.length(); i++){
            labels[i] = new JLabel(" _ ");
            labels[i].setFont(new Font("Sans-Serif", Font.PLAIN, 60));
            pane2.add(labels[i]);
        }

        //makes button with action listener
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        JButton[] buttons = new JButton[26];
        for(int i = 0; i<26; i++){
            buttons[i] = new JButton(String.valueOf(alphabet[i]));
            buttons[i].setPreferredSize(new Dimension(40, 20));
            buttons[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    int letter = 0;
                    for(int i = 0; i<26; i++){
                        if (e.getSource() == buttons[i]){ // checks if the button is the one clicked
                            letter = i+97;
                            buttons[i].setEnabled(false);
                        }
                    }
                    guess(s, (char) letter, word, labels);
                }
            });

            pane1.add(buttons[i]);
        }

        guiFrame.add(pane1, BorderLayout.NORTH);
        guiFrame.add(pane2, BorderLayout.WEST);
        guiFrame.add(s, BorderLayout.CENTER);
        s.repaint();
        guiFrame.setVisible(true);
    }

    public static void guess(GraphicsOnJPanel g, char letter, String word, JLabel[] labels){ // letter still int

        int detect = 0;  // used to detect if there was a guess

        for(int i = 0; i<word.length(); i++){
            if(letter == word.charAt(i)){ // checks if there is that letter
                detect = 1; // no error
                labels[i].setText(" " + word.charAt(i) + " "); // fills in all the letters well
            }
        }

        if (detect == 0){  // if there was no letter then it fills it in
            g.errors = g.errors + 1;
            g.setErrors(g.errors);
            g.repaint();
            //System.out.println(g.errors);
        }
    }
}
