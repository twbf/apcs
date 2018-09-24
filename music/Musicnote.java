public class Musicnote{
    private String name;
    private int octave;
    private int length; // 1 is a 16th MusicMusicnotes
    private double gain;

    public Musicnote(String n, int l, int o, double g){
        length = l;
        name = n;
        octave = o;
        gain = g;
    }

    public Musicnote(String n, int l){
        length = l;
        name = n;
    }

    public Musicnote(String n){
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
