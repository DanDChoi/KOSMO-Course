interface F1
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

class F1Child implements F1
{
	public void m1(){
		System.out.println("m1()");
	}
}


class F1User
{
	public static void main(String[] args) 
	{
		F1Child f1 = new F1Child();
		System.out.println("f1.1: "+f1.i);
		f1.m1();
		F1.m2();
		f1.m3();
	}
}
