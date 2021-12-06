class B1 {
    private int i = 2;
    private B1(){
        System.out.println("B()");
    }    
    private void m(){
        System.out.println("m()");
    }
    public static void main(String[] args){
        B1 b = new B1();
        System.out.println("b.i: "+b.i);
    }
}

class B1User {
    B1User(){
        /*B b= new B();  //불가
        System.out.println("b.i: "+b.i);
        b.m();*/ 
    }
    public static void main(String[] args){
        new B1User();
    }
}
