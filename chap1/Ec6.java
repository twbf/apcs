/* Same as Ec5*/

class Ec6{
    public static void main(String args[]){
        String[] noun = new String[5];
        noun[0] = "Cat";
        noun[1] = "Hen";
        noun[2] = "Duck";
        noun[3] = "Goose";
        noun[4] = "Sheep";

        String[] verb = new String[5];
        verb[4] = "baa, baa,";
        verb[3] = "hissy, hissy,";
        verb[2] = "quack, quack,";
        verb[1] = "chimmy-chuck, chimmy-chuck,";
        verb[0] = "fiddle-i-fee.";

        for (int i = 0; i<5; i++){
            System.out.println("Bought me a sheep " + noun[i] + " and under the " + noun[i] + " pleased me, ");
            System.out.println("I fed my  " + noun[i] + " under younder tree.");
            for (int j = i; j>-1; j--){
                System.out.println(noun[j] + " goes " + verb[j]);
            }
            System.out.println(" ");
        }

    }
}
