class D4 
{
	boolean flag;
	void m1(){
		System.out.println("flag: " + flag);
	}

	float f = 111.998877665544332211f;
	void m2(){
		System.out.println("f: " + f);
	}

	double d = 111.998877665544332211;
	void m3(){
		System.out.println("d: " + d);
	}
	public static void main(String[] args) 
	{
		D4 d4 = new D4();
		//d.m1();
		d4.m2();
		d4.m3();
	}
}
