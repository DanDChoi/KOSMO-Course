class B3 
{
	void m1(){
		for(;;)
			System.out.println("���ѹݺ�");
	}

	void m2(){
		for(int i=0; i<6; i++)
			System.out.println("for�����ٵ�");
		System.out.println("for�ƴ�");
	}

	void m3(){
		int i=0;
		for(; i<6; i++)
			System.out.println("i: "+i);
	}

	public static void main(String[] args) 
	{
		B3 b3 = new B3();
		b3.m1();
		b3.m2();
		b3.m3();
	}
}
