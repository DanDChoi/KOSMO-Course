class AOut{
    int i = 10;
    void m(){
        System.out.println("m()");
    }

    class AIn1{
        int j = 20;
        void m1(){
            System.out.println("m1()");
        }
    }
    static class AIn2{
        static int k = 30;
        static void m2(){
            System.out.println("m2()");
        }
    }
}

class A{
    public static void main(String[] args){
        AOut ao = new AOut();
        
        AOut.AIn1 ai1 = ao.new AIn1();
        System.out.println("ai1.j: "ai1.j);
        ai1.m1();

        AOut.AIn2 ai2 = new AOut.AIn2();
        System.out.println("ai2.k: "+ai2.k);
        ai2.m2();
        System.out.println("AOut.AIn2.k: "+AOut.AIn2.k);
        AOut.AIn2.m2();
    }
}