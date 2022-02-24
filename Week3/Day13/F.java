interface F  
{
	//(1) JDK7
	int i = 1; //상수
	void m1(); //추상메소드

    //(2) JDK8
	static void m2(){} //static 메소드 
	default void m3(){} //default 메소드 
}
class FChild implements F
{
	public void m1(){
		System.out.println("m1()");
	}
}

class FUser
{
	public static void main(String args[]){
		/*F f = ??  //인터페이스의 객체를 생성하시오 

		System.out.println("f.i: " + f.i);
		f.m1();
		f.m2();
		f.m3();*/
	}
}
