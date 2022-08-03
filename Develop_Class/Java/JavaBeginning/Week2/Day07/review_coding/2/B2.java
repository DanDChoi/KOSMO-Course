class B1 
{
	void m1(){
		for (int i=0; i<5; i++){
			if(i==2) continue;
			System.out.println("i: "+i);
		}
	}

	void m2(){
		aa:
		for (int c=0; c<2; c++)
		{ bb:
			for (int b=0; b<2; b++)
			{
				for (a=0; a<3; a++)
				{
					if(a==1) continue aa;
					System.out.println("c: "+c+", b: "+b+", a: "+a)
				}
			}
		}
	}
	public static void main(String[] args) 
	{
		B1 b1 = new B1();
		b1.m1();
		b1.m2();
	}
}
