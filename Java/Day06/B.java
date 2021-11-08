class B 
{
	void m1(){
		for(;;){ // == while(true)
			System.out.println("하하");
		}
	}

	void m2(){
		for(int i=0; i<3; i++) //for문에 바디({})가 없으면 첫번째 라인만 for의 바디로 인식
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
		B b =  new B();
		//b.m1();
		//b.m2();
		b.m3();
	}
}
