import java.util.Scanner;
import java.io.*;

class Pp{

    public static final int SIZE = 10;

    public static void main(String args[]){
        Scanner input = new Scanner("the the the a cat cat");
        String[] listBook = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
        int[] freq = new int[SIZE];

        int count = 0;
        while (input.hasNext()) { // need to make expandable
            String word = input.next();
            int check = check(listBook, word);  // -1 if not there
            
            if (check == -1){
                listBook[count] = word;
                freq[count]++;
                count++;
            } else {
                freq[check]++;
            }
        }


        //sort to find max 10

        //prints
        for (int i = 0; i<SIZE; i++){
            System.out.println(listBook[i] + " " + freq[i]);
        }
    }

    public static int check(String [] listBook, String word){
        for (int i = 0; i<SIZE; i++){
            if (listBook[i].equals(word)){
                return i;
            }
        }
        return -1;
    }
}
