import java.util.Scanner;
import java.util.*;

class Pp4{
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        String todayMonth = sc.nextLine();
        int todayDay = sc.nextInt();
        Scanner s = new Scanner(System.in);
        String firstMonth = s.nextLine();
        int firstDay = s.nextInt();
        Scanner c = new Scanner(System.in);
        String secMonth = c.nextLine();
        int secDay = c.nextInt();

        int today = findAbsolute(todayMonth,todayDay);
        int first = findAbsolute(firstMonth,firstDay);
        int sec = findAbsolute(secMonth,secDay);

        int disFirst = distance(today,first);
        int disSec = distance(today,sec);

        if (disFirst < disSec){
            System.out.println("First birthday is closer");
        } else{
            System.out.println("Secoundbirthday is closer");
        }

    }
    public static int distance(int today, int birthday){
        int dis = birthday-today;
        if (dis<0){
            dis += 365;
        }
        System.out.println(dis);
        return dis;
    }

    public static int findAbsolute(String month, int day){
        Map<String, String> monthOrder = new HashMap<String, String>();
        monthOrder.put("january", "1");
        monthOrder.put("febuary", "2");
        monthOrder.put("march", "3");
        monthOrder.put("april", "4");
        monthOrder.put("may", "5");
        monthOrder.put("june", "6");
        monthOrder.put("july", "7");
        monthOrder.put("august", "8");
        monthOrder.put("september", "9");
        monthOrder.put("october", "10");
        monthOrder.put("november", "11");
        monthOrder.put("december", "12");

        int[] dayOrder = {31,28,31,30,31,30,31,31,30,31,30,31};

        month = month.toLowerCase();
        int numMonth = Integer.parseInt(monthOrder.get(month));
        int sum = 0;
        for(int i = 0; i < numMonth - 1; i++){
            sum += dayOrder[i];
        }
        return sum + day;
    }
}
