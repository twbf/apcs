import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Ex2{
    public static void main(String args[]){
        JFrame frame = new JFrame();
        frame.setTitle("Layout Question");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,250);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(1,4));
        JLabel label = new JLabel("Buttons");
        JButton b1 = new JButton("hi");
        JButton b2 = new JButton("long name");
        JButton b3 = new JButton("bye");
        topPanel.add(label);
        topPanel.add(b1);
        topPanel.add(b2);
        topPanel.add(b3);

        JPanel overlay = new JPanel(new GridLayout(2,2));
        JButton o1 = new JButton("3");
        JButton o2 = new JButton("4");
        JButton o3 = new JButton("5");
        JButton o4 = new JButton("6");
        overlay.add(o1);
        overlay.add(o2);
        overlay.add(o3);
        overlay.add(o4);

        JPanel centerPanel = new JPanel(new GridLayout(2,2));
        JButton c1 = new JButton("1");
        JButton c2 = new JButton("2");
        JButton c3 = new JButton("7");
        centerPanel.add(c1);
        centerPanel.add(c2);
        centerPanel.add(overlay);
        centerPanel.add(c3);

        JPanel bottomPanel = new JPanel(new GridLayout(1,1));
        bottomPanel.add(new JButton("Cancel"));

        JPanel sidePanel = new JPanel(new GridLayout(7,2));
        sidePanel.add(new JCheckBox());
        sidePanel.add(new JLabel("Bold"));
        sidePanel.add(new JCheckBox());
        sidePanel.add(new JLabel("Italic"));
        sidePanel.add(new JCheckBox());
        sidePanel.add(new JLabel("Underline"));
        sidePanel.add(new JCheckBox());
        sidePanel.add(new JLabel("Strikeout"));

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(sidePanel, BorderLayout.WEST);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
