interface AI1{
	void m1();
}
/*class AI1Child implements AI1 {
	public void m1(){
		System.out.println("m1()구현1");
	}
}*/
interface AI2{
	void m2(int i);
}
interface AI3{
	int m3(int i, int j);
}

class A {
	void use1(){
		/*AI1 ai1 = new AI1(){
			public void m1(){
				System.out.println("m1()구현1");
			}
		};*/
		//AI1 ai1 = () -> {System.out.println("m1()구현1");};
		AI1 ai1 = () -> System.out.println("m1()구현1");
		ai1.m1();
	}
	void use2(){
		AI2 ai2 = (i) -> {
			int r = i+1;
			System.out.println("m2()구현2 r: " + r);
		};
		ai2.m2(1);
	}
	void use3(){
		//AI3 ai3 = (i, j) -> { return i+j; };
		AI3 ai3 = (i, j) -> i+j;
		int sum = ai3.m3(10, 20);
		System.out.println("sum: " + sum);
	}

	void use33(){
		AI3 ai3 = (i, j) -> multiply(i,j);
		int mul = ai3.m3(10, 20);
		System.out.println("mul: " + mul);
	}
	int multiply(int i, int j){
		return i*j;
	}
	public static void main(String[] args) {
		A a = new A();
		//a.use1();
		//a.use2();
		//a.use3();
		a.use33();
	}
}
