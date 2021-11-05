class D4 
{
	int a = 598341256;
	int b = 5674;

	void m1(){
		int i = a/b;
		int j = a%b;
		System.out.println("¸ò: "+i+", ³ª¸ÓÁö: "+j);
	}

	public static void main(String[] args) 
	{
		D4 d4 = new D4();
		d4.m1();
	}
}
