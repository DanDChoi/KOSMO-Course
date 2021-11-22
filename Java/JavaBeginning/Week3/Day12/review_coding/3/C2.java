class C2{
    static int i = 1;
    int j = 2;
    C2(){
        System.out.println("C()");
    }
    static void m(){
        System.out.println("m() i:"+ i);
        System.out.println("m() j:" + new C2().j);
    }
    public static void main(String[] args){
        System.out.println("i: "+i);
        m();
    }
}

class C2User{
    public static void main(String[] args){
        System.out.println("C2.i: "+C2.i);
        C2.m();
    }
}