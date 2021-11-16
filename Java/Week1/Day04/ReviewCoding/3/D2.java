class D2 
{
	boolean flag;
	void m1(){
		System.out.println("flag: "+ flag);
	}

	float f = 111.2233445566778899f;
	void m2(){
		System.out.println("f: " + f);
	}

	double d = 111.2233445566778899;
	void m3(){
		System.out.println("d: "+d);
	}

	public static void main(String[] args) 
	{
		D2 d2 = new D2();
		d2.m1();
		d2.m2();
		d2.m3();
	}
}
