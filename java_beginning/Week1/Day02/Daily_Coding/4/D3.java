class ī��
{
	String �̸�;
	int ����;
	
	ī��(){
		�̸� = "�Ƹ޸�ī��";
		���� = 5000;
	}
	ī��(String �̸�, int ����){
		this.�̸� = �̸�;
		this.���� = ����;
	}
	void ����(){
		System.out.println("����");
	}
	void ��δ�(){
		System.out.println("��δ�");
	}

}

class D3 
{
	public static void main(String[] args) 
	{
		ī�� ī��1 = new ī��();
		System.out.print("������ " +ī��1.����+ "���� "+ ī��1.�̸� + "�� ");
		ī��1.��δ�();

		ī�� ī��2 = new ī��("ī���", 5500);
		System.out.print("������ "+ ī��2.����+ "���� " +ī��2.�̸� + "�� ");
		ī��2.����();
	}
}
