class BOut {
	int i = 0;
	void m(){
		System.out.println("m()");
	}

	private class BIn1{
		int j = 1;
		void m1(){
			System.out.println("m1()");
		}
	}
	private static class BIn2{
		static int k = 2;
		static void m2(){
			System.out.println("m2()");
		}	
	}
}
class B {
	public static void main(String args[]){

		BOut.BIn1 bi1 = new BOut().new BIn1(); //내부클래스 객체생성1
		System.out.println("bi1.j: " + bi1.j);
		bi1.m1();

		BOut.BIn2 bi2 = new BOut.BIn2();//내부클래스 객체생성2
		System.out.println("bi2.k: " + bi2.k); //객체로접근
		bi2.m2();
		System.out.println("BOut.BIn2.k: " + BOut.BIn2.k); //클래스로접근
		BOut.BIn2.m2();
	}
}
