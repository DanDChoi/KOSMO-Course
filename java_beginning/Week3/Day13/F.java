interface F  
{
	//(1) JDK7
	int i = 1; //���
	void m1(); //�߻�޼ҵ�

    //(2) JDK8
	static void m2(){} //static �޼ҵ� 
	default void m3(){} //default �޼ҵ� 
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
		/*F f = ??  //�������̽��� ��ü�� �����Ͻÿ� 

		System.out.println("f.i: " + f.i);
		f.m1();
		f.m2();
		f.m3();*/
	}
}
