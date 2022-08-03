abstract class F4 {
    abstract void m1();
    void m2(){
        System.out.println("m2()");
    }
}

class F4User extends F4{
    void m1(){
        System.out.println("aaa");
    }
    void m2(){
        System.out.println("bbb");
    }
    public static void main(String[] args){
        new F4User().m1();
        new F4User().m2();
    }
}
