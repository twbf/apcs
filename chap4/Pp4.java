class Pp4{
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        String todayMonth = sc.nextLine();
        int todayDay = sc.nextInt();
        String firstMonth = sc.nextLine();
        int firstDay = sc.nextInt();
        String secMonth = sc.nextLine();
        int secDay = sc.nextInt();

        int today = findAbsolute(todayMonth,todayDay);
        int first = findAbsolute(firstMonth,firstDay);
        int sec = findAbsolute(secMonth,secDay);

        int disFirst = distance(today,first);
        int disSec = distance(today,sec);

        if (disFirst < disSec){
            System.out.println("First");
        } else{
            System.out.println("Secound");
        }

    }
    public static void distance(int today, int birthday){
        int dis = today - birthday;
        if (dis<0){
            dis += 365;
        }
        System.out.println(dis);
        return dis
    }

    public static int findAbsolute(String month, int day){
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

        int dayOrder[12] = {31,28,31,30,31,30,31,31,30,31,30,31};

        month = month.toLowerCase();
        int numMonth = Integer.parseInt(map.get(month));
        int sum = 0;
        for(int i = 1; i < numMonth - 1; i++){
            sum += dayOrder[i-1];
        }
        return sum + day;
    }
}
