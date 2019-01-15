import java.util.*;

public class Ex4 {
    public static void main(String args[]){
        List<Integer> list = new LinkedList<Integer>(Arrays.asList(15, 1, 6, 12, 3, 4, 8, 21, 2, 30, 1, 9));
        List<Integer> out = partition(list,5);
        System.out.println(out);
    }
    public static List<Integer> partition(List<Integer> list, int element){
        List<Integer> out = new LinkedList<Integer>();

        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext()){
            int next = itr.next();
            if (next>element){
                out.add(next);
            } else {
                out.add(0, next);
            }
        }
        return out;
    }
}
