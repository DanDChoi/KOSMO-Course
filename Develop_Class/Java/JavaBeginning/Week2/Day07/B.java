class B 
{
	void m1(){
		for(int i=0; i<5; i++){
			if(i==2) continue;
			System.out.println("i: " + i);
		}
	}
	void m2(){
		aa:
		for(int k=0; k<2; k++){
			bb:
			for(int j=0; j<2; j++){
				for(int i=0; i<3; i++){
					if(i==1) continue aa;
					System.out.println("k: " + k + ", j: " + j + ", i: " + i);
				}
			}
		}
	}
	public static void main(String[] args) 
	{
		B b = new B();
		//b.m1();
		b.m2();
	}
}
