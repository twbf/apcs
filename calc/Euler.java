class Euler{
    public static void main(String args[]){
        double stepSize = 0.2;
        double startx = 0;
        double endx = 1;
        double starty = 3;


        double newx = startx;
        double newy = starty;
        for(double i=startx; i<endx; i+=stepSize){
            newx = i;
            newy = newy + stepSize*dydx(newx,newy);
        }
        System.out.println(newy);
    }

    public static double dydx (double x, double y){

        return 6*x - 3*y;

    }

}
