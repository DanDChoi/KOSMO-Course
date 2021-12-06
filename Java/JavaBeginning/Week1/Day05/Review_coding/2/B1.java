class B1 
{
	void m1(){
		int a = 5;
		int b = 53;
		boolean c = a==b;
		if(c){
			System.out.println("참");
		}else{
			System.out.println("거짓");
		} 
	}
	void m2(){
		int a = 3;
		if(a<0){
			System.out.println("음수");
		}else if(a>0){
			System.out.println("양수");
		}else{
			System.out.println("0");
		}
	}

	public static void main(String[] args) 
	{
		B1 b1 = new B1();
		b1.m1();
		b1.m2();
	}
}
