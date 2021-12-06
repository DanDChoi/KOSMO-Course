abstract class F3 {
    abstract void m1();
    void m2(){
        System.out.println("m2()");
    }
}
class F3User extends F3{
    void m1(){
        System.out.println("aa");
    }
    void m2(){
        System.out.println("cc");
    }
    public static void main(String[] args){
        new F3User().m1();
        new F3User().m2();
    }
}
