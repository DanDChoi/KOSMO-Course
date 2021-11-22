class 붕어빵틀 //클래스
{
	String 앙꼬 ; //멤버 (속성)
	int 가격; //멤버

	붕어빵틀(){
		앙꼬 = "팥";
		가격 = 500;
	}
	붕어빵틀(String 앙꼬, int 가격){
		this.앙꼬 = 앙꼬;
		this.가격 = 가격;
	}
	void 배부르게한다 (){ //메소드
		System.out.println("배부르게한다");
	}
	void 따스하게한다 (){ //메소드
		System.out.println("따스하게한다");
	}
}

class D 
{
	public static void main(String[] args) 
	{
		붕어빵틀 붕어빵1 = new 붕어빵틀(); //객체
		System.out.println("앙꼬가 " + 붕어빵1.앙꼬 + "이고 가격이 " + 붕어빵1.가격 + "원인 붕어빵이 ");
		붕어빵1.배부르게한다();

		붕어빵틀 붕어빵2 = new 붕어빵틀("슈크림", 700);
		System.out.println("앙꼬가 " + 붕어빵2.앙꼬 + "이고 가격이 " + 붕어빵2.가격 + "원인 붕어빵이 ");
		붕어빵2.따스하게한다();

	}
}
