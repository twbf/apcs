import java.util.*;

public class Ex18 {
    public static void main(String args[]){
        Map<String,String> m1 = new HashMap<String,String>(){{ //true
            put("me", "a");
            put("ve", "r");
            put("je", "d");
            put("ke", "c");
        }};
        Map<String,String> m2 = new HashMap<String,String>(){{ //false
            put("me", "a");
            put("ve", "b");
            put("te", "a");
            put("ke", "c");
        }};
        Map<String,String> out = reverse(m2);
        System.out.println(out);
    }
    public static Map<String,String> reverse(Map<String,String> map){
        Map<String,String> out = new HashMap<String,String>();
        Set<String> set = map.keySet();
        for(String word:set){
            if(out.containsKey(map.get(word))){
                out.put(map.get(word), out.get(word) + word);
            } else {
                out.put(map.get(word),word);
            }
        }
        return out;
    }
}
