import java.io.*;
import java.util.*;

class Listing 
{
	String fName = "우리반";
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedReader brFile;
	Random r = new Random();
	String name;

	void inputFName(){
		FileReader fr = null;
		p("#읽을 파일 이름: ");
		try{
			fName = br.readLine();
			if(fName != null) fName = fName.trim();
			fr = new FileReader(fName+".txt");
			brFile = new BufferedReader(fr);
		}catch(FileNotFoundException fe){
			System.out.println(fName+"파일을 찾을 수 없음");
			inputFName();
		}catch(IOException ie){
		}
	}
	void list(){
		try{
			int i = r.nextInt(30); 
			for (int j=1; j<=30; j++){
				String name = brFile.readLine();
				if(i==j) break;
			}
			pln("당첨자: " + name);
		}catch(IOException ie){
		}
	}
    void p(String str){
		System.out.print(str);
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		Listing li = new Listing();
		li.inputFName();
		li.list();
	}
}
