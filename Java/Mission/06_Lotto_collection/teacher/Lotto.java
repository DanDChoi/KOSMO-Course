import java.io.*;
import java.util.*;

class Lotto
{
	String fName;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedReader brFile;
	FileReader fr;
	Vector<String> v = new Vector<String>();
	Random r = new Random();
	
	void inputFName(){
		p("#읽을 파일 이름(기본:우리반): ");
		try{
			fName = br.readLine();
			if(fName != null) fName = fName.trim();
			if(fName.length() == 0) fName = "우리반";
			fr = new FileReader(fName+".txt");
			brFile = new BufferedReader(fr);
		}catch(FileNotFoundException fe){
			System.out.println(fName+"파일을 찾을 수 없음");
			inputFName();
		}catch(IOException ie){
		}
	}

	void in(){
		try{
			String line = null;
			while((line =brFile.readLine()) != null){
				if(line != null) line = line.trim();
				if(line.length() != 0) v.add(line);
			}
		}catch(IOException ie){
		}
	}
	void out(){
		for(String name : v) System.out.println(name);
	}
	void select(){
		int i = r.nextInt(v.size()); //0~ (size-1)
		String selector = v.get(i);
		System.out.println("당첨자: " + selector);
	}
	
    void p(String str){
		System.out.print(str);
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		Lotto lo = new Lotto();
		lo.inputFName(); //(1)리스트를 파일이름을 입력 받는다
		lo.in(); //(2)저장소(v)에 이름들을 넣는다
		//lo.out(); //(3)저장소의 이름들을 출력해본다
		lo.select(); //(4)임의의 1명을 뽑아서 출력한다
	}
}

