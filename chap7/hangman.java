import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

class Hangman{
    public static void main(String args[]) throws FileNotFoundException{

        //sets frame
        JFrame guiFrame = new JFrame();
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // so it closes nicely
        guiFrame.setTitle("Hangman");
        guiFrame.setSize(300,250);
        JPanel pane = new JPanel();

        //graphics
        GraphicsOnJPanel g = new GraphicsOnJPanel();

        //sets word that is supposed to be guessed.
        String word = "and";

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
                    guess(g, letter);
                }
            });
            pane.add(buttons[i]);
        }
        guiFrame.add(pane);
        guiFrame.setVisible(true);
    }

    public static void guess(GraphicsOnJPanel g, int letter){ // letter still int
        g.paint(1);
        System.out.println(Character.toChars(letter));
    }
}
