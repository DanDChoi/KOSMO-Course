class D2 
{
	private void m(String name, int age){
		System.out.println("D2�� m()");
	}
}

class D2Child extends D2{
	private void m(String name, int age){
		System.out.println("D2Child�� m()");
	}
}

class D2User{
	public static void main(String[] args) 
	{
		D2 d2 = new D2Child();
		//d2.m("ö��", 30);
	}
}
