class B3 {
    private int i = 2;
    private B3(){
        System.out.println("B()");
    }
    private void m(){
        System.out.println("m()");
    }

    public static void main(String[] args){
        B3 b = new B3();
        System.out.println("b.i: "+b.i);
        b.m();
    }
}

class B3User{
    B3User(){
		//B b = new B(); //불가
		//System.out.println("b.i: " + b.i); //불가
		//b.m(); //불가        
    }
    public static void main(String[] args){
        new B3User();
    }
}
