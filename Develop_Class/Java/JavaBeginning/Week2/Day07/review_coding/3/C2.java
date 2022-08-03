class C2 
{
	C2(){
		System.out.println("C1");
		m1();
		if(true) return;
		System.out.println("C2");
	}
	void m1(){
		for (int i=0; i<5; i++){
			if(i==2) return;
			System.out.println("i: "+i);
		}
		System.out.println("for¹Ù±ù");
	}

	public static void main(String[] args) 
	{
		System.out.println("main1");
		C2 c2 = new C2();
		if(true) return;
		System.out.println("main2");
	}
}
