class A2 {
	int q = 1;
	static int w = 2;

	A2(){
	
	}
	void m(){
	}
}

class A2User
{
	public static void main(String[] args) {
		A2 a2 = new A2();
		System.out.println("a2.q: " + a2.q);
		System.out.println("A2.w: " + A2.w);
	}
}