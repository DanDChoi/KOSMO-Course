class  D
{
	void m1(){ //������ 2��
		for (int i =1; i<=9; i++)
		{
			System.out.println("2 * "+i+" = "+2*i);
		}
	}

	void m2(){ //������
		for (int i=2; i<=9; i++)
		{
			for (int j=1; j<=9; j++)
			{
				System.out.println(i+" * "+j+" = "+i*j);
			}
		}
	}

	void m3(){ //��������
		for (int i=2; i<=9; i++)
			for (int j=1; j<=9; j++)
				for (int k=1; k<=9; k++)
					System.out.println(i+" * "+j+" * "+k+" = "+i*j*k);
	}

	void m4(){ //m3() -> while��
		int i = 2;
		while (i<=9)
		{
			int j = 1;
			while (j<=9)
			{
				int k=1;
				while (k<=9)
				{
					System.out.println(i+" * "+j+" * "+k+" = "+i*j*k);
					k++;
				}
				j++;
			}
			i++;
		}
	}
	public static void main(String[] args) 
	{
		D d = new D();
		d.m1();
		d.m2();
		d.m3();
		d.m4();
	}
}
