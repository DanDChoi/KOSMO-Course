import java.util.Scanner;

class SC {

	String grade;
	int k,m,e,t,a;

	Scanner sc = new Scanner(System.in);

	void input(){

		System.out.print("����: ");
		k = sc.nextInt();
		System.out.print("����: ");
		m = sc.nextInt();
		System.out.print("����: ");
		e = sc.nextInt();
		t = k + m + e;
		a = t/3;

		try{
			
		}catch(NumberFormatException i){
			System.out.println("���ڸ� �Է����ּ���");
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
		
	System.out.println("����: " + t + ", ���: "+ a + ", ����: " + grade);
	}


	public static void main(String[] args) 
	{
		SC sca = new SC();
		sca.input();
	}
}
