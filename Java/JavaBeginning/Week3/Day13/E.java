class E {
	//(1) 생성자 오버로딩 
	E(){
	}
	E(String str){
	}
	E(int i){
	}
	E(String str, int i){
	}

    //(2) 메소드 오버로딩
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
	void m(String name, int age){ //오버로딩 
	}
}

class EUser{
	public static void main(String[] args) {
		E e = new E();
		short s = 10;
		e.m(s);
	}
}
