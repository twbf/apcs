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
    private int[] instance;
    private int numPeople;
    private int numGroups;

    public static void main(String args[]) throws FileNotFoundException{
        numPeople = 6;
        numGroups = 2;

        grouping = new int[6][];
        grouping[0] = {1,2}; // 0 likes 1 and two
        grouping[1] = {1,2};
        grouping[2] = {1,2};
        grouping[3] = {0,2};
        grouping[4] = {2,5};
        grouping[5] = {2,3};

    }

    public int choose(int size){
        for(int i = 0; i < size; i++){
            for(int j = i+1; j < size; j++){
                for(int k = k+1; k < size; k++){
                    
                }
            }
        }
    }

    public int score(){ // scors the instance variable with the grouping one
        int outScore = 0;
        int count;
        for(int i = 0; i<numGroups; i++){

        }
    }
}