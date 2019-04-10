
public class Card{
    private String suit;
    private String rank;
    private int point;

    public Card(String s, String r, int p){
        suit = s;
        rank = r;
        point = p;
    }

    public String toString(){
        return this.rank + " of " + this.suit + " (point value = " + this.point + ")";
    }

    public boolean equals(Card other){
        if(other.suit.equals(this.suit)&&other.rank.equals(this.rank)&&other.point==this.point){
            return true;
        }
        return false;
    }

    public String getRank(){
        return rank;
    }

    public String getSuit(){
        return suit;
    }
    
    public int getPoint(){
        return point;
    }
}
