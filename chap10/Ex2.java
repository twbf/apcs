import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Ex1{
    public static void main(String args[]){
        ArrayList<String> test = new ArrayList<String>;
        test.add("to");
        test.add("be");
        test.add("or");
        test.add("not");
        test.add("to");
        test.add("be");
        test.add("hamlet");
        System.out.println(averageVowel(test));
    }

    public static ArrayList<String> swapPairs (ArrayList<String> test){
        String inter = " ";
        String finalInter = " ";

        ArrayList<String> output = new ArrayList<String>;

        for(String x : test){
            try {
                if (finalInter.equals(inter)){
                    inter = x;
                } else {
                    output.add(inter);
                    output.add(x);
                    inter = " ";
                }
            } catch (exception e){}
        }
        return output;
    }
}
