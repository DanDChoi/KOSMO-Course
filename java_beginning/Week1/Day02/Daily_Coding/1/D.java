class ����
{
	String �̸�;
	int ����;

	����(){
		�̸� = "���";
		���� = 1500;
	}
	����(String �̸�, int ����){
		this.�̸� = �̸�;
		this.���� = ����;
	}
	void ���ִ� (){
		System.out.println("���ִ�");
	}
	void �δ� (){
		System.out.println("�δ�");
	}
}

class D
{
	public static void main(String[] args) 
	{
		���� ����1 = new ����();
		System.out.print("������ " + ����1.���� + "���� " + ����1.�̸� + "�� " );
		����1.���ִ�();

		���� ����2 = new ����("����", 1000);
		System.out.print("������ " + ����2.���� + "���� " + ����2.�̸� + "�� ");
		����2.�δ�();

	}
}