import java.util.*;
import java.io.*;

public class Stack extends ArrayList<Card>{
    private List<Card> cards;
    private int index = 0;

    public Stack(String file){
        cards = new ArrayList<Card>();
        try{
            File f = new File(file);
            Scanner sc = new Scanner(f);

            String tmp = " ";
            int index = 0;
            while (sc.hasNextLine()){
                tmp = sc.nextLine();
                index = tmp.indexOf(":");
                cards.add(new Card(tmp.substring(0,index), tmp.substring(index+1)));
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Card nextCard(){
        if (index == cards.size()){
            Collections.shuffle(cards);
            index = 0;
        }

        Card a = cards.get(index);
        index++;
        return a;
    }
}
