class �ڵ��� {
	String ����;
	�ڵ���(){
		���� = "������";
	}
	�ڵ���(String ����){
		this.���� = ����;
	}
	void ������(){
		System.out.println("������");
	}
	void ������(){
		System.out.println("������");
	}
}

class ���� {
	int ����;
	�ڵ��� ��1, ��2;
	����(){
		���� = 30;
	}
	����(int ����){
		this.���� = ����;
	}
	void �������ִ�() {
		��1 = new �ڵ���("�Ķ���");
		��2 = new �ڵ���("���");
		System.out.println("�ڵ����� ������ �ִ�");
	}
	void �Ǵ�() {
		System.out.println("������ " + ��1.���� + "�� �ڵ����� �Ǵ�");
	}
}

class �մ� {
	int ��;
	int ����;
	�մ�(int ����, int ��){
		this.���� = ����;
		this.�� = ��;
	}
	void ���(){
		System.out.println("�մ��� ���");
	}
	void ź��(){
		System.out.println("�մ��� ź��");
	}
}

class �� {
	public static void main(String args[]){
		���� �Ǹſ� = new ����();
		System.out.print("���̰� "+ �Ǹſ�.���� +"���� ������ ");
		�Ǹſ�.�������ִ�();
		�Ǹſ�.�Ǵ�();
		System.out.print("�� ���� �մ��� ���⿡ ");
		�Ǹſ�.��1.������();
		System.out.print("�ι�° ���� ������ "+ �Ǹſ�.��2.���� + "�̰� ");
		�Ǹſ�.��2.������();
		
		�մ� �� = new �մ�(30, 1000);
		System.out.print("���̰� " +��.����+"���̰�, ���� "+��.��+"������ ���� ");
		��.���();
	}
}
