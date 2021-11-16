class B2 
{
	void m1(){
		for (int i=0; i<5; i++){
			if(i==2) continue;
			System.out.println("i: "+i);
		}
	}

	void m2(){
		aa:
		for(int k=0; k<2; k++){
			bb:
			for(int j=0; j<2; j++){
				for(int i=0; i<3; i++){
					if(i==1) countinue aa;
					System.out.println("k: "+k+", j: "+j+", i: "+i);
				}
			}
		}
	}

	public static void main(String[] args) 
	{
		B2 b2 = new B2();
		b2.m1();
		b2.m2();
	}
}
