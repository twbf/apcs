
public class Deck{

    private ArrayList<Card> cards;
    private int size;

    public Deck(ArrayList<Sring> ranks, ArrayList<Sring> suits, ArrayList<Integer> points){
        for(int i = 0; i<ranks.size(); i++){
            for(String s: suits){
                cards.add(new Card(ranks.get(i), s, points.get(i)));
            }
        }

        size = cards.size;
    }

    public int size(){
        return size;
    }

    public Card deal(){
        Card deal = cards.get(size);
        size--;
        return deal;
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public boolean isEmpty(){
        if(cards.size == 0){
            return true;
        }
        return false;
    }

}
