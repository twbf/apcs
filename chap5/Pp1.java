import java.util.Scanner;

class Pp1{
    public static void main(String args[]){
        System.out.println("String?");

        // get the line in a scanner so splicing by spaces is easy
        Scanner console = new Scanner(System.in);
        Scanner scanner = new Scanner(console.nextLine());

        String out = "";
        while(scanner.hasNext()){
            out += toPig(scanner.next()) + " ";
        }
        System.out.println(out);
    }

    public static String toPig(String word){
        int count = 0;
        while(checkVowels(word.charAt(count))){  // if a chacter is a vowel then add one to count
            count++;
        }

        // returns the word in pig latin
        return word.substring(count) + "-" + word.substring(0, count) + "ay";
    }

    public static boolean checkVowels(char letter){
        return letter!='a'&&letter!='e'&&letter!='i'&&letter!='o'&&letter!='u'; //checks if a charcter is a vowel
    }

}
