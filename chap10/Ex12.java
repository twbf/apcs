import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Ex12{
    public static void main(String args[]){
        ArrayList<String> test = new ArrayList<String>(Arrays.asList("this", "is", "lots", "of", "fun", "for", "Java", "coders"));
        System.out.println(test);
        test = markLength4(test);
        System.out.println(test);
    }

    public static ArrayList<String> markLength4(ArrayList<String> input){
        ArrayList<String> output = new ArrayList<String>();
        for (String x : input){
            if (x.length() == 4){
                output.add("****");
                output.add(x);
            } else {
                output.add(x);
            }
        }
        return output;
    }
}
