class C 
{
	C(){
		m();
		System.out.println("2");
	}
	void m(){
		System.out.println("3");
	}
	public static void main(String[] args)
	{
		System.out.println("1");
		new C();
	}
}


//물 컵 = new 물();
//우유 컵 = new 우유();