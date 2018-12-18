import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class Solution{

    private int[][] grouping;
    private ArrayList<Integer> instance;
    private ArrayList<Integer> all;
    private ArrayList<Integer> subset;
    private int numPeople;
    private int numGroups;

    public static void main(String args[]) throws FileNotFoundException{
        Solution s = new Solution();
    }

    public Solution(){
        numPeople = 6;
        numGroups = 2;

        //grouping = new int[6][];
        //grouping[0] = {1,2}; // 0 likes 1 and two
        //grouping[1] = {1,2};
        //grouping[2] = {1,2};
        //grouping[3] = {0,2};
        //grouping[4] = {2,5};
        //grouping[5] = {2,3};

        all = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
        subset = all;
        instance = new ArrayList<Integer>();
        choose(6);
    }

    public void choose(int size){
        for(int i = 0; i < size; i++){
            for(int j = i+1; j < size; j++){
                for(int k = j+1; k < size; k++){
                    int x = subset.get(i);
                    int y = subset.get(j);
                    int z = subset.get(k);
                    instance.add(x);
                    instance.add(y);
                    instance.add(z);
                    if(size-4>0){
                        subset.remove(i);
                        subset.remove(j);
                        subset.remove(k);
                        choose(size-3);
                    } else {
                        //print
                        System.out.println(instance);

                        //reset
                        subset.add(x);
                        subset.add(y);
                        subset.add(z);
                        subset = all;
                        instance = new ArrayList<Integer>();
                    }
                }
            }
        }
    }

    public void score(){ // scors the instance variable with the grouping one
        int outScore = 0;
        int count;
        for(int i = 0; i<numGroups; i++){

        }
    }
}
