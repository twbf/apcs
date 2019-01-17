import java.util.*;

public class Ex12 {
    public static void main(String args[]){
        List<String> list = new ArrayList<String>(Arrays.asList("frog", "me", "me", "animal", "me"));
        boolean out = contains3(list);
        System.out.println(out);
    }
    public static boolean contains3(List<String> list){
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(String word:list){
            if(map.containsKey(word)){
                map.put(word, map.get(word) + 1);
                if(map.get(word) >= 3){
                    return true;
                }
            } else {
                map.put(word,1);
            }
        }
        return false;
    }
}
