import jm.JMC;
import jm.music.data.*;
import jm.util.Play;

public class Music {
    public static void main(String[] args) {
        Phrase phr = new Phrase();
        for(int i = 0; i<10;i++){
            phr.addNote(new Note(JMC.C4, i/2));
        }
        Play.midi(phr);
    }
}
