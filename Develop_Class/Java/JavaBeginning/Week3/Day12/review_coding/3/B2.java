class B2{
    private int i = 1;
    private B2(){
        System.out.println("B2()");
    }
    private void m(){
        System.out.println("m()");
    }
    public static void main(String[] args){
        B2 b = new B2();
        System.out.println("b.i: "+b.i);
        b.m();
    }
}

class B2User{
    B2User(){
        /*B2 b = new B2();
        System.out.println("b.i: "+b.i);
        b.m();*/
    }
    public static void main(String[] args){
        new B2User();
    }
}