class D2 
{

	void m1(){
		for (int i=1; i<=9; i++)
		{
			System.out.println("2 * "+i+" = "+2*i);
		}
	}

	void m2(){
		for (int i=2; i<=9; i++)
		{
			for (int j=1; j<=9; j++)
			{
				System.out.println(i+" * "+j+" = "+i*j);
			}
		}
	}

	void m3(){
		for(int i=2; i<=9; i++)
			for(int j=1; j<=9; j++)
				for(int z=1; z<=9; z++)
					System.out.println(i+" * "+j+" * "+z+" = "+i*j*z);
	}

	void m4(){
		int i = 2;
		while (i<=9)
		{
			int j=1;
			while (j<=9)
			{
				int z=1;
				while (z<=9)
				{
					System.out.println(i+" * "+j+" * "+z+" = "+i*j*z);
					z++;
				}
				j++;
			}
			i++;
		}
	}
	
	public static void main(String[] args) 
	{
		D2 d2 = new D2();
		d2.m1();
		d2.m2();
		d2.m3();
		d2.m4();
	}
}
