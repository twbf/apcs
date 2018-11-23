import java.io.*;
import java.util.*;

public class JNeural{

    private int[] numLayers;

    private double[][] biases;
    private double[][][] weights;
    private double[][] activations;

    public static void main(String args[]){
        int[] numLayers = {2,10,1};
        double[] start = {1,1};
        JNeural n = new JNeural(numLayers, start);
    }

    public JNeural(int[] numLayers, double[] start){
        this.numLayers = numLayers;
        this.weights = new double[numLayers.length][][];
        this.biases = new double[numLayers.length][];
        this.activations = new double[numLayers.length][];

        for(int i = 1; i<numLayers.length; i++){ // starting at 1 because the first layer doesn't have weights and biases
            biases[i] = new double[numLayers[i]];
            weights[i] = new double[numLayers[i]][];
            activations[i] = new double[numLayers[i]];
            setNodes(numLayers[i], i);
        }

        run(start);
    }

    private void setNodes(int numNodes, int layer){  // sets the biases and weights
        double random = 1; // need to change
        for(int i = 0; i<numNodes; i++){
            biases[layer][i] = random;
            weights[layer][i] = new double[numLayers[layer-1]]; // need to change the three
            for(int j = 0; j<weights[layer][i].length; j++){
                weights[layer][i][j] = random;
            }
        }
    }

    private void run(double[] start){
        activations[0] = start;
        for(int i = 1; i<numLayers.length; i++){ // each layer
            for(int j =0; j<numLayers[i]; j++){ //each node
                double sum = 0;
                for(int k = 0; k<weights[i][j].length;k++){
                    sum+=weights[i][j][k]*activations[i-1][k]; // doing every weight
                }
                activations[i][j] = sigmoid(sum - biases[i][j]); //sigmoid of the sum - the bias
            }
        }
        System.out.println(activations[2][0]);
    }

    private double sigmoid(double x){
        return 1/(1+Math.exp(-x));
    }

    private double sigmoidDx(double x){
        return sigmoid(x)*1-sigmoid(x);
    }
}
