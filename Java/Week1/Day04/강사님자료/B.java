class B 
{
	int i;
	B(int i){ //파라미터지역 
		System.out.println("i1: " + i);
		this.i = i;
	}
	void m(){
		System.out.println("i2: " + i);
		int j = 10; //선초지역 
		System.out.println("j: " + j);
	}

	public static void main(String[] args) 
	{
		B b = new B(5);
		b.m();
	}
}
