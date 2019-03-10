import java.util.*;
import java.io.*;

public class Individual {

    public ArrayList<String> DNA;

    public int fitness = 0;
    public int ID = 0;

    public Individual(int id){
        this.ID = id;
        PossibleAminoAcids acids = new PossibleAminoAcids();
        DNA = new ArrayList<String>(acids.getAcids());
        Collections.shuffle(DNA);
    }

    public void computeFitness(){
        String program_name = "programs/" + ID + ".java";
        String program = "";
        for (String line: DNA){
            program += line;
        }
        try (PrintWriter out = new PrintWriter(program_name)) {
            out.println(program);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        try{
            Runtime rt = Runtime.getRuntime();
            Process pr = rt.exec("javac " + program_name); //compile
            Process pro = rt.exec("java " + ID); //run
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
