import java.io.*;

class Tip1 
{
	String str = "/Users/Dan/Desktop/Develop/Develop_Class/Java/JavaAdvanced/Week1/Day01/IO.jpg";
	void getFname(){
		int i = str.lastIndexOf("/");
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