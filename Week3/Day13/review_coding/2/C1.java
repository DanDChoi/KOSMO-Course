class C1 
{
	String name = "부모";
	C1(){
		super();
	}
	void m(){
		System.out.println("C1의 m()");
	}

}

class C1Child extends C1{
	String name = "자식";
	C1Child(){
		super.m();
		System.out.println("name: "+ super.name);
	}
	void m(){
		System.out.println("C1Child의 m()");
	}

	public static void main(String[] args) 
	{
		new C1Child();
	}
}
