class D4 
{
	private void m(String name, int age){
		System.out.println("D4�� m()");
	}
}

class D4Child extends D4{
	private void m(String name, int age){
		System.out.println("D4Child�� m()");
	}
}

class D4User{
	public static void main(String[] args) 
	{
		D4 d4 = new D4Child();
		//d4.m("ö��", 30);
	}
}
