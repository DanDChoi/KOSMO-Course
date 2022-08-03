class A4 
{
	A4(){
		System.out.println("1");
	}
	void m1(){
		System.out.println("2");
	}
	void m2(){
		System.out.println("3");
	}
	public static void main(String[] args) 
	{
		A4 a4 = new A4();
		System.out.println("4");
		a4.m1();
		a4.m2();
		System.out.println("5");
	}
}
