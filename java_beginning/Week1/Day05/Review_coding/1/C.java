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
			defalut : System.out.println("10 or 20 or 30�� �ƴϴ�"); //����Ʈ ��ġ�� ������� case�� ���ϰ� �������� ����
		} 
		System.out.println("switch ��");
	}
	void m2(){
		String str = "����";
		switch(str){
			case "ȣ����": System.out.println("�Ͼ��"); break;
			case "����": System.out.println("�����"); break;
			case "�⸰": System.out.println("������"); break;
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
					default : System.out.println("A�� �ƴ�");
				}
				System.out.println("�� swtich ������");
			break;
			default : System.out.println("10 or 20 �� �ƴϴ�");
		}
		System.out.println("switch ��");
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
					default : System.out.println("A�� �ƴ�");
				}
			System.out.println("�� switch ������");
		}else{
			System.out.println("10 or 20 �� �ƴϴ�");

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
