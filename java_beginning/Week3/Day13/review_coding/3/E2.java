class E2 
{
	E2(){}
	E2(String str){}
	E2(int i){}
	E2(String str, int i){}

	void m(String name){}
	int m(int age){
		System.out.println("m(int)");
		return age;
	}
	void m(short s){
		System.out.println("m(short)");	
	}
}
class E2Child extends E2
{
	void m(String name, int age)
}

class E2User{
	public static void main(String[] args) 
	{
		E2 e2 = new E2();
		short s = 10;
		e2.m(s);
	}
}
