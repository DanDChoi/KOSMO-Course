import java.io.*;

class Tip3 
{
	String str = "aa/bb";
	void createD(){
		File f = new File(str);
		if(f.exists()){
			System.out.println("존재함");
		}else{
			System.out.println("존재하지않음.. 만들까요(y/n)?");
			f.mkdirs();
		}
	}
	public static void main(String[] args) 
	{
		Tip3 t = new Tip3();
		t.createD();
	}
}