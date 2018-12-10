import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Ex9{
    public static void main(String args[]){
        ArrayList<Integer> test = new ArrayList<Integer>(Arrays.asList(7, 2, 0, 0, 4, 0, 9, 0, 6, 4, 8));
        System.out.println(test);
        int x = rangeBetweenZeros(test);
        System.out.println(x);
    }

    public static int rangeBetweenZeros(ArrayList<Integer> input){
        int min = -1;
        int max = -1;
        for(int i = 0; i<input.size(); i++){
            if (input.get(i) == 0){
                if (min  == -1){
                    min = i;
                    max = i;
                }
                max = i;
            }
        }
        return max - min + 1;
    }
}
