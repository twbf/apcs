import java.util.*;

public class Ex6 {
    public static void main(String args[]){
        List<Integer> list = new LinkedList<Integer>(Arrays.asList(3, 7, 3, -1, 2, 3, 7, 2, 15, 15));
        int out = sortAndRemoveDuplicates(list);
        System.out.println(out);
    }
    public static int sortAndRemoveDuplicates(List<Integer> list){
        Set<Integer> out = new TreeSet<Integer>(list);
        return out.size();
    }
}
