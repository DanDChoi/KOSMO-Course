import java.io.*;

//File 
class C 
{
	String path = "C:/SOO/Advanced";
	File f;
	C(){
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
		C c = new C();
		//c.show();
		c.showChild();
	}
}
