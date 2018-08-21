class Ec5{
    public static void main(String args[]){
        String[] verbs= new String[6];
        verbs[5] = "milked";
        verbs[4] = "tossed";
        verbs[3] = "worried";
        verbs[2] = "killed";
        verbs[1] = "ate";
        verbs[0] = "lay in";

        String[] noun = new String[7];
        noun[0] = "house that Jack built";
        noun[1] = "malt";
        noun[2] = "rat";
        noun[3] = "cat";
        noun[4] = "dog";
        noun[5] = "cow with the crumpled horn";
        noun[6] = "maiden all forlorn";


        for(int i = 0; i < 7; i++){
            System.out.println("This is the " + noun[i]);
            for (int j = i-1; j>-1; j--){
                System.out.println("That " + verbs[j]+ " the " + noun[j] + ",");
            }
            System.out.println(" ");
        }
    }
}
