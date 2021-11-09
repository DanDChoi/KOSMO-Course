class C 
{
	C(){
		System.out.println("C()-1");
		m1();
		if(true) return; //to main()
		System.out.println("C()-2");
	}

	void m1(){
		for (int i=0; i<5; i++){
			if(i==2) return; //to C()
			System.out.println("i: "+i);
		}
		System.out.println("for¹Û");
	}

	public static void main(String[] args) 
	{
		System.out.println("main()-1");
		C c = new C();
		if(true) return; //to JVM
		System.out.println("main()-1");
	}
}
