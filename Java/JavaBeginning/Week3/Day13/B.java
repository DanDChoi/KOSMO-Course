class B {
	int age;
	B(){
		this(20); //(3) 
	}
	B(int age){
		this.age = age; //(1)
		new BUser(this).use(); //(2)
	}
	void m(){
		System.out.println("m의 age " + age);
	}
	public static void main(String[] args) {
		new B();
	}
}

class BUser {
	B b;
	BUser(B b){
		this.b = b;
	}
	void use(){
		System.out.println("b.age: " + b.age); //멤버
		b.m(); //메소드
	}
}