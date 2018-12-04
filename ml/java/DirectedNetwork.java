import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class DirectedNetwork{

    public static void main(String args[]) throws FileNotFoundException{
        int numPeople = 6;
        int numGroups = 2;

        int[][] grouping = new int[6][];
        grouping[0] = {1,2}; // 0 likes 1 and two
        grouping[1] = {1,2};
        grouping[2] = {1,2};
        grouping[3] = {0,2};
        grouping[4] = {2,5};
        grouping[5] = {2,3};

        int[] instance = new int[numPeople];

        //this is for one instance
        for(int h = 0; h<10; h++){ // 20 is 6 choose 3
            for(int i = 0; i<numPeople; i++){
                //set 1s
                instance[0] = 1;

                //set 2s
                for(int i = 0; i<numPeople; i++){
                    if (instance[i] == 0){
                        instance[i] = 2;
                    }
                }


            }
            //get score
        }
    }
}
