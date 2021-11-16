class 채소{
	String 이름;
	int 가격;

	채소(){
		이름 = "양파";
		가격 = 5000;
	}
	채소(String 이름, int 가격){
		this.이름 = 이름;
		this.가격 = 가격;
	}
	void 건강하다 (){
		System.out.println("건강하다");
	}
	void 저렴하다 (){
		System.out.println("저렴하다");
	}
}

class D1{
	public static void main(String args[]){
		채소 채소1 = new 채소();
		System.out.print("가격이 " + 채소1.가격 + "원인 " + 채소1.이름 + "는 ");
		채소1.건강하다();

		채소 채소2 = new 채소("당근", 2000);
		System.out.print("가격이 " + 채소2.가격 + "원인 " + 채소2.이름 + "은 " );
		채소2.저렴하다();
	}
}