class C4 {
	C4(){
		System.out.println("����");
		m();
	}
	void m(){
		System.out.println("�ܹ���");
		m2();
	}
	void m2(){
		System.out.println("����Ƣ��");
	}
	public static void main(String[] args) 
	{
		System.out.println("�ݶ�");
		System.out.println("���");
		new C4();
		System.out.println("���̴�");
	}
}
