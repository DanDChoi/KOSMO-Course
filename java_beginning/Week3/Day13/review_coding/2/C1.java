class C1 
{
	String name = "�θ�";
	C1(){
		super();
	}
	void m(){
		System.out.println("C1�� m()");
	}

}

class C1Child extends C1{
	String name = "�ڽ�";
	C1Child(){
		super.m();
		System.out.println("name: "+ super.name);
	}
	void m(){
		System.out.println("C1Child�� m()");
	}

	public static void main(String[] args) 
	{
		new C1Child();
	}
}
