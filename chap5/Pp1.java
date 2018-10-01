import java.util.Scanner;

class Pp1{
    public static void main(String args[]){
        Scanner console = new Scanner(System.in);
        String out = "";
        System.out.println("Word?");
        console.next();
        while(!console.hasNext()){
            System.out.println("Word?");
            out += toPig(console.next()) + " ";
        }
        System.out.println(out);
    }

    public static String toPig(String word){
        int count = 0;
        while(checkVowels(word.charAt(count))){
            count++;
        }
        return word.substring(count) + word.substring(0, count) + "-ay";
    }

    public static boolean checkVowels(char letter){
        return letter!='a'&&letter!='e'&&letter!='i'&&letter!='o'&&letter!='u';
    }

}
