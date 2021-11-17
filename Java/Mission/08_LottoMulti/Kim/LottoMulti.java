import java.io.*;
import java.util.*;

class LottoMulti  
{
	String fName = "우리반.txt";
	FileReader fr = null;
	
	LottoMulti(){
		try{
			fr = new FileReader(fName);
		}catch(FileNotFoundException fe){
			pln("파일 없음");
		}
	}

	ArrayList<String> al = new ArrayList<String>(); // 학생
	ArrayList<String> pick = new ArrayList<String>(); // 당첨자
	
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
		pln("뽑고싶은 당첨자의 수를 입력해주세요");
		int m = sc.nextInt();
		
		for(int k = 0; k < m; k++) { // 당첨자 뽑는 반복분
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
		for(String item : pick) pln("당첨자: " + item); //인핸스드루프
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) throws IOException{
		LottoMulti lm = new LottoMulti();
		lm.readF();
	}
}
