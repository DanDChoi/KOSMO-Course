class ����
{
	String �̸�;
	int ����;

	����(){
		�̸� = "����";
		���� = 15000;
	}
	����(String �̸�, int ����){
		this.�̸� = �̸�;
		this.���� = ����;
	}
	void �۴�(){
		System.out.println("�۴�");
	}
	void ���ִ�() {
		System.out.println("���ִ�");
	}
}

class D4
{
	public static void main(String[] args) 
	{
		���� ����1 = new ����();
		System.out.print("������ " +����1.����+ "���� " + ����1.�̸�+ "�� ");
		����1.�۴�();

		���� ����2 = new ����("�ܹ���", 5000);
		System.out.print("������ " + ����2.����+ "���� "+ ����2.�̸�+ "�� ");
		����2.���ִ�();
	}
}
