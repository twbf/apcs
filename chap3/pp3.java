

class Pp3{
    public static void main(String args[]){
        int counter = 0;
        System.out.println("Day   Presents Recived    Total Presents");
        for(int i = 1; i<13; i++){
            counter += i;
            System.out.println( i + "     "+ i + "                    " + counter);
        }
    }
}
