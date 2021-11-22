class A2 
{
	int is[] = {100, 200, 300, 400};

	void out(){
		for (int i=0; i<4; i++){
			System.out.println("is{"+i+"]: "+is[i]);

		}
	}

	public static void main(String[] args) 
	{
		A2 a2 = new A2();
		a2.out();
	}
}
