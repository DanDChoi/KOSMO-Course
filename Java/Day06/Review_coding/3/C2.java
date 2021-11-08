class C2 
{
	int evensum;
	int oddsum;

	void m1(){
		int sum=0;
		for (int i=1; i<=10; i++)
		{
			sum = sum+i;
		}
		System.out.println("sum: "+sum);
	}

	void m2(){
		for (int i=1; i<101; i++)
		{
			if(i%2==0){
				evensum+=i;
			}else{
				oddsum+=i;
			}
		}System.out.println("Â¦¼öÇÕ: "+evensum+", È¦¼öÇÕ: "+oddsum);
	}

	public static void main(String[] args) 
	{
		C2 c2 = new C2();
		c2.m1();
		c2.m2();
	}
}
