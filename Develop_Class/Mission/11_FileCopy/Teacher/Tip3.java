import java.io.*;

class Tip3 
{
	String str = "aa/bb";
	void createD(){
		File f = new File(str);
		if(f.exists()){
			System.out.println("������");
		}else{
			System.out.println("������������.. ������(y/n)?");
			f.mkdirs();
		}
	}
	public static void main(String[] args) 
	{
		Tip3 t = new Tip3();
		t.createD();
	}
}