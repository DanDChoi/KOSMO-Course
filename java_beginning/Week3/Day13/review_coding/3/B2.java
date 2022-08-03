class B2  
{
	int age;
	B2(){
		this(20);
	}
	B2(int age){
		this.age = age;
		new B2User(this).use();
	}
	void m(){
		System.out.println("m¿« age " + age);
	}

	public static void main(String[] args) 
	{
		new B2();
	}
}

class B2User
{
	B2 b2;
	B2User(B2 b2){
		this.b2 = b2;
	}
	void use(){
		System.out.println("b2.age: " + b2.age);
		b2.m();
	}
}
