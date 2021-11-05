class A4 {
	int i = 789; //¸â¹ö(°´Ã¼)
	static int j = 123; //¸â¹ö(Å¬·¡½º)

    A4(){
		//System.out.println("i1: " + i); 
	}
	void m(){
		//System.out.println("i2: " + i); 
	}
}

class A4User
{
	public static void main(String[] args) {
		A4 a4 = new A4();
		System.out.println("a.i: " + a4.i);
		System.out.println("A.j: " + A4.j);
	}
}
