class D1 
{
	private void m(String name, int age){
		System.out.println("D1ÀÇ m()");
	}
}

class D1Child extends D1{
	private void m(String name, int age){
		System.out.println("D1ChildÀÇ m()");
	}
}

class D1User{
	public static void main(String[] args) 
	{
		D1 d1 = new D1Child();
		//d1.m("Ã¶¼ö", 30);
	}
}
