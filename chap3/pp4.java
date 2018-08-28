import java.util.Scanner;

class Pp4{
    public static void main(String args[]){
        System.out.println("Given three sides of a triangle this program outputs the angles");
        System.out.println("It is a triangle solver.");
        System.out.println(" ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Side 1:");
        double A = sc.nextInt();
        System.out.println("Side 2:");
        double B = sc.nextInt();
        System.out.println("Side 3:");
        double C = sc.nextInt();

        double a = Math.acos((A*A-B*B-C*C)/(-2*B*C));
        double b = Math.asin(B*Math.sin(a)/A);
        double c = Math.PI -b-a;

        System.out.println(" ");
        System.out.println("Angle 1: " + Math.toDegrees(a));
        System.out.println("Angle 2: " + Math.toDegrees(b));
        System.out.println("Angle 3: " + Math.toDegrees(c));
    }
}
