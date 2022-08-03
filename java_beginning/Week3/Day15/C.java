interface CI{
	void m();
}

class C {
	void use(int i){
		int j = 2;
		//i = 11; //불가!! final 특성 
		//j = 22; //불가!! final 특성

		CI ci = () -> {
			System.out.println("i: " + i);
			System.out.println("j: " + j);
		};
		ci.m();
	}
	public static void main(String[] args) {
		C c = new C();
		c.use(1);
	}
}
