Class D1{
    void m1() throws MyException {
        boolean flag = flase;
        if(flag){
            throw new MyException();
        }
    }
    void m2() throws YourException {
        boolean flag = flase;
        if(flag){
            throw new YourException();
        }
    }
    void m3() throws Exception {
        boolean flag = true;
        if(flag){
            throw new Exception();
        }
    }

    class D1User{
        DUser() throws YourException, Exception{
            D1 d = new D1();
            try{
                d.m1();
                d.m2();
                d.m3();
            }catch(MyException me){
                me.use()
            }
        }
    }
    public static void main(String[] args){
        try{
            new D1User();
        }catch(YourException ye){
            ye.apply();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}