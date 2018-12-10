import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Ex11{
    public static void main(String args[]){
        ArrayList<String> test = new ArrayList<String>(Arrays.asList("how", "are", "you?"));
        System.out.println(test);
        test = stutter(test);
        System.out.println(test);
    }

    public static ArrayList<String> stutter(ArrayList<String> input){
        ArrayList<String> output = new ArrayList<String>();
        for (String x : input){
            output.add(x);
            output.add(x);
        }
        return output;
    }
}
