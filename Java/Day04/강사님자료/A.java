class A {
	int i = 10; //¸â¹ö(°´Ã¼)
	static int j = 20; //¸â¹ö(Å¬·¡½º)

    A(){
		//System.out.println("i1: " + i); 
	}
	void m(){
		//System.out.println("i2: " + i); 
	}
}

class AUser
{
	public static void main(String[] args) {
		A a = new A();
		System.out.println("a.i: " + a.i);
		System.out.println("A.j: " + A.j);
	}
}
