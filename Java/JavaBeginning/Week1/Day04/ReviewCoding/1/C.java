class C {
	byte b;
	void show(){
		b = (byte)1000;
		System.out.println("b: " + b);
	}
	public static void main(String[] args) 
	{
		new C().show();
	}
}
