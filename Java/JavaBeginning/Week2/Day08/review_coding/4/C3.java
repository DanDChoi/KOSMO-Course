class C3 {

	byte bs[] = new byte[2];
	short ss[] = new short[2];
	char cs[] = new char[2];
	int is[] = new int[2];
	long ls[] = new long[2];
	float fs[] = new float[2];
	double ds[] = new double[2];
	boolean flags[] = new boolean[2];
	String strs[] = new String[2];

	void out(){
		System.out.println("bs[0]: "+ bs[0]);
		System.out.println("ss[0]: "+ ss[0]);
		System.out.println("cs[0]: "+ cs[0]);
		System.out.println("is[0]: "+ is[0]);
		System.out.println("ls[0]: "+ ls[0]);
		System.out.println("fs[0]: "+ fs[0]);
		System.out.println("ds[0]: "+ ds[0]);
		System.out.println("flags[0]: "+ flags[0]);
		System.out.println("strs[0]: "+ strs[0]);
	}

	public static void main(String[] args) 
	{
		C3 c3 = new C3();
		c3.out();
	}
}