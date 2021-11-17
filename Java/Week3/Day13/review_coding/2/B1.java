class B1  
{
	int age;
	B1(){
		this(20);
	}
	B1(int age){
		this.age = age;
		new B1User(this).use();
	}
	void m(){
		System.out.println("m¿« age " + age);
	}

	public static void main(String[] args) 
	{
		new B1();
	}
}

class B1User
{
	B1 b1;
	B1User(B1 b1){
		this.b1 = b1;
	}
	void use(){
		System.out.println("b1.age: " + b1.age);
		b1.m();
	}
}
