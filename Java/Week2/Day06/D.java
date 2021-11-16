class D 
{
	void m1(){ //2단을 출력
		for (int i=1; i<=9; i++){
			System.out.println("2 * "+i+" = " + 2*i);
		}
	}

	void m2(){ //구구단을 출력
		for (int a=2; a<=9; a++){
			for (int b=1; b<=9; b++){
				System.out.println(a+" * "+b+" = "+b*a);
			}
		}
	}

	void m3(){ //구구구단 출력
		for(int q=2; q<=9; q++)
			for(int w=1; w<=9; w++)
				for(int e=1; e<=9; e++)
					System.out.println(q+" * "+w+" * "+e+" = "+q*w*e);
	}

	void m4(){ //m3() -> while문
		int z = 2;
		while(z<=9){
			int x = 1;
			while(x<=9){
				int c = 1;
				while(c<=9){
					System.out.println(z+" * "+x+" * "+c+" = "+z*x*c);
					c++;
				}
				x++;
			}
			z++;
		}
	}



	public static void main(String[] args) 
	{
		D d = new D();
		//d.m1();
		//d.m2();
		//d.m3();
		d.m4();
	}
}
