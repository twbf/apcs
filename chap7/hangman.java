import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;

class Hangman{
    public static void main(String args[]) throws FileNotFoundException{

        JFrame guiFrame = new JFrame();
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // so it closes nicely
        guiFrame.setTitle("Hangman");
        guiFrame.setSize(300,250);

        JPanel pane = new JPanel();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        JButton[] buttons = new JButton[26];
        for(int i = 0; i<26; i++){
            buttons[i] = new JButton(String.valueOf(alphabet[i]));
            pane.add(buttons[i]);
        }

        guiFrame.add(pane);
        new GraphicsOnJPanel(1);

        guiFrame.setVisible(true);
        //get file of words

        //play
        String word = "and";
        //add stuff
        //char guess =

    }




}
