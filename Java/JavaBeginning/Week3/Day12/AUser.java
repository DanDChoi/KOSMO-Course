package aa.cc;

import aa.bb.A; //클래스 접근

class AUser extends A
{
	AUser(){
		super(); //생성자접근
	}
	void use(){
		System.out.println("i: " + i); //멤버 접근 
		m(); //메소드 접근
	}
	public static void main(String[] args) 
	{
		AUser u = new AUser();
		u.use();
	}
}
