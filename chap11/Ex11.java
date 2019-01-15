import java.util.*;

public class Ex11 {
    public static void main(String args[]){
        Set<Integer> s1 = new HashSet<Integer>(Arrays.asList(1, 4, 7, 9));
        Set<Integer> s2 = new HashSet<Integer>(Arrays.asList(2, 4, 5, 6, 7));
        Set<Integer> out = symmetricSetDifference(s1,s2);
        System.out.println(out);
    }
    public static Set<Integer> symmetricSetDifference(Set<Integer> s1, Set<Integer> s2){
        Set<Integer> t1 = new HashSet<Integer>(s1);
        Set<Integer> t2 = new HashSet<Integer>(s2);
        t2.removeAll(s1);
        t1.removeAll(s2);
        t2.addAll(t1);
        return t2;
    }
}
