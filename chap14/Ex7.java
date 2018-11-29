import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Ex7{
    public static void main(String args[]){
        JFrame frame = new JFrame();
        frame.setTitle("MegaCalc");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,200);
        frame.setLayout(new BorderLayout());

        JTextField first = new JTextField(5);
        JTextField secound = new JTextField(5);
        JLabel answer = new JLabel();

        JButton plus = new JButton("+");
        plus.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int x = Integer.parseInt(first.getText()) + Integer.parseInt(secound.getText());
                answer.setText(Integer.toString(x));
            }
        });
        
        JPanel panel = new JPanel();
        panel.add(first);
        panel.add(plus);
        panel.add(secound);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(answer, BorderLayout.CENTER);
        frame.add(new JButton("Clear"), BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
