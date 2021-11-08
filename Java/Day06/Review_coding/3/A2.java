class A2 
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
		A2 a2 = new A2();
		a2.m1();
		a2.m2();
		a2.m3();
	}
}
