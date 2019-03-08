import java.util.ArrayList;
import java.util.*;

public class Deck ext{
    private ArrayList<Card> deck;

    public Deck(){
        this.deck = new ArrayList<Card>();
        for(int i=0;i<13;i++){
            for(int j=0;j<4;j++){
                deck.add(new Card(i, j));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public Card getCard(int index){
        return deck.get(index);
    }
}
