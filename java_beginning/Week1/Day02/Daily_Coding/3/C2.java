class C2 {
	C2(){
		System.out.println("����");
		m();
	}
	void m() {
		System.out.println("�ϸ�");
		m2();
	}
	void m2() {
		System.out.println("ȣ����");
	}

	public static void main(String[] args) {
		System.out.println("�⸰");
		System.out.println("�����");
		new C2();
		System.out.println("���ۻ�");
	}
}
