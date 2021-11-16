class C1{
	C1(){
		System.out.println("오이");
		m2();
	}
	void m() {
		System.out.println("배추");

	}
	void m2() {
		System.out.println("호박");
		m();
	}
	public static void main(String args[]){
		System.out.println("당근");
		new C1();
		System.out.println("양파");
		
	}
}