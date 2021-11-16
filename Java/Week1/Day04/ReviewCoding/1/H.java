class  H
{
	final int i = 10;
	
	void m1(){
		System.out.println("i: "+i);
	}
	void m2(){
		int i = 20;
		System.out.println("i: "+i);
	}

	public static void main(String[] args) 
	{
		H h = new H();
		h.m1();
		h.m2();
	}
}
