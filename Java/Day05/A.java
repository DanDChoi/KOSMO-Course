class A 
{
	A(){
		System.out.println("2");
	}
	void m1(){
		System.out.println("4");
	}
	void m2(){
		System.out.println("6");
	}
	public static void main(String[] args) 
	{
		System.out.println("1");
		A a = new A();
		System.out.println("3");
		a.m1();
		System.out.println("5");
		a.m2();
		System.out.println("7");
	}
}
