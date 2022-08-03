abstract class F2 {
    abstract void m1();
    void m2(){
        System.out.println("m2()");
    }
}

class F2User extends F{
    void m1(){
        System.out.println("aa");
    }
    void m2(){
        System.out.println("bb");
    }
    public static void main(String[] args){
        new F2User().m1();
        new F2User().m2();
    }
}
