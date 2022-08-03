class C3 
{
	void m1(){ //1~10 ÇÕ
		int sum = 0;
		for(int i=1; i<=10; i++){
			sum = sum + i;
		}
		System.out.println("sum: "+ sum);
	}

	void m2(){ //1~100 Â¦¼öÇÕ°ú È¦¼öÇÕ
		int sum = 0;
		for (int i=0; i<=100; i+=2){
			sum = sum + i;
		}
		System.out.println("even_sum: "+sum);
	
		int sum1 = 0;
		for (int i=1; i<=100; i+=2){
			sum1 = sum1 + i;
		}
		System.out.println("odd_sum: "+sum1);
	}


	public static void main(String[] args) 
	{
		C3 c3 = new C3();
		c3.m1();
		c3.m2();
	}
}
