class AOut {
	int i = 0;
	void m(){
		System.out.println("m()");
	}

	class AIn1{
		int j = 1;
		void m1(){
			System.out.println("m1()");
		}
	}
	static class AIn2{
		static int k = 2;
		static void m2(){
			System.out.println("m2()");
		}	
	}
}

class A {
	public static void main(String args[]){
		AOut ao = new AOut();
		//System.out.println("ao.i: " + ao.i);
		//ao.m();

		AOut.AIn1 ai1 = ao.new AIn1(); //내부클래스 객체생성1
		System.out.println("ai1.j: " + ai1.j);
		ai1.m1();

		AOut.AIn2 ai2 = new AOut.AIn2();//내부클래스 객체생성2
		System.out.println("ai2.k: " + ai2.k); //객체로접근
		ai2.m2();
		System.out.println("AOut.AIn2.k: " + AOut.AIn2.k); //클래스로접근
		AOut.AIn2.m2();
	}
}
