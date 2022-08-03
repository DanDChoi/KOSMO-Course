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
			System.out.println("������ ã�� �� �����ϴ�.");
		}
	}
	
	public String[] setWord() {
		List<String> w = new ArrayList<String>(); //������ ��������� �˼� ������ �װ��� ����Ʈ�� ��´�
		try{
			String line = ""; 
			while((line = br.readLine()) != null){ 
				//line = line.replaceAll(" ", ""); // ��� �������� 
				//line = line.replaceAll("\\p{Z}", ""); // ��� ��������
				//line = line.replaceAll("(^\\p{Z}+|\\p{Z}+$)", ""); // �� �� ��������
				line = line.trim(); // �� �� ��������
				w.add(line); //����Ʈ�� �������ŵ� �ܾ �ִ´�
			}
			tt= w.toArray(new String[w.size()]); //����Ʈ�� �ִ� �ܾ ��Ʈ�� �迭�� ����
		}catch(IOException ie){
		}finally{
			try{
				if(br != null) br.close();
				if(fr != null) fr.close();
			}catch(IOException ie){}
		}
		return tt; // ��Ʈ�� �迭�� �����Ѵ�
	}
}
