import java.util.*;

public class Ex19 {
    public static void main(String args[]){
        Map<String,Integer> m1 = new HashMap<String,Integer>(){{
            put("me", 1);
            put("ve", 1);
            put("je", 2);
            put("ke", 3);
        }};
        int out = reverse(m1);
        System.out.println(out);
    }
    public static int reverse(Map<String,Integer> map){
        Map<Integer,Integer> test = new HashMap<Integer,Integer>();
        Set<String> set = map.keySet();
        for(String word:set){
            if(test.containsKey(map.get(word))){
                test.put(map.get(word), test.get(map.get(word)) + 1);
            } else {
                test.put(map.get(word),1);
            }
        }

        Set<Integer> intSet = test.keySet();
        int min = 100;
        int index = 0;
        for(int x:intSet){
            if(test.get(x)< min){
                min = test.get(x);
                index = x;
            }
        }
        return index;
        
    }
}
