import java.util.Scanner;
import java.util.*;

class Pp7{
    public static void main(String args[]){
        int[] num = new int[10];
        int layer2[] = {1};

        for (int i = 1; i<num.length; i++){
            String out = "";
            int layer[] = new int[i];
            layer[0] = 1;
            layer[layer.length - 1] = 1;

            //adds the two above it
            for (int j = 1; j<i-1; j++){
                layer[j] = layer2[j-1] + layer2[j];
            }

            //adds spacing to make it a pyramid
            for(int j = 0; j<num.length - i; j++){
                out += String.format("    ");
            }

            // adds numbers left justified to ou
            for (int j = 0; j<i; j++){
                out += String.format("%-8d", layer[j]);
            }

            //sets the previous layer to the current layer
            layer2 = layer;
            System.out.println(out); // prints
        }
    }
}
