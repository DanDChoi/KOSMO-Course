class C3 
{
	String name = "부모";
	C3(){
		super();
	}
	void m(){
		System.out.println("C3의 m()");
	}

}

class C3Child extends C3{
	String name = "자식";
	C3Child(){
		super.m();
		System.out.println("name: "+ super.name);
	}
	void m(){
		System.out.println("C3Child의 m()");
	}

	public static void main(String[] args) 
	{
		new C3Child();
	}
}
