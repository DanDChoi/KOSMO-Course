abstract class F {
    abstract void m1();
    void m2(){
        System.out.println("m2()");
    }
    
}

class FUser extends F{
    void m1(){
        System.out.println("abc");
    }
    void m2(){
        System.out.println("this");
    }

    public static void main(String[] args){
        new FUser().m1();
        new FUser().m2();
    }
}
