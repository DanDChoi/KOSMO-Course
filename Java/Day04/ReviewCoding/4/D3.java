class D3
{
	boolean flag;
	void m1(){
		System.out.println("flag: "+flag);
	}

	float f = 123.123123123123123f;
	void m2(){
		System.out.println("f: "+f);	
	}

	double d =123.123123123123123;
	void m3(){
		System.out.println("d: "+d);
	}
	public static void main(String[] args) 
	{
		D3 d3 = new D3();
		d3.m1();
		d3.m2();
		d3.m3();
	}
}
