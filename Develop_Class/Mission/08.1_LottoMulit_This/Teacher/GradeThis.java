class GradeThis 
{
    int total;
	int avg;
	String grade;

	GradeThis(){
		InObj in = new InObj(this); //�ڽ��� ��ü�� �ٸ� Ŭ�������� �ѱ� ��
		in.input("����");
		in.input("����");
		in.input("����");

        Cal c = new Cal();
		c.setG(this);//�ڽ��� ��ü�� �ٸ� Ŭ�������� �ѱ� ��
		c.cal();

		show();
	}
	void show(){
		P.pln("����� ������ "+grade+"(����:"+total+", ���:"+avg+") �Դϴ�");
	}
	public static void main(String[] args) {
		new GradeThis();
	}
}

