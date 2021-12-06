class B2Out {
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

		int m = 3;
		void m3(){
			System.out.println("m3()");
		}

		public static void main(String args[]){	
			System.out.println("BIn2.k: " + BIn2.k);
			BIn2.m2();

			B2Out.BIn2 bi2 = new B2Out.BIn2();
			System.out.println("bi2.m: " + bi2.m);
			bi2.m3();
		}
	}
}