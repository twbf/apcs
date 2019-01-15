import java.util.*;

public class Ex9 {
    public static void main(String args[]){
        Set<Integer> list = new HashSet<Integer>(Arrays.asList(2,6,8,10));
        boolean out = hasOdd(list);
        System.out.println(out);
    }
    public static boolean hasOdd(Set<Integer> set){
        Iterator<Integer> itr = set.iterator();
        while (itr.hasNext()){
            if(itr.next()%2 == 1){
                return true;
            }
        }
        return false;
    }
}
