class ä��{
	String �̸�;
	int ����;

	ä��(){
		�̸� = "����";
		���� = 5000;
	}
	ä��(String �̸�, int ����){
		this.�̸� = �̸�;
		this.���� = ����;
	}
	void �ǰ��ϴ� (){
		System.out.println("�ǰ��ϴ�");
	}
	void �����ϴ� (){
		System.out.println("�����ϴ�");
	}
}

class D1{
	public static void main(String args[]){
		ä�� ä��1 = new ä��();
		System.out.print("������ " + ä��1.���� + "���� " + ä��1.�̸� + "�� ");
		ä��1.�ǰ��ϴ�();

		ä�� ä��2 = new ä��("���", 2000);
		System.out.print("������ " + ä��2.���� + "���� " + ä��2.�̸� + "�� " );
		ä��2.�����ϴ�();
	}
}