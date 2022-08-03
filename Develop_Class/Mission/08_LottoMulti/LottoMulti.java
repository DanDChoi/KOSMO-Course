import java.io.*;

interface Grade implements Input, Cal, Output {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int total;
	int avg;
	String grade;

	Grade(){
		input("����");
		input("����");
		input("����");

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
				pln("0~100�� �����մϴ�");
				input(subject);
			}else{
				total = total + i;
			}
		}catch(IOException ie){
		}catch(NumberFormatException ne){
			pln("���ڸ� �Է��ϼ���");
			input(subject);
		}
	}
}

class Cal {

	void cal(){ //if�� 
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
		pln("����� ������ "+grade+"(����:"+total+", ���:"+avg+") �Դϴ�");
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


//�����Է�(��ȿ��üũ) -> ����/���/���� -> ��� 

