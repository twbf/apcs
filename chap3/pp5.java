import java.util.Scanner;

class Pp5{
    public static final  double EARTH = 6372.795;

    public static void main(String args[]){
        System.out.println("Computes the longitudal distance between two different points on the surface of the Earth");
        System.out.println(" ");
        Scanner sc = new Scanner(System.in);
        System.out.println("lat1: ");
        double lat1 = Math.toRadians(sc.nextDouble());
        System.out.println("long1: ");
        double long1 = Math.toRadians(sc.nextDouble());
        System.out.println("lat2: ");
        double lat2 = Math.toRadians(sc.nextDouble());
        System.out.println("long2: ");
        double long2 = Math.toRadians(sc.nextDouble());

        double angDistance = sphericalCos(lat1, lat2, Math.abs(long2-long1));

        System.out.println("Distance: " + angDistance * EARTH + "km");

    }

    public static double sphericalCos(double x1, double x2, double y){
        // Spherical Law of cosines formula
        // Y is delta y
        return Math.acos(Math.sin(x1)*Math.sin(x2) + Math.cos(x1)*Math.cos(x2)*Math.cos(y));
    }
}
