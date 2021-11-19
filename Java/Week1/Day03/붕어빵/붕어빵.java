class 붕어빵 {
	String 앙꼬;
	붕어빵(){
		앙꼬 = "팥";
	}
	붕어빵(String 앙꼬){
		this.앙꼬 = 앙꼬;
	}
	void 배부르게한다(){
		System.out.println("배부르게한다");
	}
}
class 사장 {
	int 나이;
	붕어빵 빵1, 빵2;
	사장(){
		나이 = 50;
	}
	사장(int 나이){
		this.나이 = 나이;
	}
    void 만든다(){
		빵1 = new 붕어빵("설탕");
		빵2 = new 붕어빵("고구마");
		System.out.println("붕어빵을 만들고 있다");
	}
	void 판다(){
		System.out.println("앙꼬가 " + 빵1.앙꼬 + "인 붕어빵을 판다");
		System.out.println("앙꼬가 " + 빵2.앙꼬 + "인 붕어빵을 판다");
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
		System.out.println("손님이 산다");
	}
	void 먹는다(){
		System.out.println("손님이 먹는다");
	}
}
class 신 {
	public static void main(String args[]){
		사장 주인 = new 사장(45);
		System.out.print("나이가 "+주인.나이+"세인 사장님이 ");
		주인.만든다();
		주인.판다();
		System.out.print("그 빵은 손님들을 ");
		주인.빵1.배부르게한다();
		System.out.println("두번째 구운빵의 앙꼬는 "+ 주인.빵2.앙꼬 + "이다");

		손님 손 = new 손님(8, 1000);
		System.out.print("나이가 "+손.나이+"살이고, 돈이 "+손.돈+"원을 가진 ");
		손.사다();
	}
}

