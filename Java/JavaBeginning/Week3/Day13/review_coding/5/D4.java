class D4 
{
	private void m(String name, int age){
		System.out.println("D4ÀÇ m()");
	}
}

class D4Child extends D4{
	private void m(String name, int age){
		System.out.println("D4ChildÀÇ m()");
	}
}

class D4User{
	public static void main(String[] args) 
	{
		D4 d4 = new D4Child();
		//d4.m("Ã¶¼ö", 30);
	}
}
