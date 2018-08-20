
class Lady
{
    public static void main(String args[])
    {
        String[] x  = new String[5];
        x[0] = "fly";
        x[1] = "spider";
        x[2] = "bird";
        x[3] = "cat";
        x[4] = "dog";

        String[] spe = new String[4];
        spe[0] = "That wriggled and iggled and jiggled inside her.";
        spe[1] = "How absurd to swallow a bird.";
        spe[2] = "Imagine that to swallow a cat.";
        spe[3] = "What a hog to swallow a dog.";


        String l1 = "There was an old lady who swallowed a ";

        String x1 = "I don't know why she swallowed that fly,";
        String x2 = "Perhaps she’ll die.";


        for (int i = 0; i<5; i++){
            System.out.println(l1 + x[i]);
            if (i>0){
                System.out.println(spe[i-1]);
            }
            for(int j = 1; j<(i+1); j++){
                System.out.println("she swallowed the " + x[j] + " to catch the " + x[j-1]);
            }
            System.out.println(x1);
            System.out.println(x2);
            System.out.println(" ");
        }
    }
}
