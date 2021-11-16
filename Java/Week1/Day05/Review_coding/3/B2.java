class B2 
{
	void m1(){
		int i = 5;
		int j = 5;
		boolean b = i==j;
		if(b){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
	}

	void m2(){
		int i = 0;
		if(i<0){
			System.out.println("음수");
		}else if(i>0){
			System.out.println("양수");
		}else{
			System.out.println("0");
		}
	}

	public static void main(String[] args) 
	{
		B2 b2 = new B2();
		b2.m1();
		b2.m2();
	}
}
