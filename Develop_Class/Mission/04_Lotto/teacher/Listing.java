import java.io.*;

class Listing 
{
	String fName = "�츮��";
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedReader brFile;
	void inputFName(){
		FileReader fr = null;
		p("#���� ���� �̸�: ");
		try{
			fName = br.readLine();
			if(fName != null) fName = fName.trim();
			fr = new FileReader(fName+".txt");
			brFile = new BufferedReader(fr);
		}catch(FileNotFoundException fe){
			System.out.println(fName+"������ ã�� �� ����");
			inputFName();
		}catch(IOException ie){
		}
	}
	void list(){
		try{
			int i = 0; 
			while(true){
				String line = brFile.readLine();
				if(line == null) break;
				pln(line);
				i++;
			}
			pln("#��: "+i+"��");
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
