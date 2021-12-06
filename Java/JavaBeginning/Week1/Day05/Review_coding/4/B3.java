class B3 
{
	void m1(){
		int i = 2;
		int j = 2;
		boolean b = i==j;
		if(b){
			System.out.println("참");
		}else{
			System.out.println("거짓");
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
		B3 b3 = new B3();
		b3.m1();
		b3.m2();
	}
}
