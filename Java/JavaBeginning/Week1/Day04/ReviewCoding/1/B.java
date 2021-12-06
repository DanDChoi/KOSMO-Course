class  B{
	int i;
	B(int i){ //파라미터
		System.out.println("i1: " + i);
		this.i = i;
	}
	void m() {
		System.out.println("i2: "+ i);
		int j = 1000; //선언초기화
		System.out.println("j: " +j);
	}

	public static void main(String[] args) 
	{
		B b = new B(500);
		b.m();
	}
}
