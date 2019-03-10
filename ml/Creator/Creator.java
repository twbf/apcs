import java.util.*;

public class Creator {

    public ArrayList<Individual> population;
    public int initial_size = 100;

    public static void main(String[] args) {
        Creator c = new Creator();
    }

    public Creator(){
        population = new ArrayList<Individual>();
        for (int i = 0; i<initial_size; i++){
            population.add(new Individual(i));
            population.get(0).computeFitness();
        }
    }
}
