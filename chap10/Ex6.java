import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Ex6{
    public static void main(String args[]){
        ArrayList<Integer> test = new ArrayList<Integer>(Arrays.asList(3,8,92,4,2,17,9));
        System.out.println(test);
        test = minToFrount(test);
        System.out.println(test);
    }

    public static ArrayList<Integer> minToFrount(ArrayList<Integer> input){
        ArrayList<Integer> output = new ArrayList<Integer>();
        int min = 99;
        int index = 0;
        for(int i = 0; i<input.size(); i++){
            if (min > input.get(i)){
                min = input.get(i);
                index = i;
            }
        }
        output.add(input.get(index));
        input.remove(index);

        for (Integer x : input){
            output.add(x);
        }
        return output;
    }
}
