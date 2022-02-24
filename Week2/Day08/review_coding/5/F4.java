class F4 
{
	int is1[] = {1, 2};
	int is2[] = {3 ,4};
	int iss[][] = {is1, is2};

	void out(){
		for (int i=0; i<2; i++)
		{
			for (int j=0; j<2; j++)
			{
				System.out.println("iss["+i+"]["+j+"] : "+ iss[i][j]);
			}
		}
	}
	public static void main(String[] args) 
	{
		F4 f4 = new F4();
		//f4.in();
		f4.out();
	}
}
