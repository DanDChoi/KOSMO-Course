class E1 {
    final int = 1;
    final void m(){
        System.out.println("E1 m()");
    }    
}
class E1Child extends E1{
    E1Child(){
        i = 2;
    }
    void m(){
        System.out.println("E1Child m()");
    }
}