import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Buttons extends JPanel implements WindowListener,ActionListener{
    public Buttons(){
        JFrame guiFrame = new JFrame();
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // so it closes nicely
        guiFrame.setTitle("Hangman");
        guiFrame.setSize(300,250);
        JPanel pane = new JPanel();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();


        JButton[] buttons = new JButton[26];
        for(int i = 0; i<26; i++){
            buttons[i] = new JButton(String.valueOf(alphabet[i]));
            buttons[i].addActionListener( this);
            pane.add(buttons[i]);
        }
        guiFrame.add(pane);
        guiFrame.setVisible(true);
    }
}
