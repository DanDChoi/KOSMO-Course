class C{
	C() {
		System.out.println("����");
		m();
	}
	void m() {
		System.out.println("����");
		m2();
	}
	void m2() {
		System.out.println("������");
	}
	public static void main(String[] args) {
		System.out.println("���");
		System.out.println("����");
		new C();
		System.out.println("�ڵ�");
	}
}