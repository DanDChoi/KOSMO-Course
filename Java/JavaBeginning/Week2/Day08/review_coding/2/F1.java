class F1 
{
	int is1[] = {1, 2};
	int is2[] = {3, 4};
	int iss[][] = {is1, is2};

	void out(){
		for (int i=0; i<2; i++)
		{
			for (int j=0; j<2; j++)
			{
				System.out.println("iss["+i+"]["+j+"]: "+iss[i][j]);
			}
		}
	}
	public static void main(String[] args) 
	{
		F1 f1 = new F1();
		//f1.in();
		f1.out();
	}
}
