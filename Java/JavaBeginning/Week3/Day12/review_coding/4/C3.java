class C3 {
   static int i = 1;
   int i = 2;
   C3(){
    System.out.println("C()");
   } 
   static void m(){
    System.out.println("m() i:"+i);
    System.out.println("m() j:"+ new C3().j);
   }
   public static void main(String[] args){
    System.out.println("i: "+i);
    m();
   }
}

class C3User{
    public static void main(String[] args){
        System.out.println("C3.i: "C3.i);
        C3.m();
    }
}
