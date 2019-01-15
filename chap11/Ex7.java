import java.util.*;

public class Ex7 {
    public static void main(String args[]){
        List<Integer> l1 = new LinkedList<Integer>(Arrays.asList(3, 7, 3, -1, 2, 3, 7, 2, 15, 15));
        List<Integer> l2 = new LinkedList<Integer>(Arrays.asList(-5, 15, 2, -1, 7, 15, 36));
        int out = sortAndRemoveDuplicates(l1,l2);
        System.out.println(out);
    }
    public static int sortAndRemoveDuplicates(List<Integer> l1, List<Integer> l2){
        Set<Integer> s1 = new TreeSet<Integer>(l1);
        Set<Integer> s2 = new TreeSet<Integer>(l2);
        s1.retainAll(s2);
        return s1.size();
    }
}
