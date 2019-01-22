// This program reads two text files and compares the vocabulary used in each.

import java.util.*;
import java.io.*;

public class Vocabulary3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        giveIntro();

        System.out.print("file #1 name? ");
        Scanner input1 = new Scanner(new File(console.nextLine()));
        System.out.print("file #2 name? ");
        Scanner input2 = new Scanner(new File(console.nextLine()));
        System.out.println();

        Set<String> list1 = getWords(input1);
        Set<String> list2 = getWords(input2);
        Set<String> overlap = getOverlap(list1, list2);

        reportResults(list1, list2, overlap);
    }

    // post: reads all words from the given Scanner, turning them to lowercase
    //       and returning a sorted list of the vocabulary of the file
    public static Set<String> getWords(Scanner input) {
        // read all words and sort
        Set<String> words = new TreeSet<String>();
        while (input.hasNext()) {
            String next = input.next().toLowerCase();
            words.add(next);
        }
        return words;
    }

    // pre : list1 and list2 are sorted and contain no duplicates
    // post: constructs and returns an ArrayList containing the words
    //       in common betweeen list1 and list2
    public static Set<String> getOverlap(Set<String> list1,
                                               Set<String> list2) {
        list1.retainAll(list2);
        return list1;
    }

    // post: explains program to user
    public static void giveIntro() {
        System.out.println("This program compares the vocabulary of two");
        System.out.println("text files, reporting the number of words");
        System.out.println("in common and the percent of overlap.");
        System.out.println();
    }

    // pre : overlap contains the words in commmon between list1 and list2
    // post: reports statistics about two word lists and their overlap
    public static void reportResults(Set<String> list1,
                                     Set<String> list2,
                                     Set<String> overlap) {
        System.out.println("file #1 words = " + list1.size());
        System.out.println("file #2 words = " + list2.size());
        System.out.println("common words  = " + overlap.size());

        double percent1 = 100.0 * overlap.size() / list1.size();
        double percent2 = 100.0 * overlap.size() / list2.size();
        System.out.println("% of file 1 in overlap = " + percent1);
        System.out.println("% of file 2 in overlap = " + percent2);
    }
}
