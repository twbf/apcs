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

class Pp5{

    public static int diff = 0;

    public static void main(String args[]){
        //gui
        JFrame guiFrame = new JFrame();
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // so it closes nicely
        guiFrame.setTitle("Rock Paper Scissors");
        guiFrame.setSize(300,250);

        JPanel pane = new JPanel(); // pane

        //labels
        JLabel scoreLabel = new JLabel("score");
        JLabel playLabel = new JLabel("play");
        scoreLabel.setText(" ");
        playLabel.setText(" ");


        // buttons
        // overide is so that when it is clicked stuff happens

        JButton rock=new JButton("Rock");
        rock.addActionListener(new ActionListener() {

			      @Override
			      public void actionPerformed(ActionEvent arg0) {
					  int play = play(1); // with rock
                      points(scoreLabel, playLabel, play);
			      }
	    });

        JButton paper=new JButton("Paper");
        paper.addActionListener(new ActionListener() {

  			    @Override
  			        public void actionPerformed(ActionEvent arg0) {
  					     int play = play(2); // with paper
                         points(scoreLabel, playLabel, play);// count points
  			    }
  	    });

        JButton scii=new JButton("Scissors");
        scii.addActionListener(new ActionListener() {

  			    @Override
  			        public void actionPerformed(ActionEvent arg0) {
  					     int play = play(3); // with rock
                 points(scoreLabel, playLabel, play);
  			    }
  	    });

        pane.add(rock);
        pane.add(paper);
        pane.add(scii);
        pane.add(scoreLabel);
        pane.add(playLabel);
        guiFrame.add(pane);

        guiFrame.setVisible(true);
    }

    public static void points(JLabel playLabel, JLabel score, int play){
        if (play == 0){
            playLabel.setText("Tie");
        } else if (play == 1) {
            playLabel.setText("You win");
            diff++;
        } else {
            playLabel.setText("Computer Wins");
            diff--;
        }
        score.setText(Integer.toString(diff));
        if (Math.abs(diff)>2){
            if(diff == -3){
                playLabel.setText("YOUR A BIG FAT LOSER");
            }
            if(diff == 3){
                playLabel.setText("WINNER WINNER CHICKEN DINNER");
            }
            score.setText("GAME OVER");
        }
    }

    public static void movePiece(int play){
        int increment = 10;
        //move peice each way
    }

    public static int play(int human){
        //System.out.println("Rock-1 Paper-2 Sicors-3");
        //Scanner console = new Scanner(System.in);
        //int human = console.nextInt();  // new int
        int computer = ThreadLocalRandom.current().nextInt(1, 4); // to make 1-3 inclusive
        if (human == computer){ // tie
            return 0;
        }
        System.out.println("Computer: " + computer);
        if(human + computer == 3){ // rock and paper
            if (human == 2){
                return 1;
            }
            return -1;
        }

        if(human + computer == 4){ // rock and siccors
            if (human == 1){
                return 1;
            }
            return -1;
        }

        if(human + computer == 5){ // sicors and paper
            if (human == 3){
                return 1;
            }
            return -1;
        }
        return 2; // something went wrong
    }
}
