import java.util.Scanner;
import java.io.*;
import java.util.*;

class MadLibs{
    public static void main(String args[]) throws FileNotFoundException{
        File file = new File("libs.txt");
        Scanner input = new Scanner(file);
        List<String> list = new ArrayList<String>();

        while (input.hasNextLine()) {
            String line = input.nextLine();

            if(StringUtils.isAllUpperCase(line)){
                System.out.println("What is a " + line + "?");
                Scanner sc = new Scanner(System.in);
                list.add(sc.next());
            } else {
                list.add(line)
            }
        }
        for (int i = 0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
