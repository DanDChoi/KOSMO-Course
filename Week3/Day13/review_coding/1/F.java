interface F{
    int i = 1;
    void m1();

    static void m2(){}
    default void m3(){}
}

class FChild implements F{
    public void m1(){
        System.out.println("m1()");
    }
}

class FUser{
    public static void main(String args){
        F f = ??
        System.out.println("f.i:"+ f.i);
        f.m1();
        f.m2();
        f.m3();
    }
}