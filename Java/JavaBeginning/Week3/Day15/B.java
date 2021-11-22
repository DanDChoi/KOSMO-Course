interface BI {

}

class BOut {
    int i = 1;
    class BIn{
        int j = 2;
        void use(){
            BI bi = () -> {
                //System.out.println("i: "+ BOut.this.i); //생략가능
                System.out.println("i: "+ i);

                //System.out.println("j: "+ this.j); //생략가능
                System.out.println("j: "+ j);
            };
            bi.m();
        }
    }
}

class B {
    public static void main(String[] args){
        BOut.BIn in = new BOut().new BIn();
        bin.use();
        //BI bi = () -> System.out.println("홍길동");
        //bi.m();
    }
}