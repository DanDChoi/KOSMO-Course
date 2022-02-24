class 자동차 {
	String 색깔;
	자동차(){
		색깔 = "빨간색";
	}
	자동차(String 색깔){
		this.색깔 = 색깔;
	}
	void 빠르다(){
		System.out.println("빠르다");
	}
	void 멋지다(){
		System.out.println("멋지다");
	}
}

class 딜러 {
	int 나이;
	자동차 차1, 차2;
	딜러(){
		나이 = 30;
	}
	딜러(int 나이){
		this.나이 = 나이;
	}
	void 가지고있다() {
		차1 = new 자동차("파란색");
		차2 = new 자동차("흰색");
		System.out.println("자동차를 가지고 있다");
	}
	void 판다() {
		System.out.println("색깔이 " + 차1.색깔 + "인 자동차를 판다");
	}
}

class 손님 {
	int 돈;
	int 나이;
	손님(int 나이, int 돈){
		this.나이 = 나이;
		this.돈 = 돈;
	}
	void 사다(){
		System.out.println("손님이 샀다");
	}
	void 탄다(){
		System.out.println("손님이 탄다");
	}
}
class 신 {
	public static void main(String args[]){
		딜러 판매원 = new 딜러();
		System.out.print("나이가 "+ 판매원.나이 +"세인 딜러가 ");
		판매원.가지고있다();
		판매원.판다();
		System.out.print("그 차는 손님이 보기에 ");
		판매원.차1.멋지다();
		System.out.print("두번째 차의 색깔은 "+ 판매원.차2.색깔 + "이고 ");
		판매원.차2.빠르다();
		손님 손 = new 손님(30, 1000);
		System.out.print("나이가 " +손.나이+"살이고, 돈이 "+손.돈+"만원을 가진 ");
		손.사다();
	}
}
