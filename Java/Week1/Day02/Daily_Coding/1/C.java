class C{
	C() {
		System.out.println("포도");
		m();
	}
	void m() {
		System.out.println("딸기");
		m2();
	}
	void m2() {
		System.out.println("오렌지");
	}
	public static void main(String[] args) {
		System.out.println("사과");
		System.out.println("수박");
		new C();
		System.out.println("자두");
	}
}