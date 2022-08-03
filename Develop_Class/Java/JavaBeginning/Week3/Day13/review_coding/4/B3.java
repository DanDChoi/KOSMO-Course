class B3  
{
	int age;
	B3(){
		this(20);
	}
	B3(int age){
		this.age = age;
		new B3User(this).use();
	}
	void m(){
		System.out.println("m¿« age " + age);
	}

	public static void main(String[] args) 
	{
		new B3();
	}
}

class B3User
{
	B3 b3;
	B3User(B3 b3){
		this.b3 = b3;
	}
	void use(){
		System.out.println("b3.age: " + b3.age);
		b3.m();
	}
}
