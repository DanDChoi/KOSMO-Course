import java.io.*;

class InObj
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	GradeThis g;
	InObj(GradeThis g){
		this.g = g;
	}
	void input(String subject){
		P.p(subject + ": ");
		try{
			String line = br.readLine();
			line = line.trim();
			int i = Integer.parseInt(line);
			if(i<0 || i>100){
				P.pln("0~100�� �����մϴ�");
				input(subject);
			}else{
				g.total = g.total + i;
			}
		}catch(IOException ie){
		}catch(NumberFormatException ne){
			P.pln("���ڸ� �Է��ϼ���");
			input(subject);
		}
	}
}