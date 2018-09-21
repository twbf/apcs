import jm.JMC;
import jm.music.data.*;
import jm.util.Play;

public class Music {

        public static void main(String[] args) {
            Note n = new Note(JMC.C4, JMC.WN);
            Note y = new Note(JMC.C4, JMC.QN);
            Note x = new Note(JMC.C4, JMC.QN);
            Phrase phr = new Phrase();
            phr.addNote(new Note(JMC.C4, JMC.WN));
            phr.addNote(y);
            phr.addNote(x);
            Play.midi(phr);
        }

}
