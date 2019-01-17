import java.util.*;

public class Ex13 {
    public static void main(String args[]){
        Map<String,String> map = new HashMap<String,String>(){{
            put("me", "a");
            put("ve", "b");
            put("te", "d");
            put("ke", "c");
        }};
        boolean out = contains3(map);
        System.out.println(out);
    }
    public static boolean contains3(Map<String,String> map){
        Collection<String> listValues = map.values();
        Set<String> setValues = new HashSet<String>(listValues);
        if(listValues.size() == setValues.size()){
            return true;
        }
        return false;
    }
}
