class B1{
    int i;
    B() throws Exception {
        throw new Exception();
    }
    void m() throws Exception{
        throw new Exception();
    }

    public static void main(String[] args){
        try{
            B1 b = new B1();
            b.m();
        }catch(Exception e){}
    }
}