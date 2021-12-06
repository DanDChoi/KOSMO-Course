class E1
{
	void m1(){
		for (int i=0; i<4; i++)
		{
			for(int j=0; j<4; j++){
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) 
	{
		E1 e1 = new E1();
		e1.m1();
	}
}
