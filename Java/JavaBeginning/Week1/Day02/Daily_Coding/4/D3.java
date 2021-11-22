class 카페
{
	String 이름;
	int 가격;
	
	카페(){
		이름 = "아메리카노";
		가격 = 5000;
	}
	카페(String 이름, int 가격){
		this.이름 = 이름;
		this.가격 = 가격;
	}
	void 쓰다(){
		System.out.println("쓰다");
	}
	void 비싸다(){
		System.out.println("비싸다");
	}

}

class D3 
{
	public static void main(String[] args) 
	{
		카페 카페1 = new 카페();
		System.out.print("가격이 " +카페1.가격+ "원인 "+ 카페1.이름 + "는 ");
		카페1.비싸다();

		카페 카페2 = new 카페("카페라떼", 5500);
		System.out.print("가격이 "+ 카페2.가격+ "원인 " +카페2.이름 + "는 ");
		카페2.쓰다();
	}
}
