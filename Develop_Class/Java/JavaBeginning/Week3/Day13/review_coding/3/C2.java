class C2 
{
	String name = "�θ�";
	C2(){
		super();
	}
	void m(){
		System.out.println("C2�� m()");
	}

}

class C2Child extends C2{
	String name = "�ڽ�";
	C2Child(){
		super.m();
		System.out.println("name: "+ super.name);
	}
	void m(){
		System.out.println("C2Child�� m()");
	}

	public static void main(String[] args) 
	{
		new C2Child();
	}
}
