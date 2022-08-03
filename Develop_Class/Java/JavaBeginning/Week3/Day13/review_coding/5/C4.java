class C4 
{
	String name = "부모";
	C4(){
		super();
	}
	void m(){
		System.out.println("C4의 m()");
	}

}

class C4Child extends C4{
	String name = "자식";
	C4Child(){
		super.m();
		System.out.println("name: "+ super.name);
	}
	void m(){
		System.out.println("C4Child의 m()");
	}

	public static void main(String[] args) 
	{
		new C4Child();
	}
}
