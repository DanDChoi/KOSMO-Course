class A1 
{
	/*
	int is[]; //����
	A(){
		is = new int[4];//����
	}

	int is[] = new int[4];//����, ����
	
	void in(){ //�ʱ�ȭ
		is[0] = 1;
		is[1] = 2;
		is[2] = 3;
		is[3] = 4;
	}
	*/

	int is[] = {1, 2, 3, 4}; //����,����,�ʱ�ȭ

	void out(){
		for (int i=0; i<4; i++)
		{
			System.out.println(is[i];)
		}
	}
	public static void main(String[] args) 
	{
		A1 a1 = new A1();
		//a1.in();
		a1.out();
	}
}
