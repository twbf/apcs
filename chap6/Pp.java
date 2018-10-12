import java.util.Scanner;
import java.io.*;
import java.util.*;

class Pp{

    public static final int SIZE = 10;

    public static void main(String args[]){
        Scanner input = new Scanner("the the the a cat cat");
        List<String> listBook = new ArrayList<String>(); // list of words
        int[] freq = new int[SIZE]; // array of the frequencies

        int count = 0;
        while (input.hasNext()) { // need to make expandable
            String word = input.next();
            int check = listBook.indexOf(word);  // -1 if not there
            if (check == -1){
                listBook.add(word);
                freq[count]++;
                count++;
            } else {
                freq[check]++;
            }
        }

        //sort to find max 10

        //prints
        for (int i = 0; i<listBook.size(); i++){
            System.out.println(listBook.get(i) + " " + freq[i]);
        }
    }
}
