class D4 
{
	byte b = 1;
	short s = 2;
	char c = 'A';
	int i =3;
	float f = 4.5f;

	int is[] = {b, s, c, i, (int)f};

	void out(){
		for (int i=0; i<5; i++){
			System.out.println("is["+i+"]: "+is[i]);
		}
	}
	public static void main(String[] args) 
	{
		new D4().out();
	}
}
