class D {

	byte b = 10;
	short s = 20;
	char c = 'A';
	int i = 30;
	float f = 40.5f;
	
	int is[] = {b, s, c, i, (int)f}; //is: 멤버, 참조, 객체, 변수
	D(){
		//int is[] = {b, s, c, i}; //is: 지역(선언초기화), 참조형, 소속X, 변수
	}
	void out(){
		for (int i=0; i<5; i++){
			System.out.println("is["+i+"]: "+is[i]);
		}
	}

	public static void main(String[] args) 
	{
		new D().out();
	}
}
