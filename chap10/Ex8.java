import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Ex8{
    public static void main(String args[]){
        ArrayList<Integer> test = new ArrayList<Integer>(Arrays.asList(0, 7, 2, 0, 0, 4, 0));
        System.out.println(test);
        test = minToFrount(test);
        System.out.println(test);
    }

    public static ArrayList<Integer> minToFrount(ArrayList<Integer> input){
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (Integer x : input){
            if(!x.equals(0)){
                output.add(x);
            }
        }
        return output;
    }
}
