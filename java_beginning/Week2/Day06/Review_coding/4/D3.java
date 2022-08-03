class D3 
{
	void m1(){ //2窜
		for (int i=1; i<=9; i++){
			System.out.println("2 * "+i+" = " + 2*i);
		}
	}

	void m2(){ //备备窜
		for (int i=2; i<=9; i++){
			for (int j=1; j<=9; j++){
				System.out.println(i+" * "+j+" = "+i*j);
			}
		}
	}

	void m3(){ //备备备窜
		for(int q=2; q<=9; q++)
			for(int w=1; w<=9; w++)
				for(int e=1; e<=9; e++)
					System.out.println(q+" * "+w+" * "+e+" = "+q*w*e);
	}

	void m4(){ //m3 -> while
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
		D3 d3 = new D3();
		d3.m1();
		d3.m2();
		d3.m3();
		d3.m4();
	}
}
