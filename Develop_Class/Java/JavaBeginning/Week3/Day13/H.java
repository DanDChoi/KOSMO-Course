interface In
{
	void m1(); //�߻�޼ҵ� 
	default void m2(){ //default�޼ҵ� ( �̹� ������ �޼ҵ� )
		System.out.println("m2()");
	}
}
class InChild implements In {
	public void m1(){
		System.out.println("m1()");
	}
	public void m2(){ //�������̵� 
		System.out.println("overriding : m2()");
	}
}

class H 
{
	public static void main(String[] args) 
	{
		In iObj = new InChild();
		iObj.m1();
		iObj.m2();
	}
}
