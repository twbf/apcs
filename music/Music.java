import jm.JMC;
import jm.music.data.*;
import jm.util.*;
import java.awt.*;
import java.util.*;

//javac -cp jmusic.jar:. Music.java
//java -cp jmusic.jar:. Music

// use the fact that the phrase and note class has the option of getting note frequency

public class Music implements JMC{
    public static void main(String[] args) {
        Score s = new Score("JMDemo - Show Fractal");
        Part p = new Part("Piano", PIANO, 0);
        Phrase phr = new Phrase();
        for(int i = 0; i<10;i++){
            phr.addNote(new Note(JMC.A4, i/2));
        }
        //String[] input = {"a","a"};
        //show(input);
        show(phr);
        Play.midi(phr);
        p.addPhrase(phr);
        s.addPart(p);
        View.show(s);
    }

    public static void show(Phrase phr){
        Note[] notesArray = phr.getNoteArray();
        //dimensioning the staff
        int MEASURELINE = 3;
        int NOTES = 4;//number of notes per measure

        //Musicnote[] notes = {new Musicnote(input[0]), new Musicnote(input[1])}; //  array of notes
        int len = notesArray.length;
        int LINES = findLines(len, NOTES, MEASURELINE); // find number of lines

        // create drawing panel that is a dynamic size and get graphics
        DrawingPanel g = new DrawingPanel(500, LINES * 150);
        Graphics s = g.getGraphics();

        // demensions
        int notesInLine = NOTES*MEASURELINE;
        int size = 40*notesInLine; // length of line
        int space = 16; // space betweenb lines
        int spaceing = size/notesInLine; //alloted space for each note

        //mapping note letters to a number sequence
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "5");
        map.put("b", "4");
        map.put("c", "3");
        map.put("d", "2");
        map.put("e", "1");

        int count = 0; // used to count up to length of note array

        int xPosition = 0;
        for (int j = 0; j < LINES; j++){
            for (int i = 0; i<5; i++){
                s.drawLine(15, 30 + space*i + j*100, 15+size, 30 + space*i + j*100);
            }
            if ((len - count) < NOTES*MEASURELINE){
                notesInLine = len-count;
            }
            for(int i= 0; i<notesInLine; i++){
                xPosition+=1;
                if (i%4 == 0){
                    s.drawLine(15+i*spaceing, 20 + j*100 + 10, 15+i*spaceing, 20 + j*100 + space*5 - 7);
                }
                int h = notesArray[count].getPitch() - 64;
                quarterNote(s, 20 + i*spaceing, 27 + h*8 + j*100);
                count++;
            }
        }

    }

    public static void quarterNote(Graphics s, int x, int y){
        s.fillOval(x,y,9,9);
        //stem
    }

    public static void wholeNote(Graphics s, int x, int y){
        s.drawOval(x,y,9,9);
    }

    public static void halfNote(Graphics s, int x, int y){
        s.drawOval(x,y,9,9);
        //stem
    }

    public static int findLines(int len, int notes, int measure){
        // finds the number of lines needed to fill
        double l = len;
        double n = notes;
        double m = measure;
        double lines = l/(n*m);
        return (int) (lines + 1);
    }
}
