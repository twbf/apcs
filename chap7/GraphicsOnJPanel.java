import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.Math;
import java.lang.*;
import java.awt.Graphics2D;
import java.awt.Frame;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;

public class GraphicsOnJPanel extends JFrame{
    public GraphicsOnJPanel (){
        setSize (Toolkit.getDefaultToolkit ().getScreenSize ());
        setResizable (false);
        setContentPane (new JPanel ()
        {
            public void paint (Graphics g)
            {
                g.setColor (Color.RED);
                g.fillRect (100, 100, 100, 100);
             }
         }
         );
    setVisible (true);
}
}
