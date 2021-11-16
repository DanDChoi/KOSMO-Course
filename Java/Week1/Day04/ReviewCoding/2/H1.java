class H1 
{
	final int a = 1000;
	void m1(){
		System.out.println("a: " + a);
	}
	void m2(){
		final int b = 2000;
		System.out.println("b: " + b);
	}
	public static void main(String[] args) 
	{
		H1 h1 = new H1();
		h1.m1();
		h1.m2();
	}
}
