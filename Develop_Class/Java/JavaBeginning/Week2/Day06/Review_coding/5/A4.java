class A4 
{
	void m1(){
		int i=0;
		while (i<8)
		{
			System.out.println("i: "+i);
			i++;
		}
	}

	void m2(){
		for(int i=0; i<5; i++)
			System.out.println("i: "+i);
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
		A4 a4 = new A4();
		a4.m1();
		a4.m2();
		a4.m3();
	}
}
