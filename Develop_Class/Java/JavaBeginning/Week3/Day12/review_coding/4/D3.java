class D3 {
    int i;
    static int j;
    D3(){
        i++;
        j++;
    }    

    public static void main(String[] args){
        D3 d1 = new D3();
        D3 d2 = new D3();
        System.out.println("d1.i:"+d1.i);
        System.out.println("d2.i:"+d2.i);
        System.out.println("d1.j:"+d1.j);
        System.out.println("d2.j:"+d2.j);
        System.out.println("D.j:"+D.j);
    }
}
