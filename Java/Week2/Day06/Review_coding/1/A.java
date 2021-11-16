class A {

	void m1(){ //while
		int i = 0;
		while (i<5)
		{
			System.out.println("i: "+i);
			i+=1;
		}
	}

	void m2(){ //for
		for (int i = 0; i<5; i++)
		{
			System.out.println("i: "+i);
		}
	}

	void m3(){ //do{}while()
		int i=0;
		do{
			System.out.println("i: "+i);
			i++;
		}while(i<5);
	}

	public static void main(String[] args) 
	{
		A a = new A();
		a.m1();
		a.m2();
		a.m3();
	}
}
