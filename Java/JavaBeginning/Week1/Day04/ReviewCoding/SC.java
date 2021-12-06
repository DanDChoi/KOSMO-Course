import java.util.Scanner;

class SC {

	String grade;
	int k,m,e,t,a;

	Scanner sc = new Scanner(System.in);

	void input(){

		System.out.print("국어: ");
		k = sc.nextInt();
		System.out.print("수학: ");
		m = sc.nextInt();
		System.out.print("영어: ");
		e = sc.nextInt();
		t = k + m + e;
		a = t/3;

		try{
			
		}catch(NumberFormatException i){
			System.out.println("숫자만 입력해주세요");
			input();
		}
		
		for(int i = 0; i < 4; i++) {
			if(a>=90) {
				grade = "A";
			}
			else if(a>=80) {
				grade = "B";
			}
			else if(a>=70) {
				grade = "C";
			}
			else if(a>=60) {
				grade = "D";
			}
			else grade = "F";
		}
		
	System.out.println("총점: " + t + ", 평균: "+ a + ", 학점: " + grade);
	}


	public static void main(String[] args) 
	{
		SC sca = new SC();
		sca.input();
	}
}
