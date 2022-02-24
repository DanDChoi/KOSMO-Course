class A 
{
	/*int is[]; //선언
	A(){
		is = new int[4]; //생성
	}

	int is[] = new int[4] //선언 및 생성

	void in(){ //초기화
		is[0] = 10;
		is[1] = 20;
		is[2] = 30;
		is[3] = 40;
	}
	*/
	int is[] = {10, 20, 30, 40}; //선언, 생성 및 초기화

	void out(){
		for (int i=0; i<4; i++){
		System.out.println("is["+i+"]: "+is[i]);
		}
	}
	public static void main(String[] args) 
	{
		A a = new A();
		a.in();
		a.out();
	}
}
