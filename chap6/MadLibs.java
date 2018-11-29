import java.util.Scanner;
import java.io.*;
import java.util.*;

class MadLibs{
    public static void main(String args[]) throws FileNotFoundException {
        File file = new File("libs.txt"); // get file
        Scanner input = new Scanner(file); // put it in a scanner

        List<String> list = new ArrayList<String>(); // new list

        while (input.hasNextLine()) {
            String line = input.nextLine();

            if(line.toUpperCase().equals(line)){  // if the line is all upper case
                System.out.println("What is a " + line + "?");
                Scanner sc = new Scanner(System.in); // get the word
                list.add(sc.next());
            } else {  // if the line is output
                list.add(line);
            }
        }

        // print
        System.out.println(" ");
        for (int i = 0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
