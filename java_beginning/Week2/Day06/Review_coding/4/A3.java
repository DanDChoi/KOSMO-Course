class A3 
{

	void m1(){
		int i=0;
		while (i<3)
		{
			System.out.println("i: "+i);
			i++;
		}
	}

	void m2(){
		int i=0;
		do{
			System.out.println("i: "+i);
			i++;
		}while(i<5);
	}

	void m3(){
		for (int i=0; i<5; i++)
			System.out.println("i: "+i);
	}

	public static void main(String[] args) 
	{
		A3 a3 = new A3();
		a3.m1();
		a3.m2();
		a3.m3();
	}
}
