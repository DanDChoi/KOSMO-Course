class D
{

	int m1(int i, int j){
		System.out.println("m1()");
		return i+j;
	}

	String m2(boolean flag){
		if(flag){
			return "½Â";
		}else {
			return "ÆÐ";
		}
	}

	void m3(){
		System.out.println("m3()");
	}

	public static void main(String[] args) 
	{
		D d = new D();
		int result1 = d.m(10, 20);
		System.out.println("result1: "+ result1);
		String result2 = d.m2(true);
		System.out.println("result2: "+ result2);
		d.m3();
		System.out.println("main()");
	}
}
