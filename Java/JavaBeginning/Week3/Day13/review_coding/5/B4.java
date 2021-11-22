class B4  
{
	int age;
	B4(){
		this(20);
	}
	B4(int age){
		this.age = age;
		new B4User(this).use();
	}
	void m(){
		System.out.println("m¿« age " + age);
	}

	public static void main(String[] args) 
	{
		new B4();
	}
}

class B4User
{
	B4 b4;
	B4User(B4 b4){
		this.b4 = b4;
	}
	void use(){
		System.out.println("b4.age: " + b4.age);
		b4.m();
	}
}
