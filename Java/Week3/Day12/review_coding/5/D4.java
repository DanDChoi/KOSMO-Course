class D4 {
    int i;
    static int j;
    
    D4(){
        i++;
        j++;
    }

    public static void main(String[] args){
        D4 d1 = new D4();
        D4 d2 = new D4();
        System.out.println("d1.i:"+d1.i);
        System.out.println("d2.i:"+d2.i);
        System.out.println("d1.j:"+d1.j);
        System.out.println("d2.j:"+d2.j);
        System.out.println("D.j:"+D.j); 
    }
}
