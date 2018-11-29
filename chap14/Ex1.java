import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Ex1{

    public static void main(String args[]){
        JFrame frame = new JFrame();
        frame.setTitle("Good Thing I Studied");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(285,200);

        JPanel topPanel = new JPanel(new GridLayout(1,3));
        JButton b1 = new JButton("Button 1");
        JButton b2 = new JButton("Button 2");
        JButton b3 = new JButton("Button 3");
        topPanel.add(b1);
        topPanel.add(b2);
        topPanel.add(b3);

        JPanel centerPanel = new JPanel(new GridLayout(2,2));
        JButton b4 = new JButton("Button 4");
        JButton b5 = new JButton("Button 5");
        JButton b6 = new JButton("Button 6");
        JButton b7 = new JButton("Button 7");
        centerPanel.add(b4);
        centerPanel.add(b5);
        centerPanel.add(b6);
        centerPanel.add(b7);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        JLabel label = new JLabel("Type Stuff");
        JTextField text = new JTextField(8);
        bottomPanel.add(label);
        bottomPanel.add(text);

        frame.setLayout(new BorderLayout());
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
