package aa.cc;

import aa.bb.A; //클래스 접근

class A1User extends A1
{
	A1User(){
		super(); //생성자접근
	}
	void use(){
		System.out.println("i: " + i); //멤버 접근 
		m(); //메소드 접근
	}
	public static void main(String[] args) 
	{
		A1User u = new A1User();
		u.use();
	}
}
