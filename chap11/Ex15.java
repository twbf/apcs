import java.util.*;

public class Ex15 {
    public static void main(String args[]){
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(3, 7, 3, -1, 2, 3, 7, 7, 15, 15,7));
        int out = maxOccurrance(list);
        System.out.println(out);
    }
    public static int maxOccurrance(List<Integer> list){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int x:list){
            if(map.containsKey(x)){
                map.put(x,map.get(x)+1);
            } else {
                map.put(x,1);
            }
        }
        Collection<Integer> values = map.values();
        int max = 0;
        for(int x:values){
            if(x>max){
                max = x;
            }
        }
        return max;
    }
}
