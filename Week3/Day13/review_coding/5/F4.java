interface F4
{
	int i = 1;
	void m1();

	static void m2(){
		System.out.println("m2()");
	}
	default void m3(){
		System.out.println("m3()");
	}
}

class F4Child implements F4
{
	public void m1(){
		System.out.println("m1()");
	}
}


class F4User
{
	public static void main(String[] args) 
	{
		F4Child f4 = new F4Child();
		System.out.println("f4.i: "+f4.i);
		f4.m1();
		F4.m2();
		f4.m3();
	}
}
