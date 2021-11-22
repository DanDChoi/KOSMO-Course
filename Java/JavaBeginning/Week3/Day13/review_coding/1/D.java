class D{
    private void m(String name, int age){
        System.out.println("D의 m()");
    }
}

class DChild extends D {
    private void m(String name, int age){
        System.out.println("DChild의 m()");
    }
}

class DUser {
    public static void main(String[] args){
        D d = new DChild();
        //d.m("길동", 22);
    }
}