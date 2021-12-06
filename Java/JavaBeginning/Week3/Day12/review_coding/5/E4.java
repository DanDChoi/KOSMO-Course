class E4 {
    final int i = 1;
    final void m(){
        System.out.println("E4 m()");
    }    
}

class E4Child extends E4 {
    E4Child(){
        i = 2;
    }
    void m(){
        System.out.println("E4Child m()");
    }
}
