public class Card{

    private String question;
    private String awnswer;

    public Card(String q, String a){
        question = q;
        awnswer = a;
    }

    public String getQuestion(){
        return question;
    }

    public String getAwnswer(){
        return awnswer;
    }

    public String toString(){
        return question + awnswer;
    }
}
