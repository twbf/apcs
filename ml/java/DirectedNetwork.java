import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class DirectedNetwork{

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

        instance = new int[numPeople];
        int counter = 0;
        for(int i = 0; i<numPeople; i++){
            counter = i;
            for(int h = 0; h<6; h++){
                counter++;
                counter = counter%6;
                instance[h] = counter;
            }
            //score
            instance = new int[numPeople]
        }
    }

    public int score(){ // scors the instance variable with the grouping one
        int outScore = 0;
        int count;
        for(int i = 0; i<numGroups; i++){

        }
    }
}
