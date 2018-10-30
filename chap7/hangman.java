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

        JPanel s = new GraphicsOnJPanel();

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
                    guess(s, letter);
                }
            });

            pane.add(buttons[i]);
        }
        guiFrame.add(pane);
        guiFrame.add(s);
        guiFrame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(100, 100, 100, 100);
    }

    public static void guess(JPanel g, int letter){ // letter still int
        //s.repaint();
        System.out.println(Character.toChars(letter));
    }
}


//Need to work on graphics with the buttons. It is not doing this correctly. If that doesn't work I
//will switch it over to one file.
