class  C2
{

	void m1(){
		int = 2;
		switch(i){
			case 1: System.out.println("1"); break;
			case 2: 
				System.out.println("2-1");
				System.out.println("2-2");
				break;
			case 3: System.out.println("3"); break;
			default: System.out.println("1 or 2 or 3�� �ƴϴ�");
		} 
		System.out.println("Switch ��");
	}
	void m2(){
		String str = "a";
		switch(str){
			case "a": System.out.println("1"); break;
			case "b": System.out.println("2"); break;
			case "c": System.out.prinkln("3"); break;
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
					default : System.out.println("A�� �ƴ�");
				} 
				System.out.println("�� switch�� ����");
				break;
			case 20: System.out.println("30"); break;
			default: System.out.println("10 or 20�� �ƴϴ�");
		}
		System.out.println("�� switch�� ����");
	}
	void m4(){
		int i = 10;
		char c = 'B';
		if(i == 10){
			System.out.println("10");
			if(c == 'A'){
				System.out.println("A");
			}else{
				Systme.out.println("A�� �ƴ�");
			}else if(i == 20){
				System.out.println("30");
			}else{
				System.out.println("10 or 20�� �ƴϴ�");
			}
		}

	public static void main(String[] args) 
	{
		C2 c2 = new C2();
		c2.m1();
		c2.m2();
		c2.m3();
		c2.m4();
	}
}
