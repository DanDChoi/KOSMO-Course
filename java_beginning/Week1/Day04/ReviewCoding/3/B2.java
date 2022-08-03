class  B2
{
	int a;
	B2(int a){
		System.out.println("a1: " + a);
		this.a = a;
	}
	void m(){
		System.out.println("a2: " + a);
		int b = 50;
		System.out.println("b: " + b);
	}

	public static void main(String[] args) 
	{
		B2 b2 = new B2(500);
		b2.m();
	}
}
