class C1{
	C1(){
		System.out.println("����");
		m2();
	}
	void m() {
		System.out.println("����");

	}
	void m2() {
		System.out.println("ȣ��");
		m();
	}
	public static void main(String args[]){
		System.out.println("���");
		new C1();
		System.out.println("����");
		
	}
}