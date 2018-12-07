import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Ex1{
    public static void main(String args[]){
        ArrayList<String> test = new ArrayList<String>();
        test.add("fasde");
        test.add("fasdoudeaioeeeee");
        System.out.println(averageVowel(test));
    }

    public static double averageVowel (ArrayList<String> test){
        double vowels = 0;
        double letters = 0;

        for(String x : test){
            for(int i = 0; i<x.length(); i++){
                letters++;
                if (x.charAt(i) == 'a' || x.charAt(i) == 'e' || x.charAt(i) == 'i' || x.charAt(i) == 'o' || x.charAt(i) == 'u'){
                    vowels++;
                }
            }
        }
        return vowels/letters;
    }
}
