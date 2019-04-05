public class Card {
    private int val;
    private int suit;//1=Diamonds, 2=Spades, 3=Clubs, 4=Hearts
    
    public Card(int v, int s) {
        val=v;
        suit=s;
    }
    public int getVal(){
        return val;
    }
    public int getSuit() {
        return suit;
    }
}
