import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Buttons extends JFrame implements WindowListener,ActionListener{
    public static JButton[] buttons = new JButton[26];

    public Buttons(){
        JFrame guiFrame = new JFrame();
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // so it closes nicely
        guiFrame.setTitle("Hangman");
        guiFrame.setSize(300,250);
        JPanel pane = new JPanel();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();



        for(int i = 0; i<26; i++){
            buttons[i] = new JButton(String.valueOf(alphabet[i]));
            buttons[i].addActionListener( this);
            pane.add(buttons[i]);
        }
        guiFrame.add(pane);
        guiFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int letter = 0;
        for(int i = 0; i<26; i++){
            if (e.getSource() == buttons[i]){
                letter = i+97; // make this transfer numbers to letters
            }
        }
        System.out.println(Character.toChars(letter));
    }

    public void windowOpened(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    public void windowClosing(WindowEvent e) {
        dispose();
        System.exit(0);
    }

}
