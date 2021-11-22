class  C1 {

	byte x;
	void show(){
		x = (byte)12345;
		System.out.println("x: " + x);
	}
	public static void main(String[] args) 
	{
		new C1().show();
	}
}
