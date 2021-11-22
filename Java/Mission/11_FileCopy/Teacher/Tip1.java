import java.io.*;

class Tip1 
{
	String str = "C:\\SOO\\Java\\수스자바.java";
	void getFname(){
		int i = str.lastIndexOf("\\");
		System.out.println("i: " + i);
		String fname = str.substring(i+1);
		System.out.println("파일이름: " + fname);
	}
	public static void main(String[] args) 
	{
		Tip1 t = new Tip1();
		t.getFname();
	}
}
