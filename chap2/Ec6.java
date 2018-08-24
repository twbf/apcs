class Ec6{
    public static final int SIZE = 2;
    public static void main(String args[]){
        spire();
        pyramid();
        trapazoid();
        spire();
        collum();
        pyramid();
    }
    public static void spire(){
        String print = "";
        for (int i = 0; i<SIZE; i++){
            print = addSpace(3*SIZE + 3);
            print += "||";
            System.out.println(print);
            print = "";
        }
    }
    public static void collum(){
        String print = "";
        for (int i = 0; i<4*SIZE; i++){
            print = addSpace(3*SIZE);
            print += "|%%||%%|";
            System.out.println(print);
            print = "";
        }
    }
    public static void pyramid(){
        String print = "";
        for (int i = 0; i<SIZE; i++){
            print = addSpace(3*(SIZE-i));
            print += "__/";
            for (int j = 0; j<i; j++){
                print += ":::";
            }
            print+="||";
            for (int j = 0; j<i; j++){
                print += ":::";
            }
            print += "\\__";
            System.out.println(print);
            print = "";
        }
    }
    public static void trapazoid(){
        String print = "";
        for (int i = SIZE; i>0; i--){
            print = addSpace(2*(SIZE-i)+3);
            print += "\\_";
            for(int j = 0; j < 2*(i)+SIZE-1; j++){
                print += "/\\";
            }
            print += "_/";
            System.out.println(print);
            print = "";
        }
    }
    public static String addSpace(int space){
        String str = "";
        for (int i = 0; i<space; i++){
            str += " ";
        }
        return str;
    }
}
