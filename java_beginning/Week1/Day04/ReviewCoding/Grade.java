import java.util.Scanner;

class Grade{

	Scanner s = new Scanner(System.in);
	String g;
	int eng,math,tot,ave;

	void input(){
		System.out.print("����: ");
		eng = s.nextInt();
		System.out.print("����: ");
		math = s.nextInt();
		tot = eng + math;
		ave = tot/2;


		try{
		}catch(NumberFormatException ne){
			System.out.println("���ڸ� �Է��ϼ���");
			input();
		}
		
		for(int i = 0; i < 4; i++) {
			if(ave>=90) {g = "A";}
			else if(ave>=80) {g = "B";}
			else if(ave>=70) {g = "C";}
			else if(ave>=60) {g = "D";}
			else g = "F";}
		
	System.out.println("����: " + tot + ", ���: "+ ave + ", ����: " + g);
	}
	public static void main(String[] args)
	{
		Grade gr = new Grade();
		gr.input();
	}

}