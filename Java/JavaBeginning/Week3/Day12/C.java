class C{
    static int i = 10;
    int j = 20;
    C(){
        System.out.println("C()");
    }
    static void m(){
        System.out.println("m() i: "+ i);
        System.out.println("m() j: "+ new C().j);
    }
    public static void main(String[] args){
        System.out.println("i: "+ i );
        m();
}
}
class CUser{
    public static void main(String[] args){
        System.out.println("C.i: "+ C.i );
        C.m();
    }
}