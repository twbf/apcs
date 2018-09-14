public class Note{
    private String name;
    private int octave;
    private int length; // 1 is a 16th notes
    private double gain;

    public Note(String n, int l, int o, double g){
        length = l;
        name = n;
        octave = o;
        gain = g;
    }

    public Note(String n, int l){
        length = l;
        name = n;
    }

    public Note(String n){
        length = 16;
        name = n;
    }

    public String getName(){
        return name;
    }

    public int getOctave(){
        return octave;
    }

    public int getLength(){
        return length;
    }

    public double getGain(){
        return gain;
    }
}
