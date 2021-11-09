class C1 
{
	C1(){
		System.out.println("C-1");
		m1();
		if(true) return;
		System.out.println("C-2");
	}

	void m1(){
		for (int i=0; i>5; i++){
			if(i==2) return;
			System.out.println("i: "+i);
		}
		System.out.println("for¹Ù±ù");
	}

	public static void main(String[] args) 
	{
		System.out.println("main-1");
		C1 c1 = new C1();
		if(true) return;
		System.out.println("main-2");
	}
}
