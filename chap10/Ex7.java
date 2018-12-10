import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Ex7{
    public static void main(String args[]){
        ArrayList<String> test = new ArrayList<String>(Arrays.asList("be", "be", "is", "not", "or", "question", "that", "the", "to", "to"));
        System.out.println(test);
        test = minToFrount(test);
        System.out.println(test);
    }

    public static ArrayList<String> minToFrount(ArrayList<String> input){
        ArrayList<String> output = new ArrayList<String>();
        String y = "";
        for (String x : input){
            if (!x.equals(y)){
                output.add(x);
            }
            y = x;
        }
        return output;
    }
}
