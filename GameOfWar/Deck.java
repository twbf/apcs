import java.util.ArrayList;
import java.util.*;

public class Deck {
    private ArrayList<Card> deck;

    public Deck(){
        for(int i=0;i<13;i++){
            for(int j=0;j<4;j++){
                Card card = new Card(i, j);
                deck.add(card);
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
