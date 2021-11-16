class F1 
{
	byte a;
	short b;
	char c;
	int d;
	long e;
	float f;
	double g;
	boolean h;

	void showValue(){
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + (int)c);
		System.out.println("d: " + d);
		System.out.println("e: " + e);
		System.out.println("f: " + f);
		System.out.println("g: " + g);
		System.out.println("h: " + h);
	}

	public static void main(String[] args) 
	{
		new F1().showValue();
	}
}
