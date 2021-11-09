class A 
{
	void m1(){
		for(int i=0; i<5; i++){
			if(i>2) break;
		    System.out.println("i: " + i);
		}
	}
	void m2(){
		for(int i=0; i<2; i++){
			for(int j=0; j<3; j++){
				if(j==1) break;
				System.out.println("i: " + i + ", j: " + j);
			}//1
			System.out.println("救 for观");
		}//2
		System.out.println("观 for观");
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
					default: System.out.println("A绰 酒丛"); break;
				}//1
				System.out.println("救 switch观");
			    break;
			default: System.out.println("5 or 10 酒丛"); break;
		}//2
		System.out.println("观 switch观");
	}
	public static void main(String[] args) 
	{
		A a = new A();
		//a.m1();
		//a.m2();
		a.m3();
	}
}
