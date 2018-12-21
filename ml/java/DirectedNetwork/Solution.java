import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.event.*;


import java.util.concurrent.TimeUnit;

public class Solution{

    private int[][] grouping;
    private ArrayList<Integer> instance;
    private ArrayList<Integer> all;
    private ArrayList<Integer> subset;
    private ArrayList<Integer> indexes;
    private int counter;

    //I realize that one should only have to do 1/n!

    public static void main(String args[]) throws FileNotFoundException{
        long start = System.currentTimeMillis();
        Solution s = new Solution();
        long end = System.currentTimeMillis() - start;
        System.out.println("Elapsed time in milliseconds: " + end);
    }

    public Solution(){

        //grouping = new int[6][];
        //grouping[0] = {1,2}; // 0 likes 1 and two
        //grouping[1] = {1,2};
        //grouping[2] = {1,2};
        //grouping[3] = {0,2};
        //grouping[4] = {2,5};
        //grouping[5] = {2,3};

        all = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
        subset = all;
        instance = new ArrayList<Integer>();
        indexes = new ArrayList<Integer>();

        counter = 0;
        choose(all.size());
        System.out.println(counter);
    }

    public void choose(int size){
        int x,y,z;
            for(int j = 1; j < size; j++){
                for(int k = j+1; k < size; k++){
                    x = subset.get(0);
                    y = subset.get(j);
                    z = subset.get(k);
                    instance.add(x);
                    instance.add(y);
                    instance.add(z);
                    if(size-3>0){
                        indexes.add(0);
                        indexes.add(j);
                        indexes.add(k);
                        Collections.sort(indexes, Collections.reverseOrder());
                        for(int index : indexes){
                            subset.remove(index);
                        }
                        indexes = new ArrayList<Integer>();
                        choose(size-3);
                        subset.add(0,x);
                        subset.add(j,y);
                        subset.add(k,z);
                    } else {
                        //print
                        //System.out.println(instance);
                        counter++;
                        subset = all;
                    }
                    //reset instance
                    instance.remove(instance.size()-1);
                    instance.remove(instance.size()-1);
                    instance.remove(instance.size()-1);
                }
            }
    }

    public void score(){ // scors the instance variable with the grouping one
        int outScore = 0;
        int count;
        //for(int i = 0; i<numGroups; i++){

        //}
    }
}
