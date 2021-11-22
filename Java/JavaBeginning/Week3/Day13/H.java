interface In
{
	void m1(); //추상메소드 
	default void m2(){ //default메소드 ( 이미 구현된 메소드 )
		System.out.println("m2()");
	}
}
class InChild implements In {
	public void m1(){
		System.out.println("m1()");
	}
	public void m2(){ //오버라이딩 
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
