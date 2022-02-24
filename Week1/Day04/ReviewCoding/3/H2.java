class H2 
{
	final int i = 1;
	void m1(){
		System.out.println("i: "+i);
	}
	void m2(){
		final int j = 2;
		System.out.println("j: "+j);
	}
	public static void main(String[] args) 
	{
		H2 h2 =  new H2();
		h2.m1();
		h2.m2();
	}
}
