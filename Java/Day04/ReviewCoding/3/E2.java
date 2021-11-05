class E2 
{
	int i = 1000;
	long lo = 2000L;
	void m1(){
		int r = i + (int)lo;
		System.out.println("r: " + r);
	}

	byte b = 1;
	short s = 2;
	void m2(){
		int r = s - b;
		System.out.println("r: "+r);
	}

	double d = 11.123f;
	long lo2 = 1111111;
	void m3(){
		double r = d*lo2;
		System.out.println("r: "+r);
	}
	public static void main(String[] args) 
	{
		E2 e2 = new E2();
		e2.m1();
		e2.m2();
		e2.m3();
	}
}
