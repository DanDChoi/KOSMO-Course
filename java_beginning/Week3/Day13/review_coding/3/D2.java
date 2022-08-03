class D2 
{
	private void m(String name, int age){
		System.out.println("D2ÀÇ m()");
	}
}

class D2Child extends D2{
	private void m(String name, int age){
		System.out.println("D2ChildÀÇ m()");
	}
}

class D2User{
	public static void main(String[] args) 
	{
		D2 d2 = new D2Child();
		//d2.m("Ã¶¼ö", 30);
	}
}
