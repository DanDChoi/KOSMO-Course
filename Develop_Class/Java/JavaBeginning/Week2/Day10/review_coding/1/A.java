import java.lang.*;

class Human
{
	String name = "��ö��";
	Human(String name){
		this.name = name;
	}
	void move(){
		System.out.println("�ȴ´�");
	}
class Superman extends Human {
	int power = 1000;
	Superman(){
		super("Ŭ��")
	}
	void move(){
		System.out.println("���ư���");
	}
	void shot(){
		System.out.println("������ ���");
	}
}
class Hulk extends Human {
	int muscle = 500;
	Hulk(){
		super("��罺");
	}
	void move(){
		System.out.println("�پ�ٴѴ�");
	}
	void transform(){
		System.out.println("�����Ѵ�");
	}

}

class God {
	public static void main(String[] agrs){
		Superman sm = new Superman();
		System.out.println(sm.power + "N�� ���� ����"+sm.name"�� ");
		sm.move();
		sm.shot();
		System.out.println();
	
		//�ڵ�����ȯ
		Human m = sm;
		System.out.print(m.name+"�� ");
		m.move();
		System.out.println();

		Superman sm2 = (Superman)m;
		System.out.print(sm2.power+"N�� ���� ���� ");
		System.out.print(sm2.name+"�� ");
		sm2.move();
		sm2.shot();
	}
}
