class B4 
{
	int i;
	B4(int i){ //파라미터지
		System.out.println("i1: " + i);
		this.i = i;
	}
	void m(){
		System.out.println("i2: " + i);
		int j = 300; //선초
		System.out.println("j: " + j);
	}

	public static void main(String[] args) 
	{
		B4 b4 = new B4(50);
		b4.m();
	}
}
