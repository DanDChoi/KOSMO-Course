class A 
{
	A(){
		System.out.println("가");
	}
	void m(){
		System.out.println("나");
	}
	void m2(){
		System.out.println("다");
	}
	public static void main(String[] args) 
	{
		A a = new A();
		a.m();
		System.out.println("라");
		System.out.println("마");
		a.m2();
		System.out.println("바");
	}
}
