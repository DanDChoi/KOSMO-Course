import java.io.*;

class C4 
{
	String path = "/Users/Dan/Desktop/Develop/Develop_Class/Java/JavaAdvanced/Week1/Day02";
	File f;
	C4(){
		f = new File(path);
	}
	void show(){
		boolean b1 = f.exists();
		if(b1){
			pln("존재");
		}
		boolean b2 = f.isDirectory();
		if(b2){
			pln("디렉토리");
		}
	}
	void showChild(){
		File kids[] = f.listFiles();
		for(File kid : kids){
			if(kid.isDirectory()){
				pln("[D]" + kid.getName());
			}else{
				pln("[F]" + kid.getName());
			}
		}
	}
	void pln(String str){
		System.out.println(str); 
	}
	public static void main(String[] args) 
	{
		C4 c4 = new C4();
		c4.show();
		c4.showChild();
	}
}
