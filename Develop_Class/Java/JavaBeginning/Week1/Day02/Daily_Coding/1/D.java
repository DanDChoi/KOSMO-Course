class 과일
{
	String 이름;
	int 가격;

	과일(){
		이름 = "사과";
		가격 = 1500;
	}
	과일(String 이름, int 가격){
		this.이름 = 이름;
		this.가격 = 가격;
	}
	void 맛있다 (){
		System.out.println("맛있다");
	}
	void 싸다 (){
		System.out.println("싸다");
	}
}

class D
{
	public static void main(String[] args) 
	{
		과일 과일1 = new 과일();
		System.out.print("가격이 " + 과일1.가격 + "원인 " + 과일1.이름 + "는 " );
		과일1.맛있다();

		과일 과일2 = new 과일("포도", 1000);
		System.out.print("가격이 " + 과일2.가격 + "원인 " + 과일2.이름 + "는 ");
		과일2.싸다();

	}
}