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
    private int instanceCounter = 0;

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
        for(int i = 0; i<all.size(); i++){
            instance.add(-1);
        }

        counter = 0;
        choose(all.size());
        System.out.println(counter);
    }

    public void choose(int size){
        int x,y,z;
        int jtemp, ktemp, zerotemp;
            for(int j = 1; j < size; j++){
                for(int k = j+1; k < size; k++){
                    jtemp = j;
                    ktemp = k;
                    zerotemp = 0;
                    for(int h = 0; h<=ktemp; h++){
                        if (subset.get(h) == -1){
                            if (h <= zerotemp){
                                zerotemp++;
                            }
                            if (h <= jtemp){
                                jtemp++;
                            }
                            ktemp++;
                        }
                    }
                    x = subset.get(zerotemp);
                    y = subset.get(jtemp);
                    z = subset.get(ktemp);
                    instance.set(instanceCounter, x);
                    instance.set(instanceCounter+1, y);
                    instance.set(instanceCounter+2, z);

                    if(size-3>0){
                        instanceCounter += 3;
                        subset.set(zerotemp, -1);
                        subset.set(jtemp, -1);
                        subset.set(ktemp, -1);
                        choose(size-3);
                        subset.set(zerotemp,x);
                        subset.set(jtemp,y);
                        subset.set(ktemp,z);
                        instanceCounter -= 3;
                    } else {
                        //print
                        //System.out.println(instance);
                        counter++;
                        subset = all;
                    }
                }
            }
    }

    public void score(){ // scores the instance variable with the grouping one
        int outScore = 0;
        int count;
        //for(int i = 0; i<numGroups; i++){

        //}
    }
}
