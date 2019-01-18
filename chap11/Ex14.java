import java.util.*;

public class Ex14 {
    public static void main(String args[]){
        Map<String,String> m1 = new HashMap<String,String>(){{
            put("me", "a");
            put("ve", "r");
            put("je", "d");
            put("ke", "c");
        }};
        Map<String,String> m2 = new HashMap<String,String>(){{
            put("me", "a");
            put("ve", "b");
            put("te", "d");
            put("ke", "c");
        }};
        Map<String,String> out = intersect(m1,m2);
        System.out.println(out);
    }
    public static Map<String,String> intersect(Map<String,String> m1,Map<String,String> m2){
        Map<String,String> out = new HashMap<String,String>();
        Set<String> s1 = m1.keySet();
        Set<String> s2 = m2.keySet();
        s1.retainAll(s2);
        for(String word:s1){
            if(m1.get(word).equals(m2.get(word))){
                out.put(word,m1.get(word));
            }
        }
        return out;
    }
}
