import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Ex13{
    public static void main(String args[]){
        ArrayList<Integer> test = new ArrayList<Integer>(Arrays.asList(3, 8, 19, 42, 7, 26, 19, -8));
        System.out.println(test);
        test = reverse3(test);
        System.out.println(test);
    }

    public static ArrayList<Integer> reverse3(ArrayList<Integer> input){
        ArrayList<Integer> output = new ArrayList<Integer>();
        for(int i = 0; i<input.size() - 3; i+=3){
            output.add(input.get(i+2));
            output.add(input.get(i+1));
            output.add(input.get(i));
        }
        for(int i = 0; i<input.size()%3; i++){
            output.add(input.get(input.size()-i - 1));
        }
        return output;
    }
}
