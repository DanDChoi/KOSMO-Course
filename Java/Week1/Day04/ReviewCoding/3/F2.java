class F2 
{
	byte b;
	short s;
	char c;
	int i;
	long lo;
	float f;
	double d;
	boolean flag;

	void showValue(){
		System.out.println("b: "+b);
		System.out.println("s: " + s);
		System.out.println("c: " + (int)c);
		System.out.println("i: " + i);
		System.out.println("lo: " + lo);
		System.out.println("f: " + f);
		System.out.println("d: " + d);
		System.out.println("flag: " + flag);
	}
	public static void main(String[] args) 
	{
		new F2().showValue();
	}
}
