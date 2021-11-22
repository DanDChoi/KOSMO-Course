class D 
{
	boolean flag;
	void m1(){
		System.out.println("flag: " + flag);
	}

	float f = 123.123456789012345f;
	void m2(){
		System.out.println("f: " + f);
	}

	double d = 123.123456789012345;
	void m3(){
		System.out.println("d: " + d);
	}
	public static void main(String[] args) 
	{
		D d = new D();
		//d.m1();
		d.m2();
		d.m3();
	}
}
