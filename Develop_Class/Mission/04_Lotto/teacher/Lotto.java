import java.io.*;
import java.util.Random;

class Lotto
{
	String fName;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedReader brFile;
	FileReader fr;
	void inputFName(){
		p("#���� ���� �̸�(�⺻:�츮��): ");
		try{
			fName = br.readLine();
			if(fName != null) fName = fName.trim();
			if(fName.length() == 0) fName = "�츮��";
			fr = new FileReader(fName+".txt");
			brFile = new BufferedReader(fr);
		}catch(FileNotFoundException fe){
			System.out.println(fName+"������ ã�� �� ����");
			inputFName();
		}catch(IOException ie){
		}
	}

	Random r = new Random();
	int i;
	void setIndex(){
		int size = 0;
		try{
			String line = "";
			while ((line = brFile.readLine()) != null){
				size++;
			} 
		}catch(IOException ie){
		}
		i = r.nextInt(size); //0~(n-1) //0~29
	}
	void list(){
		try{
			fr = new FileReader(fName+".txt");
			brFile = new BufferedReader(fr);

			int i = 0; 
			while(true){
				String line = brFile.readLine();
				if(this.i == i){
					pln("��÷��: " + line);
					break;
				}
				i++;
			}
			//pln("#��: "+i+"��");
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
		Lotto lo = new Lotto();
		lo.inputFName();
		lo.setIndex();
		lo.list();
	}
}

