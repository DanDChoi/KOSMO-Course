class E3 
{

	int i = 300;
	long lo = 600;
	void m1(){
		int r = i + (int)lo;
		System.out.println("r: "+r);
	}

	byte b = 123;
	short s = 321;
	void m2(){
		int r = s - b;
		System.out.println("r: "+r);
	}

	double d = 123.123f;
	long lo2 = 123123123;
	void m3(){
		double r = d*lo2;
		System.out.println("r: "+r);
	}


	public static void main(String[] args) 
	{
		E3 e3 = new E3();
		e3.m1();
		e3.m2();
		e3.m3();
	}
}
