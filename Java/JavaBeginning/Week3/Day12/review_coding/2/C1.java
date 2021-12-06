class C1 {
    static int = 1;
    int j = 2;
    C1(){
        System.out.println("C()");
    }   
    static void m(){
        System.out.println("m() i: "+ i);
        System.out.println("m() j: "+ j);
    }
    public stativ void main(String[] args){
        System.out.println("i: "+i);
        m();
    }
}
class C1User{
    public static void main(String[] args){
        System.out.println("C1.i: "+C1.i);
        C1.m();
    }
}
