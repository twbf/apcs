class Pp2{
    public static void main(String args[]){
        double money = 1000;
        double deposit = 0;
        System.out.println("Year  Current Balence   Interest   Deposit   New Balence");

        for(int i=0; i<25; i++){
            String a = String.format("%.2f", money);
            String b = String.format("%.2f", money*0.065);
            String c = String.format("%.2f", deposit);
            String d = String.format("%.2f", money*1.065+deposit);

            System.out.println(i+1 + "      " + a + "            " + b + "      " + c + "      " + d);
            money = money*1.065 + deposit;
            deposit = 100;
        }
    }
}
