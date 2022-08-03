package SSB;

import java.io.*;
import java.util.*;


public class Ssb_word {
	FileReader fr;
	BufferedReader br;
	String[] tt;

	Ssb_word(String word){
		try{
			fr = new FileReader("imgs/ssb/words_K.txt");
			br = new BufferedReader(fr);
		}catch(FileNotFoundException fe){
			System.out.println("파일을 찾을 수 없습니다.");
		}
	}
	
	public String[] setWord() {
		List<String> w = new ArrayList<String>(); //파일이 몇라인인지 알수 없으니 그것을 리스트에 담는다
		try{
			String line = ""; 
			while((line = br.readLine()) != null){ 
				//line = line.replaceAll(" ", ""); // 모든 공백제거 
				//line = line.replaceAll("\\p{Z}", ""); // 모든 공백제거
				//line = line.replaceAll("(^\\p{Z}+|\\p{Z}+$)", ""); // 앞 뒤 공백제거
				line = line.trim(); // 앞 뒤 공백제거
				w.add(line); //리스트에 공백제거된 단어를 넣는다
			}
			tt= w.toArray(new String[w.size()]); //리스트에 있는 단어를 스트링 배열에 설정
		}catch(IOException ie){
		}finally{
			try{
				if(br != null) br.close();
				if(fr != null) fr.close();
			}catch(IOException ie){}
		}
		return tt; // 스트링 배열을 리턴한다
	}
}
