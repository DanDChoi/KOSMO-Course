class A 
{
	A(){
		System.out.println("��");
	}
	void m(){
		System.out.println("��");
	}
	void m2(){
		System.out.println("��");
	}
	public static void main(String[] args) 
	{
		A a = new A();
		a.m();
		System.out.println("��");
		System.out.println("��");
		a.m2();
		System.out.println("��");
	}
}
