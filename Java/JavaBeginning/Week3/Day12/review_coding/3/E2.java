class E2 {
    final int i = 1;
    final void m(){
        System.out.println("E m()");
    }    
}
class E2Child extends E2{
    E2Child(){
        i = 1;
    }
    void m(){
        System.out.println("E2Child m()");
    }
}
