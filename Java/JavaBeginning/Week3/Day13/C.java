class C {
	String name = "홍길동";
	C(){
		super(); //(1)
	}
	void m(){ //오버라이딩 전 
		System.out.println("C의 m()");
	}
}
class CChild extends C{
	String name = "이순신";
	CChild(){
		super.m();
		System.out.println("name: " +super.name);
	}
	void m(){ //오버라이딩 후 
		System.out.println("CChild의 m()");
	}	
	public static void main(String[] args) {
		new CChild();
	}
}
