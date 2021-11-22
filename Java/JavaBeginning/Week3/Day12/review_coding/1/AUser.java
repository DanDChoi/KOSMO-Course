package aa.cc;

import aa.bb.A;

class AUser extends A {
    
    AUser(){
        super();
    }
    void use(){
        System.out.println("i: "+i);
        m();
    }

    public static void main(String[] args){
        AUser u = new AUser();
        u.use();
    }
}
