import java.io.*;
import java.util.Random;

class Lotto
{
	String fName;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedReader brFile;
	FileReader fr;
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
			String arr[] = new String[30];


			while(true){
				String line = brFile.readLine();
				arr[i] = line;
			
				if(this.i == i){
					pln("당첨자: " + arr[i]);
					break;
				}i++;
			}
			
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

