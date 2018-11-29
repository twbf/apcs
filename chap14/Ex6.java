import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Ex6{
    public static void main(String args[]){
        JFrame frame = new JFrame();
        frame.setTitle("Compose Message");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,200);
        frame.setLayout(new FlowLayout());

        JTextField text = new JTextField(20);

        JButton upper = new JButton("Upper Case");
        upper.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                text.setText(text.getText().toUpperCase());
            }
        });

        JButton lower = new JButton("Lower Case");
        lower.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                text.setText(text.getText().toLowerCase());
            }
        });

        frame.add(upper);
        frame.add(text);
        frame.add(lower);

        frame.setVisible(true);
    }
}
