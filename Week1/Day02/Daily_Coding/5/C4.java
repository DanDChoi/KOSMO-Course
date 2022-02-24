class C4 {
	C4(){
		System.out.println("피자");
		m();
	}
	void m(){
		System.out.println("햄버거");
		m2();
	}
	void m2(){
		System.out.println("감자튀김");
	}
	public static void main(String[] args) 
	{
		System.out.println("콜라");
		System.out.println("계란");
		new C4();
		System.out.println("사이다");
	}
}
