class Pp2{
    public static void main(String args[]){
        double money = 1000;
        double deposit = 0;
        for(int i=0; i<25; i++){
            System.out.println(i + " ," + money + " ," + money*0.065 + " " + deposit + " " + money*1.065+deposit);
            money = money*1.065 + deposit;
            deposit = 100;
        }
    }
}
