class GradeThis 
{
    int total;
	int avg;
	String grade;

	GradeThis(){
		InObj in = new InObj(this); //자신의 객체를 다른 클래스에게 넘길 때
		in.input("국어");
		in.input("영어");
		in.input("수학");

        Cal c = new Cal();
		c.setG(this);//자신의 객체를 다른 클래스에게 넘길 때
		c.cal();

		show();
	}
	void show(){
		P.pln("당신의 학점은 "+grade+"(총점:"+total+", 평균:"+avg+") 입니당");
	}
	public static void main(String[] args) {
		new GradeThis();
	}
}

