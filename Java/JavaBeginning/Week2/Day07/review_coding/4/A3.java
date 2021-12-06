class A3 
{
	void m1(){
		for (int i=0; i<5; i++){
			if(i>2) break;
			System.out.println("i: "+i);
		}
	}
	void m2(){
		for (int i=0; i<2; i++){	
			for (int j=0; j<3; j++){
				if(j==1) break;
				System.out.println("i: "+i+", j: "+j);
			}
			System.out.println("¾È for¹Ù±ù");
		}
		System.out.println("¹Ù±ù for¹Ù±ù");
	}
	void m3(){
		int i = 10;
		char c = 'A';
		switch(i){
			case 5: System.out.println("5"); break;
			case 10: 
				System.out.println("10"); 
			    switch(c){
					case 'A': System.out.println("A"); break;
					default: System.out.println("A´Â ¾Æ´Ô"); break;
				}//1
				System.out.println("¾È switch¹Û");
			    break;
			default: System.out.println("5 or 10 ¾Æ´Ô"); break;
		}//2
		System.out.println("¹Û switch¹Û");
	}

	public static void main(String[] args) 
	{
		A3 a3 = new A3();
		a3.m1();
		a3.m2();
		a3.m3();
	}
}
