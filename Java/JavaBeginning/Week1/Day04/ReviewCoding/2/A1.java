class A1 {

	int x = 80; //¸â¹ö(°´Ã¼)
	static int y = 160; //¸â¹ö(Å¬·¡½º)

	A1(){
	
	}
	void m(){
	
	}
}
class A1User{

	public static void main(String[] args) 
	{
		A1 a1 = new A1();
		System.out.println("a1.x: " + a1.x);
		System.out.println("A1.y: " + A1.y);
	}
}
