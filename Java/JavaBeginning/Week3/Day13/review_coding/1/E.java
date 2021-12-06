class E {
    E(){}
    E(String str){}
    E(int i){}
    E(String str, int i){}
    void m(String name){}
    int m(int age){
        System.out.println("m(int)");
        return age;
    }
    void m(short s){
        System.out.println("m(short)");
    }
}

class EChild extends E{
    void m(String name, int age){

    }
}

class EUser{
    public static void main(String[] args){
        E e = new E();
        short s = 10;
        e.m(s);
    }
}