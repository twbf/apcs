import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Ex4{
    public static void main(String args[]){
        ArrayList<String> test = new ArrayList<String>();
        test.add("to");
        test.add("bebbb");
        test.add("or");
        test.add("not");
        test.add("to");
        test.add("be");
        test.add("hamlet");
        System.out.println(test);
        test = doubleList(test);
        System.out.println(test);
    }

    public static ArrayList<String> doubleList(ArrayList<String> input){
        ArrayList<String> output = new ArrayList<String>();
        for (String x : input){
            output.add(x);
            output.add(x);
        }
        return output;
    }
}
