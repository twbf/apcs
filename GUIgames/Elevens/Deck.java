import java.util.*;
import java.util.ArrayList;

public class Deck{

    private ArrayList<Card> cards;
    private int size;

    public Deck(String[] ranks, String[] suits, int[] points){
        cards = new ArrayList<Card>();
        for(int i = 0; i<ranks.length; i++){
            for(int j = 0; j<suits.length; j++){
                cards.add(new Card(ranks[i], suits[j], points[i]));
            }
        }
        shuffle();
        size = cards.size();
    }

    public int size(){
        return size;
    }

    public Card deal(){
        if(isEmpty()){
            return null;
        }
        Card deal = cards.get(size-1);
        size--;
        return deal;
    }

    public void shuffle(){
        Collections.shuffle(cards);
        size = cards.size();
    }

    public boolean isEmpty(){
        if(cards.size() == 0){
            return true;
        }
        return false;
    }

}
