class B {
	int age;
	B(){
		this(20);
	}
	B(int age){
		this.age = age;
		new BUser(this).use();
	}
	void m(){
		System.out.println("m¿« age" + age);
	}
	public static void main(String[] args) 
	{
		new B();
	}
}

class BUser
{
	B b;
	BUser(B b){
		this.b = b;
	}
	void use(){
		System.out.println("b.age: " + b.age);
		b.m();
	}
}
