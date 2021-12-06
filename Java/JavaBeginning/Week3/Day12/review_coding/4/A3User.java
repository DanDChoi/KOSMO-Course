package aa.cc;

import aa.bb.A;

class A3User extends A3 {
    A3User(){
        super();
    }
    void use(){
        System.out.println("i: "+i);
        m();
    }
    public static void main(String[] args){
        A3User u = new A3User();
        u.use();
    }
    
}
