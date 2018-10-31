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
        guiFrame.setSize(300,250);
        JPanel pane = new JPanel();

        GraphicsOnJPanel s = new GraphicsOnJPanel();

        //sets word that is supposed to be guessed.
        String word = "and";

        //word lines
        JLabel[] labels = new JLabel[word.length()];
        for(int i = 0; i<word.length(); i++){
            labels[i] = new JLabel(" _ ");
            pane.add(labels[i]);
        }
        //makes button with action listener
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        JButton[] buttons = new JButton[26];
        for(int i = 0; i<26; i++){
            buttons[i] = new JButton(String.valueOf(alphabet[i]));

            buttons[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    int letter = 0;
                    for(int i = 0; i<26; i++){
                        if (e.getSource() == buttons[i]){
                            letter = i+97;
                        }
                    }
                    guess(s, letter, word, labels);
                }
            });

            pane.add(buttons[i]);
        }

        guiFrame.add(pane, BorderLayout.NORTH);
        guiFrame.add(s, BorderLayout.CENTER);
        s.repaint();
        guiFrame.setVisible(true);
    }

    public static void guess(GraphicsOnJPanel g, int letter, String word, JLabel[] labels){ // letter still int

        int detect = 0;  // used to detect if there was a guess

        System.out.println(Character.toChars(letter));
        for(int i = 0; i<word.length(); i++){
            if(letter.equals(word.charAt(i))){ // checks if there is that letter
                detect = 1; // no error
                labels[i] = new JLabel(" " + word.charAt(i) + " "); // fills in all the letters well
            }
        }

        if (detect == 0){  // if there was no letter then it fills it in
            g.setErrors(g.errors++);
            g.repaint();
        }

    }
}
