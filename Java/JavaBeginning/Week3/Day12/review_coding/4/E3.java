class E3 {
    final int i = 1;
    final void m(){
        System.out.println("E3 m()");
    }    
}

class E3Child extends E3{
    E3Child() {
        i = 2;
    }
    void m(){
        System.out.println("E3Child m()");
    }
}
