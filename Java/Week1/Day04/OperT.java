class OperT 
{
	// + , - , * , / , % 
	void m1(){
		int j = 100; //점수1
		int k = 100; //점수2

		int t = j + k; //총점 
        int a = t/2; //평균
	    String grade = m2(a); //학점
		System.out.println("총점: " + t + ", 평균: "+a + ", 학점: " + grade);
	}
	String m2(int a){
		if(a>=90) return "A";
		else if(a>=80) return "B";
		else if(a>=70) return "C";
		else if(a>=60) return "D";
		else return "F";
	}
	public static void main(String[] args) {
		OperT op = new OperT();
		op.m1();
	}
}
