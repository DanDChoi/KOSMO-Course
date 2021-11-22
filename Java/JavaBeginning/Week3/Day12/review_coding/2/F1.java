abstract class F1 {
    abstract void m1();
    void m2(){
        System.out.println("m2()");
    }
}

class F1User extends F1{
    void m1(){
        System.out.println("aa");
    }
    void m2(){
        System.out.println("bb");
    }
    public static void main(String[] args){
        new F1User.m1();
        new F1User.m2();
    }
}
