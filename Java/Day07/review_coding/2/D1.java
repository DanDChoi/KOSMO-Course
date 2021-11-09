class D1 
{
	int m1(int i, int j){
		System.out.println("m1()");
		return i+j;
	}

	String m2(boolean flag){
		if(flag){
			return "½Â";
		}else{
			return "ÆÐ";
		}
	}

	void m3(){
		System.out.println("m3()");
	}
	
	public static void main(String[] args) 
	{
		D1 d1 = new D1();
		int result1 = d.m(1, 2);
		System.out.println("result1 : "+result1);
		String result2 = d.m2(true);
		System.out.println("result2: "+result2);
		d1.m3();
		System.out.println("main()");
	}
}
