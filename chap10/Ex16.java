import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Ex16{
    public static void main(String args[]){
        ArrayList<Integer> a1 = new ArrayList<Integer>(Arrays.asList(10, 20, 30));
        ArrayList<Integer> a2 = new ArrayList<Integer>(Arrays.asList(4, 5, 6, 7, 8));
        ArrayList<Integer> test = reverse3(a1,a2);
        System.out.println(test);
    }

    public static ArrayList<Integer> reverse3(ArrayList<Integer> a1, ArrayList<Integer> a2){
        ArrayList<Integer> output = new ArrayList<Integer>();
        int x = 0;
        int y = 0;
        while(x<a1.size() || y<a2.size()){
            if (x<a1.size()) {
                output.add(a1.get(x));
                x++;
            }
            if (y<a2.size()) {
                output.add(a2.get(y));
                y++;
            }
        }
        return output;
    }
}
