class E1 {

	int a = 200;
	long b = 400L;
	void m1(){
		int r = a + (int)b;
		System.out.print("r: " + r);
	}

	byte c = 100;
	short d = 200;
	void m2(){
		int r = c - d;
		System.out.println("r: " + r);
	}

	double e = 12.123f;
	long f2 = 5555555;
	void m3(){
		double r = e*f2;
		System.out.println("r: " + r);
	}

	public static void main(String[] args) 
	{
		E1 e1 = new E1();
		e1.m1();
		e1.m2();
		e1.m3();
	}
}
