class A3 
{
	int is[] = {1, 2, 3, 4};

	void out(){
		for (int i=0; i<4; i++){
			System.out.println("is["+i+"]: "+is[i]);
		}
	}


	public static void main(String[] args) 
	{
		A3 a3 = new A3();
		a3.in();
		a3.out();
	}
}
