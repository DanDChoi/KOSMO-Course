package aa.cc;

import aa.bb.A4; 

class A4User extends A4 {
    A4User(){
        super();
    }
    void use(){
        System.out.println("i: "+i);
        m();
    }

    public static void main(String[] args){
        A4User u = new A4User();
        u.use();
    }
}
