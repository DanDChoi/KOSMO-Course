import java.io.*;

class Tip2 
{
	String str = "C:/SOO/����/�ڷ��/[�������]����_15���ǽ�_210528.xlsx";
	void del(){
		File f = new File(str);
		f.delete();
	}
	public static void main(String[] args) 
	{
		Tip2 t = new Tip2();
		t.del();
	}
}