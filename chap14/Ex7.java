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
        frame.setTitle("Compose Message");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,200);
        frame.setLayout(new FlowLayout());

        JTextField first = new JTextField(5);
        JTextField secound = new JTextField(5);
        JLabel answer = new JTextField();

        JButton plus = new JButton("+");
        plus.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int x = first.getText().toInt() + secound.getText().toInt()
                text.setText(text.getText().toUpperCase());
            }
        });

        frame.setVisible(true);
    }
}
