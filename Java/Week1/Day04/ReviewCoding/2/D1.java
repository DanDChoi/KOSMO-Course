class D1 {
	boolean flag;
	void m1(){
		System.out.println("flag: " + flag);
	}
	float f = 123.1234567890123456789f;
	void m2(){
		System.out.println("f: " + f);
	}

	double d = 123.1234567890123456789;
	void m3(){
		System.out.println("d: " + d);
	}
	public static void main(String[] args) 
	{
		D1 d1 = new D1();
		d1.m1();
		d1.m2();
		d1.m3();
	}
}
