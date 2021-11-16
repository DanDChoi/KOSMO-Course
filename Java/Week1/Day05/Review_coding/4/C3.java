class C3 
{
	void m1(){
		int a = 70;
		switch(a){
			case 7000: System.out.println("7000"); break;
			case 700: System.out.println("700"); break;
			case 70: System.out.println("70"); break;
			default: System.out.println("it's not 700 or 7000");
		}
		System.out.println("switch 밖");
	}
	void m2(){
		String str = "q";
		switch(str){
			case "q": System.out.println("ㅂ"); break;
			case "w": System.out.println("ㅈ"); break;
			case "e": System.out.println("ㅅ"); break;
		}
	}
	void m3(){
		int a = 20;
		char c = 'B';
		switch(a){
			case 30: System.out.println("30");
				switch(c){
					case 'A': System.out.println("A"); break;
					default : System.out.println("it's not A");
				}
				System.out.println("안 switch블럭 나옴");
				break;
			case 20: System.out.println("20");
			default: System.out.println("30 or 20 아니다");
		}
		System.out.println("밖 switch블럭 나옴");
	}
	void m4(){
		int i = 20;
		char c = 'B';
		if(i == 10){
			System.out.println("10");
			if(c == 'A'){
				System.out.println("A");
			}else{
				System.out.println("it's not A");
			}
		}else if(i == 20){
			System.out.println("30");
		}else{
			System.out.println("it's not 10 or 20");
		}
	}
	public static void main(String[] args) 
	{
		C3 c3 = new C3();
		c3.m1();
		c3.m2();
		c3.m3();
		c3.m4();
	}
}
