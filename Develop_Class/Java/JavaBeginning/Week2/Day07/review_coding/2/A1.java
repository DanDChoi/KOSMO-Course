class A1 
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
			}
			System.out.println("�� for��");
		}
		System.out.println("�� for��");
	}
	void m3(){
		int i = 5;
		char c = 'A';
		switch(i){
			case 5: System.out.println("5"); break;
			case 10: 
				System.out.println("10"); 
			    switch(c){
					case 'A': System.out.println("A"); break;
					default: System.out.println("A�� �ƴ�"); break;
				}
				System.out.println("�� switch��");
			    break;
			default: System.out.println("5 or 10 �ƴ�"); break;
		}
		System.out.println("�� switch��");
	}
	public static void main(String[] args) 
	{
		A1 a1 = new A1();
		a1.m1();
		a1.m2();
		a1.m3();
	}
}
