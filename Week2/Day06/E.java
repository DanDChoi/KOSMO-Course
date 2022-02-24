class E 
{
	void m1(){
		System.out.print("* ");
		System.out.print("* ");
		System.out.print("* ");
		System.out.print("* ");
		System.out.println();
	}
	void m2(){
		for (int i = 0; i<4; i++){
			for (int j = 0; j<4; j++){
					System.out.print("* ");
			}
			System.out.println();
		}
		
	}
	public static void main(String[] args) 
	{
		E e = new E();
		//e.m1();
		e.m2();
	}
}
