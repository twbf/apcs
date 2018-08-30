class Pp1{
    public static void main(String args[]){
        tree(3,4);
    }
    public static void tree(int seg, int h){
        String out = "";
        for (int i = 0; i<seg; i++){
            for(int j = i; j<(h+i); j++){
                for(int k = j; k<(h+seg); k++){
                    out+=" ";
                }
                if(j == 0){
                    out+=" ";
                }
                out+="*";
                for(int k = 0; k<j; k++){
                    out+="*";
                    out+="*";
                }
                System.out.println(out);
                out = " ";
            }
        }
        String space = "";
        for(int i = 0; i<(seg+h)-2; i++){
            space += " ";
        }
        System.out.println(space + "   *      ");
        System.out.println( space + "   *      ");
        System.out.println(space + "*******   ");
    }
}
