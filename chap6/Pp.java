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

        List<String> maxWords = new ArrayList<String>(); // list of words
        ArrayList<Integer> maxFreq = new ArrayList<>();

        //sort to find max 10
        for(int i = 0; i<20; i++){  // 10 maxes
            int index = 0;
            int thing = 0;
            for (int j = 0; j<listBook.size(); j++){  // index of max
                if (thing<freq.get(j)){
                    thing = freq.get(j);
                    index = j;
                }
            }
            maxWords.add(listBook.get(index));
            maxFreq.add(freq.get(index));
            //System.out.println(listBook.get(index) + " " + freq.get(index));  // print the max
            listBook.remove(index);  // remove max
            freq.remove(index); // remove max
        }

        //make it into a histogram
        for (int i = 0; i<maxWords.size(); i++) {
            System.out.printf("%-15s", maxWords.get(i));
            for(int j = 0; j<maxFreq.get(i); j++){
                System.out.print("*");
            }
            System.out.println(" ");
        }

    }
}
