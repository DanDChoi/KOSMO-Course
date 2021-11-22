class H4 
{
	final int i = 50;
	void m1(){
		System.out.println("i: " + i);
	}
	void m2(){
		final int j = 70;
		System.out.println("j: " + j);
	}
	public static void main(String[] args) 
	{
		H4 h4 = new H4();
		h4.m1();
		h4.m2();
	}
}
