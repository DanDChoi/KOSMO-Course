class C4 
{
	String name = "�θ�";
	C4(){
		super();
	}
	void m(){
		System.out.println("C4�� m()");
	}

}

class C4Child extends C4{
	String name = "�ڽ�";
	C4Child(){
		super.m();
		System.out.println("name: "+ super.name);
	}
	void m(){
		System.out.println("C4Child�� m()");
	}

	public static void main(String[] args) 
	{
		new C4Child();
	}
}
