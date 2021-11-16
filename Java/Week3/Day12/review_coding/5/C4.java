class C4 {
    static int i = 1;
    int j = 2;
    C4(){
        System.out.println("C4()");
    }    
    static void m(){
        System.out.println("m() i:" +i);
        System.out.println("m() j:"+ new C4().j);
    }

    public static void main(String[] args){
        System.out.println("i:"+i);
        m();
    }
}

class C4User{
    public static void main(String[] args){
        System.out.println("C4.i: "+C4.i);
        C4.m();
    }
}
