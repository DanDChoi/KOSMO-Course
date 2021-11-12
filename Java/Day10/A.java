import java.lang.*;

class Human extends Object {
	String name = "홍길동";
	//Human(){}
	Human(String name){
		super(); //new Object();
		this.name = name;
	}
	void move(){
		System.out.println("걷는다");
	}
}
class Superman extends Human {
	int power = 1000;
	Superman(){
		super("클락");
	}
	void move(){ //(메소드)오버라이딩 
		System.out.println("날라간다");
	}
	void shot(){
		System.out.println("광선을쏜다");
	}
}
class Hulk extends Human {
	int muscle = 500;
	Superman(){
		super("브루스");
	}
	void move(){
		System.out.println("뛰어다닌다");
	}
	void tranfer(){
		System.out.println("변신한다");
	}
}

class God {
	public static void main(String args[]){
		Superman sm = new Superman();
		System.out.print(sm.power + "N의 힘을 가진 " + sm.name+"이 ");
		sm.move(); 
		sm.shot();
		System.out.println();

        //(1) 자동형변환
		Human m = sm;
		//System.out.print(m.power + "N의 힘을 가진 "); //제약1
		System.out.print(m.name+"이 ");
		m.move(); 
		//m.shot(); //제약2
		System.out.println();

        //(2) 강제형변환
        Superman sm2 = (Superman)m;
		System.out.print(sm2.power + "N의 힘을 가진 ");
		System.out.print(sm2.name+"이 ");
		sm2.move(); 
		sm2.shot();

        /*
        Human m2 = new Human("세종대왕");
		Superman sm3 = (Superman)m2; //잘못된 형변환 
		sm3.move();
		//1. 컴O, 실X
		//2. 컴X, 실X
		//3. 컴O, 실O */

        //Superman sm4 = new Hulk();
		//1. 컴O, 실X
		//2. 컴X, 실X
		//3. 컴O, 실O
	}
}
