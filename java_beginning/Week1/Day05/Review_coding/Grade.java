import java.io.*;

class Grade
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int total;
	int avg;
	String grade;

	Grade(){
		input("����");
		input("����");
		input("����");
		input("����");
		input("��ȸ");

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
		pln("����� ������ " + grade + "(����:"+total+", ���:"+avg+") �Դϴ�");
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
