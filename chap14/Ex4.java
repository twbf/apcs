import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Ex4{
    public static void main(String args[]){
        JFrame frame = new JFrame();
        frame.setTitle("Midterm On Thursday!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,250);
        frame.setLayout(new BorderLayout());

        JPanel subsetTop = new JPanel(new BorderLayout());
        subsetTop.add(new JButton("1"), BorderLayout.WEST);
        subsetTop.add(new JTextField("text"), BorderLayout.CENTER);

        JPanel top = new JPanel(new GridLayout(3,1));
        top.add(new JButton("2"));
        top.add(subsetTop);
        top.add(new JButton("3"));

        JPanel subset1 = new JPanel(new BorderLayout());
        subset1.add(new JButton("5"),BorderLayout.SOUTH);

        JPanel subset2 = new JPanel(new FlowLayout());
        subset2.add(new JButton("6"));
        subset2.add(new JButton("7"));

        JPanel center = new JPanel(new GridLayout(2,2));
        center.add(new JButton("4"));
        center.add(subset1);
        center.add(subset2);
        center.add(new JButton("8"));

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(new JLabel("Pretty Tricky"), BorderLayout.WEST);

        frame.add(center, BorderLayout.CENTER);
        frame.add(top, BorderLayout.NORTH);
        frame.add(bottom, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
