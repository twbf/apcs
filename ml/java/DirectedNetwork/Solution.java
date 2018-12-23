import java.io.*;
import java.util.*;
import java.lang.*;


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

        grouping = new int[6][];
        grouping[0] = new int[] {1,2}; // 0 likes 1 and two
        grouping[1] = new int[] {0,2};
        grouping[2] = new int[] {1,2};
        grouping[3] = new int[] {4,5};
        grouping[4] = new int[] {3,5};
        grouping[5] = new int[] {3,4};

        all = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5));
        subset = all;
        instance = new ArrayList<Integer>();
        for(int i = 0; i<all.size(); i++){
            instance.add(-1);
        }

        counter = 0;
        choose(all.size());
        System.out.println(counter);
    }

    private void choose(int size){
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
                        System.out.println(instance);
                        System.out.println(score());
                        counter++;
                        subset = all;
                    }
                }
            }
    }

    private int score(){ // scores the instance variable with the grouping one
        int outScore = 0;
        int x,y,z;
        for(int i = 0; i<all.size(); i+= 3){
            x = instance.get(i);
            y = instance.get(i+1);
            z = instance.get(i+2);
            if (contains(grouping[x], y)){
                outScore++;
            }
            if (contains(grouping[x], z)){
                outScore++;
            }
            if (contains(grouping[y], x)){
                outScore++;
            }
            if (contains(grouping[y], z)){
                outScore++;
            }
            if (contains(grouping[z], x)){
                outScore++;
            }
            if (contains(grouping[z], y)){
                outScore++;
            }
        }
        return outScore;
    }

    private boolean contains (int[] array, int key){
        for (int i = 0; i<array.length; i++){
            if (array[i] == key){
                return true;
            }
        }
        return false;
    }
}
