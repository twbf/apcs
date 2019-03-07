import java.util.ArrayList;
import java.util.*;

public class Hand {
    private ArrayList<Card> hand;
    private ArrayList<Card> accumulated;
    private int side;

    public Hand(Deck d, int side){
        this.hand = new ArrayList<Card>();
        this.accumulated = new ArrayList<Card>();
        this.side = side;
        for(int i = side*26; i<26+side*26; i++){
            hand.add(d.getCard(i));
        }
    }

    public void shuffle (){
        Collections.shuffle(hand);
    }

    public Card flip(){
        if (hand.size() == 0){
            hand = accumulated;
            accumulated = null;
            shuffle();
        }
        return hand.get(0);
    }

    public void won(Card other){
        accumulated.add(hand.get(0));
        accumulated.add(other);
        hand.remove(0);
    }

    public void lost(){
        hand.remove(0);
    }

}
