class C4 
{
	void m1(){ //1~10ÇÕ
		int sum=0;
		for (int i=1; i<=10; i++)
		{
			sum = sum+i;
		}
		System.out.println("sum: "+sum);
	}

	void m2(){ //1~100 Â¦¼öÈ¦¼öÇÕ
		int sum=0;
		for (int i=0; i<=100; i+=2)
		{
			sum = sum+i;
		}
		System.out.println("even_sum: "+sum);

		int sum1=0;
		for (int i=1; i<=100; i+=2)
		{
			sum1 = sum1+i;
		}
		System.out.println("odd_sum: "+sum1);
	}

	public static void main(String[] args) 
	{
		C4 c4 = new C4();
		c4.m1();
		c4.m2();
	}
}
