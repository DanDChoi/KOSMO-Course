abstract class F{ //추상클래스
     //abstact int i; //why?
    //abstract F(); //why?

    abstract void m1(); //추상메소드
    void m2(){ //일반메소드
        System.out.println("m2()");
    }
}

class FUser extends F{

    void m1(){
        System.out.println("변경");
    }
    void m2(){
        System.out.println("this");
    }
     public static void main(String[] args){
        //미션: F객체를 생성해서 메소드를 호출해 보세요.
        new FUser().m1();
        new FUser().m2();
     }
}

    