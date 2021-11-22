class B2 
{
	
	void m1(){
		for(;;){
			System.out.println("무한루프");
		}
	}

	void m2(){
		for (int i=0; i<3; i++)
			System.out.println("여기까지가 for구문");

		System.out.println("여긴아님");
	}

	void m3(){
		int i=0;
		for (; i<3; i++)
			System.out.println("i: "+i);
	}

	public static void main(String[] args) 
	{
		B2 b2 = new B2();
		b2.m1();
		b2.m2();
		b2.m3();
	}
}
