class C3 {
	C3(){
		System.out.println("�Ƹ޸�ī��");
		m();
	}
	void m(){
		System.out.println("ī���");
		m2();
	}
	void m2(){
		System.out.println("īǪġ��");
	}
	public static void main(String[] args) 
	{
		System.out.println("������");
		System.out.println("����������");
		new C3();
		System.out.println("���Ƽ");
	}
}
