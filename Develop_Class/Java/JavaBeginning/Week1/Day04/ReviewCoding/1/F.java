class F {

	byte b;
	short s;
	char c;
	int i;
	long lo;
	float f;
	double d;
	boolean flag; //JVM의 초기화

	void showValue(){
		System.out.println("b: "+b);
		System.out.println("s: "+s);
		System.out.println("c: "+c); //(int)c로 바꾸면 결과값 확인가능
		System.out.println("i: "+i);
		System.out.println("lo: "+lo);
		System.out.println("f: "+f);
		System.out.println("d: "+d);
		System.out.println("flag: "+flag);
	}

	public static void main(String[] args) 
	{
		new F().showValue();
	}
}
