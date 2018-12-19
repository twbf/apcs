import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Final{
    public static void main(String args[]){
        //setting frame
        JFrame frame = new JFrame();
        frame.setTitle("Press button for happiness");
        frame.setLayout(new BorderLayout());
        frame.setSize(300,200);

        //initializing button and panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,1));
        JButton b = new JButton("Exit Semester One");
        panel.add(b);

        //label panel and label
        JPanel labelPanel = new JPanel(new FlowLayout());
        JLabel label = new JLabel(" ");
        JLabel center = new JLabel("  ");
        labelPanel.add(center);
        labelPanel.add(label);

        //adding action listener
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){  //when the button is clicked
                label.setText("Hooray, you are done!!!"); // set text
                b.setEnabled(false); //disable button
            }
        });

        //add to frame
        frame.add(panel, BorderLayout.CENTER);
        frame.add(labelPanel, BorderLayout.SOUTH);

        //set frame to visable
        frame.setVisible(true);
    }
}
