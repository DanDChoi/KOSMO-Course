import java.io.*;

class Tip1 
{
	String str = "C:\\SOO\\Java\\�����ڹ�.java";
	void getFname(){
		int i = str.lastIndexOf("\\");
		System.out.println("i: " + i);
		String fname = str.substring(i+1);
		System.out.println("�����̸�: " + fname);
	}
	public static void main(String[] args) 
	{
		Tip1 t = new Tip1();
		t.getFname();
	}
}
