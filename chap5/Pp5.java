import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.Math;

class Pp5{
    public static void main(String args[]){
        //initialy setting the scores
        int human = 0;
        int computer = 0;
        while (Math.abs(computer - human)<3){ // there need to be a difference of three for the game to end
            int play = play(); // play
            if (play == 0){
                System.out.println("Tie");
            } else if (play == 1) {
                System.out.println("You win");
                human++;
            } else {
                System.out.println("Computer Wins");
                computer++;
            }

            //score
            System.out.println("Computer: " + computer + "    Human: " + human);
            System.out.println(" ");
        }
        //final score
        System.out.println("Computer: " + computer + "    Human: " + human);
    }

    public static int play(){
        System.out.println("Rock-1 Paper-2 Sicors-3");
        Scanner console = new Scanner(System.in);
        int human = console.nextInt();  // new int
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
