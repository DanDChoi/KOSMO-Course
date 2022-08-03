class D1 
{
	int a = 15;
	int b = 4;

	void m1(){
		int i = a/b;
		int j = a%b;
		System.out.println("i: "+i+", j: "+j);
	}

	public static void main(String[] args) 
	{
		D1 d1 = new D1();
		d1.m1();
	}
}
