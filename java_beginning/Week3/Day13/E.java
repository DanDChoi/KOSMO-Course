class E {
	//(1) ������ �����ε� 
	E(){
	}
	E(String str){
	}
	E(int i){
	}
	E(String str, int i){
	}

    //(2) �޼ҵ� �����ε�
	void m(String name){
	}
	int m(int age){
		System.out.println("m(int)");
		return age;
	}
	void m(short s){
		System.out.println("m(short)");
	}
}
class EChild extends E {
	void m(String name, int age){ //�����ε� 
	}
}

class EUser{
	public static void main(String[] args) {
		E e = new E();
		short s = 10;
		e.m(s);
	}
}
