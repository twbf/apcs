import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Ex5{
    public static void main(String args[]){
        ArrayList<Integer> test = new ArrayList<Integer>(Arrays.asList(4,0,3,2,1));
        System.out.println(test);
        test = doubleList(test);
        System.out.println(test);
    }

    public static ArrayList<Integer> doubleList(ArrayList<Integer> input){
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (Integer x : input){
            for(int i = 0; i<x; i++){
                output.add(x);
            }
        }
        return output;
    }
}
