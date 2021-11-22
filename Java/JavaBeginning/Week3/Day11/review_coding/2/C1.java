class C1{
    C() throws MyException {
        boolean flag = false;
        if(flag){
            throw new MyException();
        }
    }
    void m1() throws MyException{
        boolean flag = true;
        if(flag){
            throw new MyException();
        }
    }
}

class C1User{

    public static void main(String[] args){
        try{
            C1 c = new C1();
            System.out.println("예외 발생X at C");
            c.m1();
            System.out.println("예외 발생x at m1");
        }catch(MyException me){
            System.out.println("예외발생");
            me.use();
        }
    }
}