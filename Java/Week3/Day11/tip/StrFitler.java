import java.io.*;
import java.util.*;

class StrFilter  
{
	String fName = "동물.txt";
	FileReader fr = null;
	StrFilter(){
		try{
			fr = new FileReader(fName);
			//pln("파일 존재");
			readF();
		}catch(FileNotFoundException fe){
			pln("파일 없음");
		}catch(IOException ie){
			pln("파일 읽는 중 예외 발생");
		}
	}

	Vector<String> v = new Vector<String>();
	void readF() throws IOException {
		BufferedReader br = null;
		br = new BufferedReader(fr);
		String line = "";
		while((line = br.readLine()) != null){
			line = line.trim();
			if(line.length() != 0) v.add(line);
		}

		out();
	}
	void out(){
		for(String item : v) pln("item: " + item);
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		StrFilter st = new StrFilter();
	}
}
