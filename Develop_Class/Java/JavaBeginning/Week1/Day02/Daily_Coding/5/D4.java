class 음식
{
	String 이름;
	int 가격;

	음식(){
		이름 = "피자";
		가격 = 15000;
	}
	음식(String 이름, int 가격){
		this.이름 = 이름;
		this.가격 = 가격;
	}
	void 작다(){
		System.out.println("작다");
	}
	void 맛있다() {
		System.out.println("맛있다");
	}
}

class D4
{
	public static void main(String[] args) 
	{
		음식 음식1 = new 음식();
		System.out.print("가격이 " +음식1.가격+ "원인 " + 음식1.이름+ "는 ");
		음식1.작다();

		음식 음식2 = new 음식("햄버거", 5000);
		System.out.print("가격이 " + 음식2.가격+ "원인 "+ 음식2.이름+ "는 ");
		음식2.맛있다();
	}
}
