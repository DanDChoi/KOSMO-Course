class E1 {
	void m1(){
		System.out.println("m1()");
	}
}

class EChild extends E {
	@Override
	void m1(){
		System.out.println("m1(): overriding");
	}
	void m2(){
		System.out.println("m2()");
	}
}

class EUser {
	public static void main(String[] args) {
		EChild e = new EChild();
		e.m1(); 
		e.m2(); 
	}
}
