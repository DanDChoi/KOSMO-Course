class C2{
    C2() throws MyException{
        boolean flag =false;
        if(flag){
            throw new MyException();
        }
    }
    void m1() throws MyException {
        boolean flag = true;
        if(flag){
            throw new MyException();
        }
    }
}

class C2User{
    public static void main(String[] args){
        try{
            C2 c = new C2();
            System.out.println("���ܾ���atC");
            c.m1();
            System.out.println("���ܾ���atm1");

        }catch(MyException me){
            Systme.out.println("���ܹ߻�");
            me.use();
        }
    }
}