class E1 
{
	E1(){}
	E1(String str){}
	E1(int i){}
	E1(String str, int i){}

	void m(String name){}
	int m(int age){
		System.out.println("m(int)");
		return age;
	}
	void m(short s){
		System.out.println("m(short)");	
	}
}
class E1Child extends E1
{
	void m(String name, int age)
}

class E1User{
	public static void main(String[] args) 
	{
		E1 e1 = new E1();
		short s = 10;
		e1.m(s);
	}
}
