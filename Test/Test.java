public class Test {
    public static void main(String[] args) {
        Obj v = new Obj();
        System.out.println(v.x);
        add(v);
        System.out.println(v.x);
    }
    public static void add(Obj c){
        c.x = 1;
    }
}
