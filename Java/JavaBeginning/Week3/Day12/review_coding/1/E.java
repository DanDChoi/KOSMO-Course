class E {
    final int i = 10;
    final void m(){
        System.out.println("E m()");
    }
}

class EChild extends E{
    EChild(){
        i = 20;
    }
    void m(){
        System.out.println("Echild m()");
    }
}
