class A 
{
	void m1(){ //신사 (초기식 이후에 바로 바디로 가지않고 조건식을 비교 후 실행)
		int i = 0; //초기식
		while(i<5){ //조건식
			i = i + 1; // i+=1; , i++; 증감식
			System.out.println("i: "+ i);
		}
	}

	void m2(){ //신사 
		for(int i=0; i<5; i++)
			System.out.println("i: "+i);
	}


	void m3(){ //조폭
		int i = 0; //초기식
		do{
			System.out.println("i: "+i);
			i ++; //증감식
		}while(i<5);
	}

	
	public static void main(String[] args) 
	{
		A a = new A();
		//a.m1();
		//a.m2();
		a.m3();
	}
}
