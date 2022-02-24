class B1 {

	int x;
	B1(int x){
		System.out.println("x1: " + x);
		this.x = x;
	}
	void m(){
		System.out.println("x2: " + x);
		int y = 60;
		System.out.println("y: " + y);
	}

	public static void main(String[] args) 
	{
	 B1 b1 = new B1(123);
	 b1.m();
	}
}
