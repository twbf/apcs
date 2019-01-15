import java.util.*;

public class Ex10 {
    public static void main(String args[]){
        Set<String> set = new HashSet<String>(Arrays.asList("frog", "dog", "cow", "animal", "me"));
        Set<String> out = removeEvenLength(set);
        System.out.println(out);
    }
    public static Set<String> removeEvenLength(Set<String> set){
        Iterator<String> itr = set.iterator();
        while (itr.hasNext()){
            String next = itr.next();
            if(next.length()%2 == 0){
                itr.remove();
            }
        }
        return set;
    }
}
