class E1{
    E1(){
        try{
            System.out.println("1");
            new D1().m1();
            System.out.println("2");
        }catch(Exception e){
            System.out.println("3");
        }finally{
            System.out.println("4");
        }
        System.out.println("5");
    }
    public static void main(String[] args){
        E1 e = new E1();
    }
}