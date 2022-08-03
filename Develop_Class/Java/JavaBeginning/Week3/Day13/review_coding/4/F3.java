interface F3
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

class F3Child implements F3
{
	public void m1(){
		System.out.println("m1()");
	}
}


class F3User
{
	public static void main(String[] args) 
	{
		F3Child f3 = new F3Child();
		System.out.println("f3.i: "+f3.i);
		f3.m1();
		F3.m2();
		f3.m3();
	}
}
