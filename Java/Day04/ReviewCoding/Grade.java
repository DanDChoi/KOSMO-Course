import java.util.Scanner;

class Grade{

	Scanner s = new Scanner(System.in);
	String g;
	int eng,math,tot,ave;

	void input(){
		System.out.print("영어: ");
		eng = s.nextInt();
		System.out.print("수학: ");
		math = s.nextInt();
		tot = eng + math;
		ave = tot/2;


		try{
		}catch(NumberFormatException ne){
			System.out.println("숫자만 입력하세요");
			input();
		}
		
		for(int i = 0; i < 4; i++) {
			if(ave>=90) {g = "A";}
			else if(ave>=80) {g = "B";}
			else if(ave>=70) {g = "C";}
			else if(ave>=60) {g = "D";}
			else g = "F";}
		
	System.out.println("총점: " + tot + ", 평균: "+ ave + ", 학점: " + g);
	}
	public static void main(String[] args)
	{
		Grade gr = new Grade();
		gr.input();
	}

}