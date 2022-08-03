import java.io.*;

class Grade
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int total;
	int avg;
	String grade;

	Grade(){
		input("국어");
		input("영어");
		input("수학");
		input("과학");
		input("사회");

		cal();
		show();
	}
	void input(String subject){
		p(subject + ": ");
		try{
			String line = br.readLine();
			line = line.trim(); 
			int i = Integer.parseInt(line);
			if(i<0 || i>100){
				pln("0~100점 가능합니다");
				input(subject);
			}else{
				total = total + i;
			}
		}catch(IOException ie){  
		}catch(NumberFormatException ne){
			pln("숫자만 입력하세요");
			input(subject);
		}
	}

	void cal(){
		avg = total/5;
		switch(avg/10){
			case 10: grade = "A"; break;
			case 9: grade = "B"; break;
			case 8: grade = "C"; break;
			case 7: grade = "D"; break;
			default: grade = "F"; 
		}
	}

	void show(){
		pln("당신의 학점은 " + grade + "(총점:"+total+", 평균:"+avg+") 입니다");
	}
	void p(String str){
		System.out.print(str);
	}
	void pln(String str){
		System.out.println(str);
	}


	public static void main(String[] args) 
	{
		new Grade();
	}
}
