import java.util.*;

public class Ex16 {
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
        boolean out = is1to1(m2);
        System.out.println(out);
    }
    public static boolean is1to1(Map<String,String> map){
        Set<String> keys = map.keySet();
        Set<String> values = new HashSet<String>(map.values());
        return keys.size() == values.size();
    }
}
