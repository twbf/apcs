import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.Math;
import java.lang.*;
import java.awt.Graphics2D;
import java.awt.Frame;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
        new GraphicsOnJPanel ();

        guiFrame.setVisible(true);
        //buttons[0] = new JButton("0");
        //get file of words

        //play
        String word = "and";
        //add stuff
        //char guess =

    }




}
