import java.io.*;

interface Grade implements Input, Cal, Output {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int total;
	int avg;
	String grade;

	Grade(){
		input("국어");
		input("영어");
		input("수학");

		cal();
		show();
	}

class Input {
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
}

class Cal {

	void cal(){ //if문 
		avg = total/3;
		if(avg >= 90){
			grade = "A";
		}else if(avg >= 80) {
			grade = "B";
		}else if(avg >= 70) {
			grade = "C";
		}else if(avg >= 60) {
			grade = "D";
		}else{
			grade = "F";
		}
	}
}


class Output  {
	
	void show(){
		pln("당신의 학점은 "+grade+"(총점:"+total+", 평균:"+avg+") 입니당");
	}
	void p(String str){
		System.out.print(str);
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		new Grade();
	}
}


//점수입력(유효성체크) -> 총점/평균/학점 -> 출력 

