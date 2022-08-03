class A1 
{
	A1(){
		System.out.println("a");
	}
	void m1(){
		System.out.println("b");
	}
	void m2(){
		System.out.println("c");
	}
	public static void main(String[] args) 
	{
		System.out.println("d");
		System.out.println("e");
		A1 a1 = new A1();
		System.out.println("f");
		a1.m1();
		a1.m2();
	}
}
