class C {
	String name = "ȫ�浿";
	C(){
		super(); //(1)
	}
	void m(){ //�������̵� �� 
		System.out.println("C�� m()");
	}
}
class CChild extends C{
	String name = "�̼���";
	CChild(){
		super.m();
		System.out.println("name: " +super.name);
	}
	void m(){ //�������̵� �� 
		System.out.println("CChild�� m()");
	}	
	public static void main(String[] args) {
		new CChild();
	}
}
