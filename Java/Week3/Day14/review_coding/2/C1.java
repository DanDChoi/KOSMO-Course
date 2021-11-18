class COut {
	private int i1 = 0;
	private void m1(){
		System.out.println("m1()");
	}
	private static int i2 = 1;
	private static void m2(){
		System.out.println("m2()");
	}

	class CIn1{
		void use(){ 
			System.out.println("i1: " + i1);
			m1();	
			System.out.println("i2: " + i2);
			m2();
		}
	}
	private static class CIn2{
		void use(){
			System.out.println("i2: " + i2);
			m2();
		}
		public static void main(String[] args) {
			COut.CIn2 ci = new COut.CIn2();
			ci.use();
		}
	}
}
class C1 {
	public static void main(String[] args) {
		COut.CIn1 ci = new COut().new CIn1();
		ci.use();
	}
}
