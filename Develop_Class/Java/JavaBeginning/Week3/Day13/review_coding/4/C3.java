class C3 
{
	String name = "�θ�";
	C3(){
		super();
	}
	void m(){
		System.out.println("C3�� m()");
	}

}

class C3Child extends C3{
	String name = "�ڽ�";
	C3Child(){
		super.m();
		System.out.println("name: "+ super.name);
	}
	void m(){
		System.out.println("C3Child�� m()");
	}

	public static void main(String[] args) 
	{
		new C3Child();
	}
}
