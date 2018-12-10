import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Ex10{
    public static void main(String args[]){
        ArrayList<String> test = new ArrayList<String>(Arrays.asList("to", "be", "or", "not", "to", "be", "that", "is", "the", "question"));
        System.out.println(test);
        test = removeInRange(test, "free", "rich");
        System.out.println(test);
    }

    public static ArrayList<String> removeInRange(ArrayList<String> input, String first, String last){
        ArrayList<String> output = new ArrayList<String>();
        for (String x : input){
            if (x.compareTo(first) < 0 || x.compareTo(last) > 0){
                output.add(x);
            }
        }
        return output;
    }
}
