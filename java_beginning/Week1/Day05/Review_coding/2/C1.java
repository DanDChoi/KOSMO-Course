class C1 
{
	void m1(){
		int a = 50;
		switch(a){
			case 500: System.out.println("500"); break;
			case 5000: System.out.println("5000"); break;
			case 50: System.out.println("50"); break;
			default: System.out.println("it's not 500 or 5000");
		}
		System.out.println("switch ��");
	}
	void m2(){
		String str = "��";
		switch(str){
			case "��": System.out.println("a"); break;
			case "��": System.out.println("b"); break;
			case "��": System.out.println("c"); break;
		}
	}
	void m3(){
		int a = 30;
		char c = 'B';
		switch(a){
			case 30: System.out.println("30");
				switch(c){
					case 'A': System.out.println("A"); break;
					default : System.out.println("it's not A");
				}
				System.out.println("�� switch�� ����");
				break;
			case 20: System.out.println("20");
			default: System.out.println("30 or 20 �ƴϴ�");
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
		C1 c1 = new C1();
		c1.m1();
		c1.m2();
		c1.m3();
		c1.m4();
	}
}
