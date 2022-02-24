class C2 {
	C2(){
		System.out.println("사자");
		m();
	}
	void m() {
		System.out.println("하마");
		m2();
	}
	void m2() {
		System.out.println("호랑이");
	}

	public static void main(String[] args) {
		System.out.println("기린");
		System.out.println("고양이");
		new C2();
		System.out.println("공작새");
	}
}
