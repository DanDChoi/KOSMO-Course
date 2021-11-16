class E4 
{
	int i = 10;
	long lo = 20L;
	void m1(){
		int r = i + (int)lo;
		System.out.println("r: " + r);
	}

	byte b = 1;
	short s = 2;
	void m2(){
		int r = s - b;
		System.out.println("r: " + r);
	}

	double d = 10.123f;
    long lo2 = 99999999;
	void m3(){
	    double r = d*lo2;
		System.out.println("r: " + r);
	}
	public static void main(String[] args) 
	{
		E4 e4 = new E4();
		e4.m1();
		e4.m2();
		e4.m3();
	}
}