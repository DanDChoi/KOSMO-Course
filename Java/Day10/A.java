import java.lang.*;

class Human extends Object {
	String name = "ȫ�浿";
	//Human(){}
	Human(String name){
		super(); //new Object();
		this.name = name;
	}
	void move(){
		System.out.println("�ȴ´�");
	}
}
class Superman extends Human {
	int power = 1000;
	Superman(){
		super("Ŭ��");
	}
	void move(){ //(�޼ҵ�)�������̵� 
		System.out.println("���󰣴�");
	}
	void shot(){
		System.out.println("���������?");
	}
}
class Hulk extends Human {
	int muscle = 500;
	Superman(){
		super("���?");
	}
	void move(){
		System.out.println("�پ�ٴѴ�?");
	}
	void tranfer(){
		System.out.println("�����Ѵ�");
	}
}

class God {
	public static void main(String args[]){
		Superman sm = new Superman();
		System.out.print(sm.power + "N�� ���� ���� " + sm.name+"�� ");
		sm.move(); 
		sm.shot();
		System.out.println();

        //(1) �ڵ�����ȯ
		Human m = sm;
		//System.out.print(m.power + "N�� ���� ���� "); //����1
		System.out.print(m.name+"�� ");
		m.move(); 
		//m.shot(); //����2
		System.out.println();

        //(2) ��������ȯ
        Superman sm2 = (Superman)m;
		System.out.print(sm2.power + "N�� ���� ���� ");
		System.out.print(sm2.name+"�� ");
		sm2.move(); 
		sm2.shot();

        /*
        Human m2 = new Human("�������?");
		Superman sm3 = (Superman)m2; //�߸��� ����ȯ 
		sm3.move();
		//1. ��O, ��X
		//2. ��X, ��X
		//3. ��O, ��O */

        //Superman sm4 = new Hulk();
		//1. ��O, ��X
		//2. ��X, ��X
		//3. ��O, ��O
	}
}
