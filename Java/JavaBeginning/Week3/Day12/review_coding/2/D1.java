class D1 {
    int i;
    static int j;

    D1(){
        i++;
        j++;
    }

    public static void main(String[] args){
        D1 d1 = new D();
        D1 d2 = new D();
        System.out.println("d1.i:"+d1.i);
        System.out.println("d2.i:"+d2.i);
        System.out.println("d1.j:"+d1.j);
        System.out.println("d2.j:"+d2.j);
        System.out.println("D1.j:"+D1.j);
    }
}
