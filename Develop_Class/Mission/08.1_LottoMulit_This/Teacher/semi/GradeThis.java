class GradeThis 
{
    int total;
	int avg;
	String grade;

	GradeThis(){
		InObj in = new InObj(this);
		in.input("����");
		in.input("����");
		in.input("����");

		cal();
		show();
	}
    void cal(){ //switch�� 
	   avg = total/3;
       int portion = avg/10;
       switch (portion){
		  case 10:
		  case 9:
			 grade = "A";
			 break;
		  case 8:
			 grade = "B";
			 break;
		  case 7:
			 grade = "C";
			 break;
		  case 6:
			 grade = "D";
			 break;
		  default:
			 grade = "F";
        }
	}
	void show(){
		pln("����� ������ "+grade+"(����:"+total+", ���:"+avg+") �Դϴ�");
	}
	void p(String str){
		System.out.print(str);
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		new GradeThis();
	}
}

