class D 
{
	int a = 8;
	int b = 3;

	void m(){
		int i = a/b;
		int j = a%b;
		System.out.println("i : " + i + ", j: " + j);
	}
	public static void main(String[] args) 
	{
		D d = new D();
		d.m();
	}
}
