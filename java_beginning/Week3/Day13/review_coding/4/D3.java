class D3 
{
	private void m(String name, int age){
		System.out.println("D3�� m()");
	}
}

class D3Child extends D3{
	private void m(String name, int age){
		System.out.println("D3Child�� m()");
	}
}

class D3User{
	public static void main(String[] args) 
	{
		D3 d3 = new D3Child();
		//d3.m("ö��", 30);
	}
}
