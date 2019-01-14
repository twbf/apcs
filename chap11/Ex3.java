import java.util.*;

public class Ex3 {
    public static void main(String args[]){
        List<Integer> list = new LinkedList<Integer>(Arrays.asList(0, 0, 2, 0, 4, 0, 6, 0, 8, 0, 10, 0, 12, 0, 14, 0, 16));
        List<Integer> out = removeInRange(list,0,5,13);
        System.out.println(out);
    }

    public static List<Integer> removeInRange(List<Integer> list, int element, int start, int end){
        Iterator<Integer> itr = list.iterator();
        int count = 1;
        while(itr.hasNext()){
            int next = itr.next();
            if(count<end && count>=start && next == element){
                itr.remove();
            }
            count++;
        }
        return list;
    }
}
