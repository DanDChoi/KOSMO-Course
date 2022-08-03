class B4 
{
	void m1(){
		for(;;)
			System.out.println("무한무한무한");
	}

	void m2(){
		for(int i=0; i<3; i++)
			System.out.println("for바디");
		System.out.println("Not for바디");
	}

	void m3(){
		int i=0;
		for(; i<3; i++)
			System.out.println("i: "+i);
	}

	public static void main(String[] args) 
	{
		B4 b4 = new B4();
		b4.m1();
		b4.m2();
		b4.m3();
	}
}
