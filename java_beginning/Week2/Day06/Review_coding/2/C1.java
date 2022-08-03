class C1
{

	void m1(){
		int sum = 0;
		for (int i=1; i<=10; i++)
		{
			sum = sum +i;
		}
		System.out.println("sum: "+sum);
	}

	void m2(){
		int sum=0;
		for (int i=0; i<=100; i+=2)
		{
			sum=sum+i;
		}
		System.out.println("even_sum: "+sum);

		int sum1=0;
		for (int i=1; i<=100; i+=2)
		{
			sum1 = sum1 +i;
		}
		System.out.println("odd_sum: "+sum1);
	}

	public static void main(String[] args) 
	{
		C1 c1 = new C1();
		c1.m1();
		c1.m2();
	}
}
