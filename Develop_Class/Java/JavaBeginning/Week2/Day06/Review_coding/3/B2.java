class B2 
{
	
	void m1(){
		for(;;){
			System.out.println("���ѷ���");
		}
	}

	void m2(){
		for (int i=0; i<3; i++)
			System.out.println("��������� for����");

		System.out.println("����ƴ�");
	}

	void m3(){
		int i=0;
		for (; i<3; i++)
			System.out.println("i: "+i);
	}

	public static void main(String[] args) 
	{
		B2 b2 = new B2();
		b2.m1();
		b2.m2();
		b2.m3();
	}
}
