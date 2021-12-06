class F
{
	int is1[] = {10, 20};
	int is2[] = {30, 40};
	int iss[][] = {is1, is2};

	void out(){
		for (int i=0; i<2; i++){
			for (int j=0; j<2; j++){
			System.out.println("iss["+i+"]["+j+"]: "+iss[i][j]);
			}
		}
	}
	public static void main(String[] args) 
	{
		F f = new F();
		f.out();
	}
}
