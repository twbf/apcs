import jm.JMC;
import jm.music.data.*;
import jm.util.*;
import java.awt.*;
import java.util.*;

public class Music implements JMC{
    public static void main(String[] args) {
        Score s = new Score("JMDemo - Show Fractal");
        Part p = new Part("Piano", PIANO, 0);
        Phrase phr = new Phrase();
        for(int i = 0; i<10;i++){
            phr.addNote(new Note(JMC.C4, i/2));
        }
        String[] input = {"a","a"};
        show(input);
        //Play.midi(phr);
        p.addPhrase(phr);
        s.addPart(p);
        View.show(s);
    }
    public static void show(String[] input){
        int MEASURLine = 3;
        int NOTES = 4;
        int noteSpace = 64;
        Musicnote[] notes = {new Musicnote(input[0]), new Musicnote(input[1])};
        int len = notes.length;
        int LINES = findLines(len, NOTES, MEASURLine);
        DrawingPanel g = new DrawingPanel(500, LINES * 150);
        Graphics s = g.getGraphics();
        int size = 40*NOTES*MEASURLine;
        int space = 16;

        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "5");
        map.put("b", "4");
        map.put("c", "3");
        map.put("d", "2");
        map.put("e", "1");

        int count = 0;
        int spaceing = size/(NOTES*MEASURLine);
        int notesInLine = NOTES*MEASURLine;

        int xPosition = 0;
        for (int j = 0; j < LINES; j++){

            for (int i = 0; i<5; i++){
                s.drawLine(15, 30 + space*i + j*100, 15+size, 30 + space*i + j*100);
            }
            if ((len - count) < NOTES*MEASURLine){
                notesInLine = len-count;
            }
            for(int i= 0; i<notesInLine; i++){
                xPosition+=notes[count].getLength();
                if (i%4 == 0){
                    s.drawLine(15+i*spaceing, 20 + j*100 + 10, 15+i*spaceing, 20 + j*100 + space*5 - 7);
                }
                int h = Integer.parseInt(map.get(notes[count].getName()));
                s.fillOval(20 + i*spaceing, 27 + h*8 + j*100, 9, 9);
                count++;
            }
        }

    }

    public static int findLines(int len, int notes, int measure){
        double l = len;
        double n = notes;
        double m = measure;
        double lines = l/(n*m);
        return (int) (lines + 1);
    }
}
