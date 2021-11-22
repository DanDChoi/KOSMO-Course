class E3 
{
	E3(){}
	E3(String str){}
	E3(int i){}
	E3(String str, int i){}

	void m(String name){}
	int m(int age){
		System.out.println("m(int)");
		return age;
	}
	void m(short s){
		System.out.println("m(short)");	
	}
}
class E3Child extends E3
{
	void m(String name, int age)
}

class E3User{
	public static void main(String[] args) 
	{
		E3 e3 = new E3();
		short s = 10;
		e3.m(s);
	}
}
