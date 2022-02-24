class D 
{
	byte b = 10;
	short s = 20;
	char c = 'A';
	int i = 30;
	float f = 40.5f;

	int is[] = {b, s, c, i, (int)f};

	D(){
		//int is[] = {b, s, c, i}; 
	}
	void out(){
		for (int i=0; i<5; i++)
		{	System.out.println("is["+i+"]: "+is[i]);
		}
	}
	public static void main(String[] args) 
	{
		new D().out();
	}
}
