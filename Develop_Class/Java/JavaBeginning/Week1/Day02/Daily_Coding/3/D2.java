class ����
{
	String �̸�;
	int ����;

	����(){
		�̸� = "����";
		���� = 10;
	}
	����(String �̸�, int ����){
		this.�̸� = �̸�;
		this.���� = ����;
	}
	void ������ (){
		System.out.println("������");
	}
	void ������ (){
		System.out.println("������");
	}
}


class D2
{
	public static void main(String[] args) 
	{
		���� ����1 = new ����();
		System.out.print("���̰� " + ����1.���� + "���� " + ����1.�̸� + "�� ");
		����1.������();

		���� ����2 = new ����("ȣ����", 5);
		System.out.print("���̰� " + ����2.���� + "���� " + ����2.�̸� + "�� ");
		����2.������();
	}
}
