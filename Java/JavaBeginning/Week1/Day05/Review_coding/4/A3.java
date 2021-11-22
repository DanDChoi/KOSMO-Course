class A3 
{
	A3(){
		System.out.println("one");
	}
	void m1(){
		System.out.println("two");
	}
	void m2(){
		System.out.println("three");
	}
	void m3(){
		System.out.println("four");
		m1();
	}
	public static void main(String[] args) 
	{
		System.out.println("five");
		A3 a3 = new A3();
		System.out.println("six");
		a3.m3();
		a3.m2();
	}
}
