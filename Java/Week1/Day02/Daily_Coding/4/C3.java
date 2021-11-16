class C3 {
	C3(){
		System.out.println("아메리카노");
		m();
	}
	void m(){
		System.out.println("카페라떼");
		m2();
	}
	void m2(){
		System.out.println("카푸치노");
	}
	public static void main(String[] args) 
	{
		System.out.println("녹차라떼");
		System.out.println("에스프레소");
		new C3();
		System.out.println("허브티");
	}
}
