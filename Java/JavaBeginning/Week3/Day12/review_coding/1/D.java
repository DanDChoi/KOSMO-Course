class D {
    int i;
    static int j;

    D(){
        i++;
        j++;
    }

    public static void main(String[] args){
        D d1 = new D();
        D d2 = new D();
        System.out.println("d1.i: "+ d1.i);
        System.out.println("d2.i: "+ d2.i);
        System.out.println("d1.j: "+ d1.j);
        System.out.println("d2.j: "+ d2.j);
        System.out.println("D.j: "+ D.j);
    }
}
