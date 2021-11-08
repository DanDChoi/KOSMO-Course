class D 
{
	void m1(){ //2단을 출력
		for (int i=1; i<=9; i++){
			System.out.println("2 * "+i+"= " + 2*i);
		}
	}

	void m2(){ //99단을 출력
		for (int a=2; a<=9; a++){
			for (int b=1; b<=9; b++){
				System.out.println(a+" * "+b+"= "+b*a);
			}
		}
	}

	public static void main(String[] args) 
	{
		D d = new D();
		//d.m1();
		d.m2();
	}
}
