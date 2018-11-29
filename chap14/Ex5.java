import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Ex5{
    public static void main(String args[]){
        JFrame frame = new JFrame();
        frame.setTitle("Compose Message");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,200);
        frame.setLayout(new BorderLayout());

        JPanel center = new JPanel(new GridLayout(1,1));
        center.add(new JTextArea());

        JPanel bot = new JPanel(new BorderLayout());
        bot.add(new JButton("send"), BorderLayout.EAST);

        JPanel top1 = new JPanel(new GridLayout(2,1));
        top1.add(new JLabel("To:"));
        top1.add(new JLabel("CC:"));

        JPanel top2 = new JPanel(new GridLayout(2,1));
        top2.add(new JTextField());
        top2.add(new JTextField());

        JPanel top = new JPanel(new BorderLayout());
        top.add(top1, BorderLayout.WEST);
        top.add(top2, BorderLayout.CENTER);

        frame.add(center, BorderLayout.CENTER);
        frame.add(top, BorderLayout.NORTH);
        frame.add(bot, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
