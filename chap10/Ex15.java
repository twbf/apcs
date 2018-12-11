import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Ex15{
    public static void main(String args[]){
        ArrayList<String> test = new ArrayList<String>(Arrays.asList("four", "score", "and", "seven", "years", "ago", "our"));
        System.out.println(test);
        test = clump(test);
        System.out.println(test);
    }

    public static ArrayList<String> clump(ArrayList<String> input){
        ArrayList<String> output = new ArrayList<String>();
        String x = "";
        String y = "";
        for (int i = 0; i<input.size()-1; i+=2){
            x = input.get(i);
            y = input.get(i+1);
            output.add("(" + x + " " + y + ")");
        }
        if(input.size()%2 == 1){
            output.add(input.get(input.size()-1)); // add the last
        }
        return output;
    }
}
