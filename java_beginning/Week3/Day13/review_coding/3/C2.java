class C2 
{
	String name = "부모";
	C2(){
		super();
	}
	void m(){
		System.out.println("C2의 m()");
	}

}

class C2Child extends C2{
	String name = "자식";
	C2Child(){
		super.m();
		System.out.println("name: "+ super.name);
	}
	void m(){
		System.out.println("C2Child의 m()");
	}

	public static void main(String[] args) 
	{
		new C2Child();
	}
}
