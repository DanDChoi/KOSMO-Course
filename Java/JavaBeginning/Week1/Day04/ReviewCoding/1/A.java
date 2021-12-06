class A {
	int i = 1;
	static int j = 2;

	A(){
		System.out.println("i1: "+ i);
	}
	void m(){
		System.out.println("i2: "+ i);
	}
}

class AUser {

	public static void main(String[] args) 	{
		A a = new A();
		a.m();
		System.out.println("a.i: " + a.i);
		System.out.println("A.j: " + A.j);
	}
}
