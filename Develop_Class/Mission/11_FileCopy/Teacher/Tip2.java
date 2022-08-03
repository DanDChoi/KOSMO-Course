import java.io.*;

class Tip2 
{
	String str = "C:/SOO/행정/자료실/[이전기수]가산_15강의실_210528.xlsx";
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