import java.util.Scanner;
import java.util.*;

class Pp7{
    public static void main(String args[]){
        int[] num = new int[1000];
        int layer2[] = {1};
        
        for (int i = 1; i<num.length; i++){
            int layer[] = new int[i];
            layer[0] = 1;
            layer[layer.length - 1] = 1;
            for (int j = 1; j<i-1; j++){
                layer[j] = layer2[j-1] + layer2[j];

            }
            for (int j = 0; j<i; j++){
                System.out.println(layer[j]);
            }
            layer2 = layer;
        }
    }
}
