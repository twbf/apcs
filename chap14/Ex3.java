import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Ex3{
    public static void main(String args[]){
        JFrame frame = new JFrame();
        frame.setTitle("Midterm On Thursday!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,250);
        frame.setLayout(new BorderLayout());

        JPanel center = new JPanel(new GridLayout(1,1));
        center.add(new JTextArea());

        JPanel left = new JPanel(new GridLayout(8,1));
        left.add(new JButton("Now Playing"));
        left.add(new JButton("Media Guide"));
        left.add(new JButton("Library"));
        left.add(new JButton("Help & Info"));
        left.add(new JButton("Services"));

        JPanel small = new JPanel(new GridLayout(2,2));
        small.add(new JButton("0"));
        small.add(new JButton("1"));
        small.add(new JButton("2"));
        small.add(new JButton("3"));

        JPanel big = new JPanel(new GridLayout(1,1));
        big.add(new JButton("OK"));

        JPanel right = new JPanel(new BorderLayout());
        right.add(small, BorderLayout.NORTH);
        right.add(big, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.add(new JLabel("Music"));
        bottomPanel.add(new JLabel("Movies"));
        bottomPanel.add(new JLabel("Videos"));
        bottomPanel.add(new JLabel("DVD"));
        bottomPanel.add(new JLabel("Web Pages"));

        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.add(left, BorderLayout.WEST);
        frame.add(right, BorderLayout.EAST);
        frame.add(center, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
