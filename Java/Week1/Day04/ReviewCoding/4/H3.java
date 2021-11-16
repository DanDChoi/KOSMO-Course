class H3 
{
	final int i = 300;
	void m1(){
		System.out.println("i: " + i);
	}
	void m2(){
		final int j = 500;
		System.out.println("j: " + j);
	}
	public static void main(String[] args) 
	{
		H3 h3 = new H3();
		h3.m1();
		h3.m2();
	}
}
