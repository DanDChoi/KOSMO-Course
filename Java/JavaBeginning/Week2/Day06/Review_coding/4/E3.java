class E3 
{

	void m1(){
		for (int i=0; i<4; i++)
		{
			for (int j=0; j<4; j++)
			{
				System.out.println("@ ");
			}
			System.out.println();
		}
	
	}
	
	public static void main(String[] args) 
	{
		E3 e3 = new E3();
		e3.m1();
	}
}
