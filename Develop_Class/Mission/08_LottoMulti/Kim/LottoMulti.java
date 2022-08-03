import java.io.*;
import java.util.*;

class LottoMulti  
{
	String fName = "�츮��.txt";
	FileReader fr = null;
	
	LottoMulti(){
		try{
			fr = new FileReader(fName);
		}catch(FileNotFoundException fe){
			pln("���� ����");
		}
	}

	ArrayList<String> al = new ArrayList<String>(); // �л�
	ArrayList<String> pick = new ArrayList<String>(); // ��÷��
	
	void readF() throws IOException {
		BufferedReader br = null;
		br = new BufferedReader(fr);
		String line = "";
		while((line = br.readLine()) != null){
			line = line.trim();
			al.add(line);
		}
		random();
	}
	
	Scanner sc = new Scanner(System.in);
	void random() {
		Random r = new Random();
		pln("�̰���� ��÷���� ���� �Է����ּ���");
		int m = sc.nextInt();
		
		for(int k = 0; k < m; k++) { // ��÷�� �̴� �ݺ���
			int n = r.nextInt(30);
			
			int flag = 0;
			for(int a = 0; a < pick.size(); a++) {
				if(pick.get(a).equals(al.get(n))) {
					k--;
					flag = 1;
				}
			}
			
			if(flag == 1) {
				flag = 0;
				continue;
			}
			
			pick.add(al.get(n));
			
		}
		out();
	}
	void out(){
		for(String item : pick) pln("��÷��: " + item); //���ڽ������
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) throws IOException{
		LottoMulti lm = new LottoMulti();
		lm.readF();
	}
}
