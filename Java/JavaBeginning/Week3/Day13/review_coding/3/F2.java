interface F2
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

class F2Child implements F2
{
	public void m1(){
		System.out.println("m1()");
	}
}


class F2User
{
	public static void main(String[] args) 
	{
		F2Child f2 = new F2Child();
		System.out.println("f2.i: "+f2.i);
		f2.m1();
		F2.m2();
		f2.m3();
	}
}
