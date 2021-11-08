class C 
{
	void m1(){ //1~10ÀÇ ÇÕ
		int t=0;
		for (int i=1; i<=10; i++)
		{
			t = t+i;
		}
		System.out.println("sum: "+t);
	}

	void m2(){ //1~100 Â¦¼öÇÕ, È¦¼öÇÕ
		int sum=0;
		for (int i=0; i<=100; i+=2)
		{
			sum = sum+i;
		}
		System.out.println("even_sum: "+sum);
		
		int sum1=0;
		for (int i =1; i<=100; i+=2)
		{
			sum1 = sum1 +i;
		}
		System.out.println("odd_sum: "+sum1);
	}

	public static void main(String[] args) 
	{
		C c = new C();
		c.m1();
		c.m2();
	}
}
