class C{
    String name = "김철수";
    C(){
        super();
    }
    void m(){
        System.out.println("C의 m()");
    }
}

class CChild extends C{
    String name = "박철수";
    CChild(){
        super.m();
        System.out.println("name: "+ super.name);
    }
    void m(){
        System.out.println("CChild의 m()");
    }
    public static void main(String[] args){
        new CChild();
    }
}