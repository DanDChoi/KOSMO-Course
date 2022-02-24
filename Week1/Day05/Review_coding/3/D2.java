class D2 
{
	int a = 6134;
	int b = 34;

	void m1(){
		int i = a/b;
		int j = a%b;
		System.out.println("¸ò: "+i+", ³ª¸ÓÁö: "+j);
	}
	public static void main(String[] args) 
	{
		D2 d2 = new D2();
		d2.m1();
	}
}
