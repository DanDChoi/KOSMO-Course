class E4 
{
	E4(){}
	E4(String str){}
	E4(int i){}
	E4(String str, int i){}

	void m(String name){}
	int m(int age){
		System.out.println("m(int)");
		return age;
	}
	void m(short s){
		System.out.println("m(short)");	
	}
}
class E4Child extends E4
{
	void m(String name, int age)
}

class E4User{
	public static void main(String[] args) 
	{
		E4 e4 = new E4();
		short s = 10;
		e4.m(s);
	}
}
