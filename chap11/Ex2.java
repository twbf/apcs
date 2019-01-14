import java.util.*;

public class Ex2 {
    public static void main(String args[]){
        List<Integer> l1 = new LinkedList<Integer>(Arrays.asList(1,3,4,5));
        List<Integer> l2 = new LinkedList<Integer>(Arrays.asList(2,4,6,8,9,70));
        List<Integer> out = alternate(l1,l2);
        System.out.println(out);
    }

    public static List<Integer> alternate(List<Integer> l1, List<Integer> l2){
        List<Integer> out = new LinkedList<Integer>();

        Iterator<Integer> i1 = l1.iterator();
        Iterator<Integer> i2 = l2.iterator();

        while(i1.hasNext()||i2.hasNext()){
            if(i1.hasNext()){
                out.add(i1.next());
            }
            if(i2.hasNext()){
                out.add(i2.next());
            }
        }
        return out;
    }
}
