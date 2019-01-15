import java.util.*;

public class Ex8 {
    public static void main(String args[]){
        List<String> list = new LinkedList<String>(Arrays.asList("frog", "dog", "cow", "animal", "me"));
        int out = maxLength(list);
        System.out.println(out);
    }
    public static int maxLength(List<String> list){
        Iterator<String> itr = list.iterator();
        int max = 0;
        while (itr.hasNext()){
            String next = itr.next();
            if(next.length()>max){
                max = next.length();
            }
        }
        return max;
    }
}
