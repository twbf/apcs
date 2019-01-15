import java.util.*;

public class Ex5 {
    public static void main(String args[]){
        List<Integer> list = new LinkedList<Integer>(Arrays.asList(7, 4, -9, 4, 15, 8, 27, 7, 11, -5, 32, -9, -9));
        Set<Integer> out = sortAndRemoveDuplicates(list);
        System.out.println(out);
    }
    public static Set<Integer> sortAndRemoveDuplicates(List<Integer> list){
        Set<Integer> out = new TreeSet<Integer>(list);
        return out;
    }
}
