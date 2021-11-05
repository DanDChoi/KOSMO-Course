class A3 
{
	int q = 10000;
	static int w = 20000;

	A3(){
	}
	void m(){
	}	
}

class A3User{
	
	public static void main(String[] args) 
	{
		A3 a3 = new A3();
		System.out.println("a3.q: " + a3.q);
		System.out.println("A3.w: "+ A3.w);
	}
}
