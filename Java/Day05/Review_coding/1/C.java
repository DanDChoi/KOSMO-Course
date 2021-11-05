class C 
{
	void m1(){
		byte b = 10;
		char c = 'A';
		int i = 20;
		switch(i) {
			case 10: System.out.println("10"); break;
			case 20:
				System.out.println("20");
				System.out.println("20");
				break;
			case 30: System.out.println("30"); break;
			defalut : System.out.println("10 or 20 or 30이 아니다"); //디폴트 위치는 관계없음 case와 비교하고 마지막에 실행
		} 
		System.out.println("switch 밖");
	}
	void m2(){
		String str = "사자";
		switch(str){
			case "호랑이": System.out.println("하얀색"); break;
			case "사자": System.out.println("노란색"); break;
			case "기린": System.out.println("점박이"); break;
		}
	}
	void m3(){
		int i = 20;
		char a = 'B';
		switch(i){
			case 10: System.out.println("10"); break;
			case 20: System.out.println("20");
				switch(a){
					case 'A': System.out.println("A"); break;
					default : System.out.println("A는 아님");
				}
				System.out.println("안 swtich 블럭나옴");
			break;
			default : System.out.println("10 or 20 이 아니다");
		}
		System.out.println("switch 밖");
	}
	void m4(){
		int i = 20;
		char a = 'B';
		if(i == 10){
			System.out.println("10");
		}else if(i == 20){
			case 20: System.out.println("20");
				switch(a){
					case 'A': System.out.println("A"); break;
					default : System.out.println("A는 아님");
				}
			System.out.println("안 switch 블럭나옴");
		}else{
			System.out.println("10 or 20 이 아니다");

		}
	}
	public static void main(String[] args) 
	{
		C c = new C();
		//c.m1();
		//c.m2();
		//c.m3();
		c.m4();
	}
}
