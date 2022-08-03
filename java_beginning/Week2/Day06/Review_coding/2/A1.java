class A1 
{
	void m1(){
		int i=0;
		while (i<5)
		{
			System.out.println("i: "+i);
			i++;
		}
	}
	
	void m2(){
		for (int i=0; i<5; i++)
		{
			System.out.println("i: "+i);
		}
	}

	void m3(){
		int i=0;
		do{
			System.out.println("i: "+i);
			i++;
		}while(i<5);
	}

	public static void main(String[] args) 
	{
		A1 a1 =  new A1();
		a1.m1();
		a1.m2();
		a1.m3();
	}
}
