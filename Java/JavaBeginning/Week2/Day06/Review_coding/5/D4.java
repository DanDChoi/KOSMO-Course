class D4 
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
		for (int i=2; i<=9; i++)
			for(int j=1; j<=9; j++)
				for(int q=1; q<=9; q++)
					System.out.println(i+" * "+j+" * "+q+" = "+i*j*q);
	}

	void m4(){
		int i=2;
			while (i<=9)
			{
				int j=1;
				while (j<=9)
				{
					int q=1;
					while (q<=9)
					{
						System.out.println(i" * "+j+" * "+q+" = "+i*j*q);
						q++;
					}
					j++;
				}
				i++;
			}
	}
		
	public static void main(String[] args) 
	{
		D4 d4 = new D4();
		d4.m1();
		d4.m2();
		d4.m3();
		d4.m4();
	}
}
