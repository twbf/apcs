import java.util.Scanner;
import java.io.*;
import java.util.*;

class Pp{
    public static void main(String args[]) throws FileNotFoundException{
        File file = new File("input.txt");
        Scanner input = new Scanner(file);
        List<String> listBook = new ArrayList<String>(); // list of words
        ArrayList<Integer> freq = new ArrayList<>(); // array of the frequencies

        int count = 0;
        while (input.hasNext()) { // need to make expandable
            String word = input.next();
            int check = listBook.indexOf(word);  // -1 if not there
            if (check == -1){
                listBook.add(word);
                freq.add(1);
                count++;
            } else {
                freq.set(check, freq.get(check) + 1); // adds one to the right spot
            }
        }

        //sort to find max 10

        //prints
        for (int i = 0; i<listBook.size(); i++){
            System.out.println(listBook.get(i) + " " + freq.get(i));
        }
    }
}
