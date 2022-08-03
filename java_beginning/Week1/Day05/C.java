class C 
{
	void m1(){
		int i = 20;
		switch(i){
			case 10: System.out.println("10"); break;
			case 20: 
				System.out.println("20-1");  
				System.out.println("20-2"); 
				break;
			case 30: System.out.println("30"); break;
			default: System.out.println("10 or 20 or 30은 아니다");
		}
		System.out.println("switch밖");
	}
	void m2(){
	    String str = "여행";
		switch(str){
			case "연애": System.out.println("병철"); break;
		    case "여행": System.out.println("제학"); break;
			case "스포츠": System.out.println("수환"); break;
		}
	}
	void m3(){
		int i = 10;
		char c = 'B';
		switch(i){
			case 10: 
				System.out.println("10"); 
			    switch(c){
					case 'A': System.out.println("A"); break;
					default : System.out.println("A는 아님");
				}
				System.out.println("안 switch블럭 나옴");
				break;
			case 20: System.out.println("30"); break;
			default: System.out.println("10 or 20아니다");
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
				System.out.println("A는 아님");
			}
		}else if(i == 20){
			System.out.println("30"); 
		}else{
			System.out.println("10 or 20아니다");
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
