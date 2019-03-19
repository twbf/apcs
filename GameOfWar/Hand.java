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
            if (accumulated.size() == 0){
                return null; // you won
            }
            hand = new ArrayList<Card>(accumulated);
            accumulated = new ArrayList<Card>();
            shuffle();
        }
        Card c = hand.get(0);
        hand.remove(0);
        return c;
    }
    public int getScore(){
        return accumulated.size()+ hand.size();
    }
    public void won(ArrayList<Card> cards){
        for (Card card: cards){
            accumulated.add(card);
        }
        System.out.println("Side: " + side + "   Cards: " + (hand.size() + accumulated.size()));
    }
}
