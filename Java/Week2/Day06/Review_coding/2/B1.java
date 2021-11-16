class B1 
{
	void m1(){
		for(;;){
			System.out.println("¤¾¤¾");
		}
	}

	void m2(){
		for (int i=0; i<3; i++)
			System.out.println("1");
		
		System.out.println("2");
	}

	void m3(){
		int i=0;
		for(; i<3; i++)
			System.out.println("i: "+i);
	}

	public static void main(String[] args) 
	{
		B1 b1 = new B1();
		b1.m1();
		b1.m2();
	}
}
