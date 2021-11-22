package aa.cc;

import aa.bb.A2;

class A2User extends A2 {
    A2User(){
        super();
    }
    void use(){
        System.out.println("i: "+i);
        m();
    }
    public static void main(String[]args){
        A2User u = new A2User();
        u.use();
    }
}
