class C4 
{
	void m1(){
		int a = 1000;
		switch(a){
			case 100: System.out.println("100"); break;
			case 1000: System.out.println("1000"); break;
			case 10: System.out.println("10"); break;
			default: System.out.println("it's not 10 or 100");
		}
		System.out.println("switch 밖");
	}
	void m2(){
		String str = "1";
		switch(str){
			case "1": System.out.println("a"); break;
			case "2": System.out.println("b"); break;
			case "3": System.out.println("c"); break;
		}
	}
	void m3(){
		int a = 50;
		char c = 'B';
		switch(a){
			case 50: System.out.println("50");
				switch(c){
					case 'A': System.out.println("A"); break;
					default : System.out.println("it's not A");
				}
				System.out.println("안 switch블럭 나옴");
				break;
			case 20: System.out.println("20");
			default: System.out.println("50 or 20 아니다");
		}
		System.out.println("밖 switch블럭 나옴");
	}
	void m4(){
		int i = 10;
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
		C4 c4 = new C4();
		c4.m1();
		c4.m2();
		c4.m3();
		c4.m4();
	}
}
