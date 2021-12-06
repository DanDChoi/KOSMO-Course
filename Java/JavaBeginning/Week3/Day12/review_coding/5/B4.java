class B4 {
    private int i = 2;
    private B4(){
        System.out.println("B4()");
    }    
    private void m(){
        System.out.println("m()");
    }

    public static void main(String[] args){
        B4 b = new B4();
        System.out.println("b.i: "+b.i);
        b.m();
    }
}

class B4User{
    B4User(){
		//B b = new B(); //불가
		//System.out.println("b.i: " + b.i); //불가
		//b.m(); //불가        
    }
    public static void main(String[] args){
        new B4User();
    }
}